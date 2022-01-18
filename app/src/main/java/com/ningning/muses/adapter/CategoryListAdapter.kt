package com.ningning.muses.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.data.CATEGORY_ITEMS
import com.ningning.muses.data.CategoryItem
import com.ningning.muses.databinding.CategoryItemLayoutBinding
import com.ningning.muses.utils.DiffUtilCompare

class CategoryListAdapter : RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {
    private var categories = emptyList<CategoryItem>()
    private var isChecked = MutableList(CATEGORY_ITEMS.size) { false }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            CategoryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position], position)
    }

    inner class ViewHolder(private val binding: CategoryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: CategoryItem, position: Int) {
            binding.root.layoutParams.width = GridLayout.LayoutParams.MATCH_PARENT

            with(binding) {
                categoryText.text = category.name
                categoryText.isChecked = isChecked[position]
                categoryText.setOnClickListener {
                    isChecked[position] = categoryText.isChecked
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun setData(categories: List<CategoryItem>) {
        val diffUtil = DiffUtilCompare(categories, this.categories)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        this.categories = categories
        diffUtilResult.dispatchUpdatesTo(this)
    }
}