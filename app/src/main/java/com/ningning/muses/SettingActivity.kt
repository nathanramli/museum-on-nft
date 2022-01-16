package com.ningning.muses

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomsheet.BottomSheetDialog

class SettingActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_setting)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        setupListener()
    }

    private fun setupListener() {
        val logout = findViewById<TextView>(R.id.logout)
        logout.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.fragment_bottom_sheet_logout, null)
            bottomSheet.setContentView(view)
            view.findViewById<Button>(R.id.noLogoutButton)?.setOnClickListener {
                bottomSheet.dismiss()
            }
            view.findViewById<Button>(R.id.yesLogoutButton)?.setOnClickListener {
                finishAffinity()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            bottomSheet.show()
        }
    }
}