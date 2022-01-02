package com.ningning.muses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ningning.muses.data.Ticket

class TicketDetailActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_detail)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val data = intent.getParcelableExtra<Ticket>("data")
        findViewById<TextView>(R.id.museumName).text = data?.museum?.name
        findViewById<TextView>(R.id.museumLocation).text = data?.museum?.location
        findViewById<TextView>(R.id.museumType).text = data?.museum?.type
        findViewById<TextView>(R.id.museumEstablished).text = data?.museum?.established
        findViewById<TextView>(R.id.ticketExpiration).text = data?.expired
        findViewById<TextView>(R.id.ticketStatus).text =
            if (data?.isValid == true) "Active" else "Expired"

        val identifierImage = resources.getIdentifier(data?.museum?.image, "drawable", packageName)
        findViewById<ImageView>(R.id.museumPicture).setImageResource(identifierImage)

        toolbar?.setNavigationOnClickListener {
            // Navigate to My Ticket
            finish()
        }

        val useTicketButton = findViewById<Button>(R.id.btnUseTicket)
        if (data?.isValid == false) {
            useTicketButton.setTextColor(ContextCompat.getColor(baseContext, R.color.white))
            useTicketButton.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.silver))
        }
        useTicketButton.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.fragment_bottom_sheet_dialog, null)
            bottomSheet.setContentView(view)
            view.findViewById<Button>(R.id.noButton)?.setOnClickListener {
                bottomSheet.dismiss()
            }
            view.findViewById<Button>(R.id.yesButton)?.setOnClickListener {
                val context = view.context
                bottomSheet.dismiss()
                context.startActivity(Intent(context, MuseumObjectActivity::class.java))
            }
            bottomSheet.show()
        }
    }
}