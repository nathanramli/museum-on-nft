package com.ningning.muses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.ningning.muses.adapter.CategoryListAdapter
import com.ningning.muses.data.CATEGORY_ITEMS
import com.ningning.muses.databinding.ActivitySelectFavoriteCategoryBinding

class SelectFavoriteCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectFavoriteCategoryBinding

    private lateinit var categoryListAdapter: CategoryListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_favorite_category)

        recyclerView = findViewById(R.id.recyclerView)

        categoryListAdapter = CategoryListAdapter()
        binding = ActivitySelectFavoriteCategoryBinding.inflate(layoutInflater)

        initialRecyclerView()
        categoryListAdapter.setData(CATEGORY_ITEMS)

        findViewById<MaterialButton>(R.id.saveButton).setOnClickListener {
            startActivity(Intent(applicationContext, HomeActivity::class.java))
            finish()
        }

        recyclerViewScrollListener()
    }


    private fun initialRecyclerView() {
        recyclerView.layoutManager =
            object : GridLayoutManager(this, 2) {
                override fun canScrollHorizontally(): Boolean {
                    return false
                }
            }
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = categoryListAdapter
    }


    private fun recyclerViewScrollListener() {
        recyclerView.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
}