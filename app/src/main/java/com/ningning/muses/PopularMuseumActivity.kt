package com.ningning.muses

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.adapter.SeeAllMuseumParentAdapter
import com.ningning.muses.data.PopularMuseums

class PopularMuseumActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    private lateinit var seeAllMuseumParentAdapter: SeeAllMuseumParentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_popular_museum)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        seeAllMuseumParentAdapter = SeeAllMuseumParentAdapter()
        seeAllMuseumParentAdapter.setData(PopularMuseums)

        val parentRecyclerView = findViewById<RecyclerView>(R.id.parent_recyclerview)
        parentRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        parentRecyclerView.setHasFixedSize(true)
        parentRecyclerView.adapter = seeAllMuseumParentAdapter
        parentRecyclerView.canScrollHorizontally(0)
        parentRecyclerView.canScrollVertically(0)

        recyclerViewScrollListener()
    }

    private fun recyclerViewScrollListener() {
        val parentRecyclerView = findViewById<RecyclerView>(R.id.parent_recyclerview)
        parentRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
}