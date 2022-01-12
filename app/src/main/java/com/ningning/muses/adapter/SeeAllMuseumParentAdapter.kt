package com.ningning.muses.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.data.MuseumSection
import com.ningning.muses.databinding.MuseumSeeAllParentRecyclerViewBinding
import com.ningning.muses.utils.DiffUtilCompare

class SeeAllMuseumParentAdapter : RecyclerView.Adapter<SeeAllMuseumParentAdapter.ViewHolder>() {
    private var recyclerViewPool = RecyclerView.RecycledViewPool()
    private var museumSections = emptyList<MuseumSection>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SeeAllMuseumParentAdapter.ViewHolder {
        val binding = MuseumSeeAllParentRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeeAllMuseumParentAdapter.ViewHolder, position: Int) {
        holder.bind(museumSections[position], position)
    }

    override fun getItemCount(): Int {
        return museumSections.size
    }

    inner class ViewHolder(private val binding: MuseumSeeAllParentRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(museumSection: MuseumSection, position: Int) {
            with(binding) {
                binding.section.text = museumSection.section
                binding.section.textSize = 20F

                val childLayoutManager = LinearLayoutManager(childRecyclerview.context, LinearLayoutManager.HORIZONTAL, false)
                binding.childRecyclerview.apply {
                    layoutManager = childLayoutManager
                    adapter = SeeAllMuseumChildAdapter(museumSection.list)
                    canScrollHorizontally(0)
                    canScrollVertically(0)
                    setRecycledViewPool(recyclerViewPool)
                }
            }
        }
    }

    fun setData(museumSections: List<MuseumSection>) {
        val diffUtil = DiffUtilCompare(museumSections, this.museumSections)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        this.museumSections = museumSections
        diffUtilResult.dispatchUpdatesTo(this)
    }

}