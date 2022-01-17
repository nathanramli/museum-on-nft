package com.ningning.muses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.ningning.muses.data.Ticket
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.adapter.MyTicketAdapter
import com.ningning.muses.data.MUSEUMS
import com.ningning.muses.databinding.FragmentMyTicketBinding

class MyTicketFragment : Fragment() {
    private var _binding: FragmentMyTicketBinding? = null
    private val binding get() = _binding!!

    private lateinit var ticketAdapter: MyTicketAdapter

    private val tickets = listOf(
        Ticket("January 20, 2022", true, MUSEUMS[0]),
        Ticket("January 21, 2022", true, MUSEUMS[2]),
        Ticket("January 13, 2022", true, MUSEUMS[3]),
        Ticket("January 16, 2022", false, MUSEUMS[4]),
        Ticket( "January 14, 2022", false, MUSEUMS[1]),
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
            }
        })
    }

    private fun setActiveCategory(button: Int) {
        if (button == 1) {
            binding.showAllTicket.setTextColor(ContextCompat.getColor(binding.root.context, R.color.lightning_yellow))
            binding.showAllTicket.setStrokeColorResource(R.color.lightning_yellow)
        } else {
            binding.showAllTicket.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            binding.showAllTicket.setStrokeColorResource(R.color.white)
        }

        if (button == 2) {
            binding.showInvalidTicket.setTextColor(ContextCompat.getColor(binding.root.context, R.color.lightning_yellow))
            binding.showInvalidTicket.setStrokeColorResource(R.color.lightning_yellow)
        } else {
            binding.showInvalidTicket.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            binding.showInvalidTicket.setStrokeColorResource(R.color.white)
        }

        if (button == 3) {
            binding.showValidTicket.setTextColor(ContextCompat.getColor(binding.root.context, R.color.lightning_yellow))
            binding.showValidTicket.setStrokeColorResource(R.color.lightning_yellow)
        } else {
            binding.showValidTicket.setTextColor(ContextCompat.getColor(binding.root.context, R.color.white))
            binding.showValidTicket.setStrokeColorResource(R.color.white)
        }
    }

    private fun setupButtonListener() {
        binding.showAllTicket.setOnClickListener {
            ticketAdapter.setData(tickets)
            ticketAdapter.notifyDataSetChanged()
            setActiveCategory(1)
        }

        binding.showInvalidTicket.setOnClickListener {
            var invalidTickets = mutableListOf<Ticket>()
            for (i in tickets) {
                if (!i.isValid)
                    invalidTickets.add(i)
            }
            ticketAdapter.setData(invalidTickets)
            ticketAdapter.notifyDataSetChanged()
            setActiveCategory(2)
        }

        binding.showValidTicket.setOnClickListener{
            var validTickets = mutableListOf<Ticket>()
            for (i in tickets) {
                if (i.isValid)
                    validTickets.add(i)
            }
            ticketAdapter.setData(validTickets)
            ticketAdapter.notifyDataSetChanged()
            setActiveCategory(3)
        }

    }
}