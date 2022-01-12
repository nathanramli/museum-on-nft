package com.ningning.muses

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
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

        val confirmButton = findViewById<MaterialButton>(R.id.btnConfirm)
        confirmButton.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this)
            val view =
                layoutInflater.inflate(R.layout.fragment_bottom_sheet_confirm_payment_dialog, null)
            bottomSheet.setContentView(view)
            view.findViewById<Button>(R.id.noConfirmPaymentButton)?.setOnClickListener {
                bottomSheet.dismiss()
            }
            view.findViewById<Button>(R.id.yesConfirmPaymentButton)?.setOnClickListener {
                val context = this
                val intent = Intent(this, PaymentSuccessActivity::class.java)
                context.startActivity(intent)
            }
            bottomSheet.show()
        }
    }
}