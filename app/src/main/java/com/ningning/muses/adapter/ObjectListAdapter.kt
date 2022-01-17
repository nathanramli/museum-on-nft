package com.ningning.muses.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.MuseumObjectActivity
import com.ningning.muses.data.MuseumObject
import com.ningning.muses.databinding.MuseumItemLayoutBinding
import com.ningning.muses.utils.DiffUtilCompare
import com.squareup.picasso.Picasso

class ObjectListAdapter : RecyclerView.Adapter<ObjectListAdapter.ViewHolder>() {
    private var objects = emptyList<MuseumObject>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            MuseumItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(objects[position], position)
    }

    inner class ViewHolder(private val binding: MuseumItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(objects: MuseumObject, position: Int) {
            binding.root.layoutParams.width = GridLayout.LayoutParams.MATCH_PARENT

            with(binding) {
                museumCardName.text = ""
                museumCardLocation.text = objects.name
                museumCardLocation.textSize = 15F
                Picasso.get().load(objects.thumbnail).into(binding.museumCardPicture)
            }

            binding.root.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, MuseumObjectActivity::class.java)
                intent.putExtra("index", position)
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return objects.size
    }

    fun setData(objects: List<MuseumObject>) {
        val diffUtil = DiffUtilCompare(objects, this.objects)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        this.objects = objects
        diffUtilResult.dispatchUpdatesTo(this)
    }
}