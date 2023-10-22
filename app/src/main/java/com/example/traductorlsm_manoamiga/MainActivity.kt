package com.example.traductorlsm_manoamiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnboardingItems()
    }

    private fun setOnboardingItems(){
        onboardingItemsAdapter= OnboardingItemsAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.img1,
                    title= "manage your task",
                    description = "inserta descripcion"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.images,
                    title= "manage your task 2",
                    description = "inserta descripcion 2"
                ),OnboardingItem(
                    onboardingImage = R.drawable.imp3,
                    title= "manage your task 3",
                    description = "inserta descripcion 3"
                )
            )
        )
        val onboardingViewPager= findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter =onboardingItemsAdapter
    }
}