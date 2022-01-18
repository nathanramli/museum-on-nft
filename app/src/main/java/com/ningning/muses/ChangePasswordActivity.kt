package com.ningning.muses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_change_password)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val updatePasswordButton = findViewById<MaterialButton>(R.id.updatePasswordButton)
        updatePasswordButton.setOnClickListener {
            finish()
        }
    }
}