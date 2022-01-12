package com.ningning.muses

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ningning.muses.data.Museum

class PaymentConfirmationActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_confirmation)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val data = intent.getParcelableExtra<Museum>("data")
        val qty = intent.getIntExtra("qty", 0)

        findViewById<TextView>(R.id.paymentMuseumName).text = data?.name
        findViewById<TextView>(R.id.paymentMuseumType).text = data?.type
        findViewById<TextView>(R.id.paymentMuseumLocation).text = data?.location
        findViewById<TextView>(R.id.paymentMuseumEstablished).text = data?.established
        findViewById<TextView>(R.id.paymentMuseumPaymentMethod).text = "E-Wallet"
        findViewById<TextView>(R.id.paymentMuseumTicketValid).text = "until 20 January 2022"
        findViewById<TextView>(R.id.paymentMuseumTicketPrice).text =
            data?.price.toString().plus(" $")
        findViewById<TextView>(R.id.paymentMuseumTicketAmount).text = qty.toString().plus(" Ticket")
        findViewById<TextView>(R.id.paymentTotal).text =
            "TOTAL = ".plus(qty * data?.price!!).plus(" $")
        data.image.let {
            findViewById<ImageView>(R.id.museumPicture).setImageResource(it)
        }

        toolbar.setNavigationOnClickListener {
            finish()
        }

    }
}