package com.ningning.muses.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.MuseumDetailActivity
import com.ningning.muses.data.Museum
import com.ningning.muses.databinding.MuseumSeeAllChildRecyclerViewBinding

class SeeAllMuseumChildAdapter(private var museums: List<Museum>) : RecyclerView.Adapter<SeeAllMuseumChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SeeAllMuseumChildAdapter.ViewHolder {
        val binding = MuseumSeeAllChildRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeeAllMuseumChildAdapter.ViewHolder, position: Int) {
        holder.bind(museums[position], position)
    }

    inner class ViewHolder(private val binding: MuseumSeeAllChildRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(museum: Museum, position: Int) {
            with(binding) {
                museumCardName.text = museum.name
                museumCardLocation.text = museum.location
                museumCardPicture.setImageResource(museum.image)
            }
            binding.root.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(binding.root.context, MuseumDetailActivity::class.java)
                intent.putExtra("data", museum)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return museums.size
    }
}