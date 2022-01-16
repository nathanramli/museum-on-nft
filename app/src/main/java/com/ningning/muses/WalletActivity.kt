package com.ningning.muses

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class WalletActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    private var eWalletState: Boolean = true
    private var cryptoWalletState: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_wallet)

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
        val eWallet = findViewById<TextView>(R.id.eWalletPaymentOption)
        val cryptoWallet = findViewById<TextView>(R.id.cryptoWalletPaymentOption)

        eWallet.setOnClickListener {
            if (eWalletState) {
                eWallet.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_e_wallet, 0, R.drawable.ic_checklist_inactive, 0)
            } else {
                eWallet.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_e_wallet, 0, R.drawable.ic_checklist_active, 0)
            }
            eWalletState = !eWalletState
        }

        cryptoWallet.setOnClickListener {
            if (cryptoWalletState) {
                cryptoWallet.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_crypto_wallet, 0, R.drawable.ic_checklist_inactive, 0)
            } else {
                cryptoWallet.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_crypto_wallet, 0, R.drawable.ic_checklist_active, 0)
            }
            cryptoWalletState = !cryptoWalletState
        }
    }
}