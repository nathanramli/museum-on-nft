package com.ningning.muses.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ningning.muses.R
import com.ningning.muses.TicketDetailActivity
import com.ningning.muses.data.Ticket
import com.ningning.muses.databinding.TicketItemLayoutBinding
import com.ningning.muses.utils.DiffUtilCompare

class MyTicketAdapter : RecyclerView.Adapter<MyTicketAdapter.ViewHolder>() {
    private var tickets = emptyList<Ticket>()

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val binding =
            TicketItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tickets[position], position)
    }

    inner class ViewHolder(private val binding: TicketItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ticket: Ticket, position: Int) {
            with(binding) {
                museumName.text = ticket.museum.name
                museumLocation.text = ticket.museum.location
                ticketExpiration.text = "Valid until " + ticket.expired

                if (!ticket.isValid) {
                    topItemTicket.setBackgroundResource(R.drawable.my_ticket_background_top_invalid)
                    ticketUseButton.setBackgroundColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.silver
                        )
                    )
                    ticketUseButton.setTextColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.white
                        )
                    )

                    binding.ticketUseButton.setOnClickListener(null)
                } else {
                    topItemTicket.setBackgroundResource(R.drawable.my_ticket_background_top)
                    ticketUseButton.setBackgroundColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.lightning_yellow
                        )
                    )
                    ticketUseButton.setTextColor(
                        ContextCompat.getColor(
                            root.context,
                            R.color.white
                        )
                    )

                    binding.ticketUseButton.setOnClickListener {
                        val bottomSheet = BottomSheetDialog(root.context)
                        val view = LayoutInflater.from(binding.root.context)
                            .inflate(R.layout.fragment_bottom_sheet_dialog, null)
                        view.findViewById<Button>(R.id.noButton)?.setOnClickListener {
                            bottomSheet.dismiss()
                        }
                        view.findViewById<Button>(R.id.yesButton)?.setOnClickListener {
                            val context = binding.root.context
                            bottomSheet.dismiss()
                            context.startActivity(Intent(context, MuseumObjectActivity::class.java))
                        }
                        bottomSheet.setContentView(view)
                        bottomSheet.show()
                    }
                }
            }

            binding.root.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, TicketDetailActivity::class.java)
                intent.putExtra("data", ticket)
                context.startActivity(intent)
            }

            if (position == tickets.size - 1) {
                val params = itemView.layoutParams as ViewGroup.MarginLayoutParams
                params.setMargins(36, 20, 36, 50)
                itemView.layoutParams = params
            }
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return tickets.size
    }


    fun setData(tickets: List<Ticket>) {
        val diffUtil = DiffUtilCompare(tickets, this.tickets)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        this.tickets = tickets
        diffUtilResult.dispatchUpdatesTo(this)
    }
}