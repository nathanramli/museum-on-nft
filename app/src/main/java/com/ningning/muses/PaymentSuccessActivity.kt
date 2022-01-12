package com.ningning.muses

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class PaymentSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_success)

        val toMyTicketButton = findViewById<MaterialButton>(R.id.toMyTicketButton)
        val toHomeButton = findViewById<MaterialButton>(R.id.toHomeButton)

        toMyTicketButton.setOnClickListener {
            finishAffinity()
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }

        toHomeButton.setOnClickListener {
            finishAffinity()
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}