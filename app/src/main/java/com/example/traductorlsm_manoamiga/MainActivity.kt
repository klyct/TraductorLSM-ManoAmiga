package com.example.traductorlsm_manoamiga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
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
        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode=
            RecyclerView.OVER_SCROLL_NEVER

        findViewById<ImageView>(R.id.imageNext).setOnClickListener{
            if (onboardingViewPager.currentItem+1<onboardingItemsAdapter.itemCount){
                onboardingViewPager.currentItem+=1
            } else{
                navigateToHome()
            }
        }
        findViewById<TextView>(R.id.txtSkip).setOnClickListener {
            navigateToHome()
        }
        findViewById<MaterialButton>(R.id.btnGetStarted).setOnClickListener {
            navigateToHome()
        }
    }

    private fun navigateToHome(){
        startActivity(Intent(applicationContext,HomeActivity::class.java))
        finish()
    }


    private fun setupIndicators(){
        indicatorContainer=findViewById(R.id.indicatorContainer)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams=
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i]= ImageView(applicationContext)
            indicators[i]?.let{
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
                it.layoutParams=layoutParams
                indicatorContainer.addView(it)
            }
        }
    }





    private fun setCurrentIndicator(position: Int){
        val childCount =indicatorContainer.childCount
        for (i in 0 until childCount){
            val imageView= indicatorContainer.getChildAt(i) as ImageView
            if (i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}