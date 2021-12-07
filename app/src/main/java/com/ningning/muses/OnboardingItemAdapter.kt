package com.ningning.muses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingItemAdapter(private val onboardingItems: List<OnboardingItem>)
    : RecyclerView.Adapter<OnboardingItemAdapter.OnboardingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboarding_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onboardingItems[position])
    }

    override fun getItemCount(): Int {
        return onboardingItems.size
    }

    inner class OnboardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val onboardingImage = view.findViewById<ImageView>(R.id.onboardingImage)
        private val onboardingTitle = view.findViewById<TextView>(R.id.onboardingTitle)
        private val onboardingDesc = view.findViewById<TextView>(R.id.onboardingDesc)

        fun bind(onboardingItem: OnboardingItem) {
            onboardingImage.setImageResource(onboardingItem.image)
            onboardingTitle.text = onboardingItem.title
            onboardingDesc.text = onboardingItem.desc
        }
    }
}