package com.ningning.muses

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

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

    private fun setupButtonListener() {
        val signInButton = findViewById<Button>(R.id.signInButton)
        signInButton.setOnClickListener(View.OnClickListener {
            navigateToHome()
        })

        val signUpButton = findViewById<TextView>(R.id.registerNow)
        signUpButton.setOnClickListener(View.OnClickListener {
            navigateToOnBoarding()
        })
    }
}