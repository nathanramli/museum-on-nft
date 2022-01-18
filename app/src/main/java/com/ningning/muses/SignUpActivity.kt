package com.ningning.muses

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class SignUpActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toolbar?.setNavigationOnClickListener {
            navigateToSignIn()
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

    private fun navigateToSelectFavoriteCategory() {
        startActivity(Intent(applicationContext, SelectFavoriteCategoryActivity::class.java))
        finish()
    }

    private fun navigateToSignIn() {
        startActivity(Intent(applicationContext, SignInActivity::class.java))
        finish()
    }

    private fun setupButtonListener() {
        val signInButton = findViewById<TextView>(R.id.signInNow)
        signInButton.setOnClickListener(View.OnClickListener {
            navigateToSignIn()
        })

        val signUpButton = findViewById<Button>(R.id.signUpButton)
        signUpButton.setOnClickListener(View.OnClickListener {
            navigateToSelectFavoriteCategory()
        })
    }
}