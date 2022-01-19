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
import com.google.android.material.textfield.TextInputEditText

class SignInWithCryptoActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_with_crypto)

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
            if (v is TextInputEditText) {
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

    private fun navigateToSignIn() {
        startActivity(Intent(applicationContext, SignInActivity::class.java))
        finish()
    }

    private fun navigateToResetPassword() {
        startActivity(Intent(applicationContext, ResetPasswordActivity::class.java))
        finish()
    }

    private fun setupButtonListener() {
        val signInButton = findViewById<Button>(R.id.signInButton)
        signInButton.setOnClickListener {
            val phrase = findViewById<EditText>(R.id.inputPhrase)
            if (phrase.text.isEmpty()) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Please fill your phrase first!",
                    Snackbar.LENGTH_SHORT
                ).setBackgroundTint(Color.RED)
                    .setTextColor(Color.WHITE)
                    .show()
            } else {
                navigateToHome()
            }
        }

        val signUpButton = findViewById<TextView>(R.id.registerNow)
        signUpButton.setOnClickListener {
            navigateToSignUp()
        }

        val signInWithEmail = findViewById<Button>(R.id.signInWithEmailButton)
        signInWithEmail.setOnClickListener {
            navigateToSignIn()
        }

        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        forgotPassword.setOnClickListener {
            navigateToResetPassword()
        }
    }
}