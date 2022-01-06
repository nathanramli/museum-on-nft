package com.ningning.muses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.data.Museum
import com.ningning.muses.databinding.MuseumItemLayoutBinding
import com.ningning.muses.utils.DiffUtilCompare

class RecommendedMuseumAdapter : RecyclerView.Adapter<RecommendedMuseumAdapter.ViewHolder>() {
    private var museums = emptyList<Museum>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = MuseumItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(museums[position], position)
    }

    inner class ViewHolder(private val binding: MuseumItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(museum: Museum, position: Int) {
            with(binding) {
                binding.root.layoutParams.width = 450
                binding.root.layoutParams.height = 300
                museumCardName.text = museum.name
                museumCardName.textSize = 10F
                museumCardLocation.text = museum.location
                museumCardLocation.textSize = 7F
                museumCardPicture.setImageResource(museum.image)
            }
        }
    }

    override fun getItemCount(): Int {
        return museums.size
    }

    fun setData(museums: List<Museum>) {
        val diffUtil = DiffUtilCompare(museums, this.museums)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        this.museums = museums
        diffUtilResult.dispatchUpdatesTo(this)
    }
}