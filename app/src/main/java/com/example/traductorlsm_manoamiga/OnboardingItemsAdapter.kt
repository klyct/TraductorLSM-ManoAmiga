package com.example.traductorlsm_manoamiga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnboardingItemsAdapter(private val onboardingItems: List<OnboardingItem>):
RecyclerView.Adapter<OnboardingItemsAdapter.OnboardingItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboarding_item_container,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bind(onboardingItems[position])
    }

    override fun getItemCount(): Int {
        return  onboardingItems.size
    }

    inner class OnboardingItemViewHolder(view:View):RecyclerView.ViewHolder(view){
        private val imgOnboading = view.findViewById<ImageView>(R.id.imgOnboarding)
        private val txtTitle= view.findViewById<TextView>(R.id.txtTitle)
        private val txtDescription = view.findViewById<TextView>(R.id.txtDescription)

        fun  bind(onboardingItem: OnboardingItem){
            imgOnboading.setImageResource(onboardingItem.onboardingImage)
            txtTitle.text=onboardingItem.title
            txtDescription.text=onboardingItem.description
        }
    }
}