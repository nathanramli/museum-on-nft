package com.ningning.muses

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar

class SignInActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toolbar?.setNavigationOnClickListener {
            navigateToOnBoarding()
            finish()
        }

        setupButtonListener()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action === MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
                    v.clearFocus()
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun navigateToHome() {
        startActivity(Intent(applicationContext, HomeActivity::class.java))
        finish()
    }

    private fun navigateToOnBoarding() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }

    private fun navigateToSignUp() {
        startActivity(Intent(applicationContext, SignUpActivity::class.java))
        finish()
    }

    private fun navigateToResetPassword() {
        startActivity(Intent(applicationContext, ResetPasswordActivity::class.java))
        finish()
    }

    private fun navigateToSignInWithCrypto() {
        startActivity(Intent(applicationContext, SignInWithCryptoActivity::class.java))
        finish()
    }

    private fun setupButtonListener() {
        val signInButton = findViewById<Button>(R.id.signInButton)
        signInButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.inputEmail)
            val password = findViewById<EditText>(R.id.inputPassword)
            if (email.text.isEmpty() || password.text.isEmpty()) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Please fill your email and password!",
                    Snackbar.LENGTH_SHORT
                ).setBackgroundTint(Color.RED)
                    .setTextColor(Color.WHITE)
                    .show()
            } else {
                navigateToHome()
            }
        }

        val signInWithCrypto = findViewById<Button>(R.id.signInCryptoButton)
        signInWithCrypto.setOnClickListener {
            navigateToSignInWithCrypto()
        }

        val signUpButton = findViewById<TextView>(R.id.registerNow)
        signUpButton.setOnClickListener {
            navigateToSignUp()
        }

        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        forgotPassword.setOnClickListener {
            navigateToResetPassword()
        }

    }
}