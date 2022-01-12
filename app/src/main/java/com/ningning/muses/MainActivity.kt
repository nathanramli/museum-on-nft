package com.ningning.muses

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.ningning.muses.adapter.OnboardingItemAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var onboardingItemsAdapter: OnboardingItemAdapter
    private lateinit var onboardingIndicatorContainer: LinearLayout
    private lateinit var onboardingViewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
        setupButtonListener()
    }

    private fun navigateToHome() {
        startActivity(Intent(applicationContext, SignInActivity::class.java))
        finish()
    }

    private fun setOnboardingItems() {
        onboardingItemsAdapter = OnboardingItemAdapter(
            listOf(
                OnboardingItem(
                    image = R.drawable.looking_at_arts_in_museum,
                    title = getString(R.string.onboarding_page_one_title),
                    desc = getString(R.string.onboarding_page_one_desc)
                ),
                OnboardingItem(
                    image = R.drawable.virtual_reality,
                    title = getString(R.string.onboarding_page_two_title),
                    desc = getString(R.string.onboarding_page_two_desc)
                ),
                OnboardingItem(
                    image = R.drawable.connected_with_ethereum,
                    title = getString(R.string.onboarding_page_three_title),
                    desc = getString(R.string.onboarding_page_three_desc)
                ),
            )
        )

        onboardingViewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter
        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
    }

    private fun setupIndicators() {
        onboardingIndicatorContainer = findViewById(R.id.onboardingIndicatorContainer)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_indicator
                    )
                )
                it.layoutParams = layoutParams
                onboardingIndicatorContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position: Int) {
        val childCount = onboardingIndicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = onboardingIndicatorContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_indicator_active,
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_indicator,
                    )
                )
            }
        }
    }

    private fun setupButtonListener() {
        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener(View.OnClickListener {
            if (onboardingViewPager.currentItem + 1 < onboardingItemsAdapter.itemCount) {
                onboardingViewPager.currentItem += 1
            } else {
                navigateToHome()
            }
        })

        val skipButton = findViewById<Button>(R.id.skipButton)
        skipButton.setOnClickListener(View.OnClickListener() {
            navigateToHome()
        })
    }
}