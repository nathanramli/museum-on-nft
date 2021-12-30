package com.ningning.muses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ningning.muses.data.Ticket
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.databinding.FragmentMyTicketBinding

class MyTicketFragment : Fragment() {
    private var _binding: FragmentMyTicketBinding? = null
    private val binding get() = _binding!!

    private lateinit var ticketAdapter: MyTicketAdapter

    private val tickets = listOf(
        Ticket("Van Gogh Museum", "Amsterdam, Netherlands", "January 20, 2022", true),
        Ticket("British Museum", "London, England", "January 21, 2022", true),
        Ticket("Vatican Museums", "Amsterdam, Netherlands", "January 13, 2022", true),
        Ticket("Louvre Museum", "Paris, France", "January 16, 2022", false),
        Ticket("The Metropolitan Museum", "Paris, France", "January 14, 2022", false),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMyTicketBinding.inflate(inflater, container, false)
        ticketAdapter = MyTicketAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialRecyclerView()
        ticketAdapter.setData(tickets)

        setupButtonListener()

        recyclerViewScrollListener()
    }

    private fun initialRecyclerView() {
        binding.recyclerViewTicket.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTicket.setHasFixedSize(true)
        binding.recyclerViewTicket.adapter = ticketAdapter
    }

    private fun recyclerViewScrollListener() {
        binding.recyclerViewTicket.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    // make the appbar stay stick at top
                } else {
                    // make the appbar stay stick at top
                }
            }
        })
    }

    private fun setupButtonListener() {
        binding.showAllTicket.setOnClickListener(View.OnClickListener {
            ticketAdapter.setData(tickets)
            ticketAdapter.notifyDataSetChanged()
        })

        binding.showInvalidTicket.setOnClickListener(View.OnClickListener {
            var invalidTickets = mutableListOf<Ticket>()
            for (i in tickets) {
                if (!i.isValid)
                    invalidTickets.add(i)
            }
            ticketAdapter.setData(invalidTickets)
            ticketAdapter.notifyDataSetChanged()
        })

        binding.showValidTicket.setOnClickListener(View.OnClickListener {
            var validTickets = mutableListOf<Ticket>()
            for (i in tickets) {
                if (i.isValid)
                    validTickets.add(i)
            }
            ticketAdapter.setData(validTickets)
            ticketAdapter.notifyDataSetChanged()
        })

    }
}