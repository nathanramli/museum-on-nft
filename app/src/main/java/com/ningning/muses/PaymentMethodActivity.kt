package com.ningning.muses

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.ningning.muses.data.Museum

class PaymentMethodActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_method)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val data = intent.getParcelableExtra<Museum>("data")
        val qty = intent.getIntExtra("qty", 0)

        val nextButton = findViewById<MaterialButton>(R.id.btnPaymentMethodNext)
        nextButton.setOnClickListener {
            val context = this
            val intent = Intent(this, PaymentConfirmationActivity::class.java)
            intent.putExtra("data", data)
            intent.putExtra("qty", qty)
            context.startActivity(intent)
        }
    }
}