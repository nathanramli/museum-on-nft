package com.ningning.muses

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton

class EditProfileActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_profile)


        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        toolbar.setNavigationOnClickListener {
            finish()
        }
        setupListener()
        setDate()

    }

    private fun setupListener() {
        val birthDateLayout = findViewById<ImageButton>(R.id.btnCalendar)
        val fm = supportFragmentManager
        birthDateLayout.setOnClickListener {
            val calendarFragment = CalendarFragment()
            calendarFragment.show(fm, CalendarFragment::class.java.simpleName)

        }

        val updateButton = findViewById<MaterialButton>(R.id.updateProfileButton)
        updateButton.setOnClickListener {
            finish()
        }
    }

    private fun setDate() {
        val mainViewModel: MainViewModel by viewModels()
        mainViewModel.date.observe(this, {
            val birthDate = findViewById<TextView>(R.id.birthDate)
            birthDate.setText(it)
        })
    }


}