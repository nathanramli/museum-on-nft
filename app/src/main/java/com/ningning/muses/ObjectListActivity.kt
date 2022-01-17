package com.ningning.muses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.adapter.ObjectListAdapter
import com.ningning.muses.data.MUSEUM_OBJECTS
import com.ningning.muses.databinding.ActivityObjectListBinding

class ObjectListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityObjectListBinding

    private lateinit var objectListAdapter: ObjectListAdapter
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_list)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        toolbar.setNavigationOnClickListener {
            // Navigate to My Ticket
            finish()
        }
        recyclerView = findViewById(R.id.recyclerView)

        objectListAdapter = ObjectListAdapter()
        binding = ActivityObjectListBinding.inflate(layoutInflater)

        initialRecyclerView()
        objectListAdapter.setData(MUSEUM_OBJECTS)

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
        recyclerView.adapter = objectListAdapter
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