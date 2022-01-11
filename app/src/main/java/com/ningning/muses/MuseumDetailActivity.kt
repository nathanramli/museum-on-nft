package com.ningning.muses

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ningning.muses.data.Museum

class MuseumDetailActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_detail)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val data = intent.getParcelableExtra<Museum>("data")
        findViewById<TextView>(R.id.museumName).text = data?.name
        findViewById<TextView>(R.id.museumLocation).text = data?.location
        findViewById<TextView>(R.id.museumType).text = data?.type
        findViewById<TextView>(R.id.museumEstablished).text = data?.established
        findViewById<TextView>(R.id.ticketPrice).text = data?.price.toString().plus(" $")
        data?.image?.let {
            findViewById<ImageView>(R.id.museumPicture).setImageResource(it)
        }

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}