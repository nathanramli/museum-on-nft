package com.ningning.muses

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toolbar?.setNavigationOnClickListener {
            navigateToSignIn()
            finish()
        }

        val resetPasswordFragment = ResetPasswordFragment()
        replaceFragment(resetPasswordFragment, ResetPasswordFragment::class.java.simpleName)
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

    fun showResetPasswordRequested() {
        val resetPasswordRequestedFragment = ResetPasswordRequestedFragment()
        replaceFragment(
            resetPasswordRequestedFragment,
            ResetPasswordRequestedFragment::class.java.simpleName
        )
    }

    private fun navigateToSignIn() {
        startActivity(Intent(applicationContext, SignInActivity::class.java))
        finish()
    }

    private fun replaceFragment(fragment: Fragment, simpleName: String) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameContainer, fragment, simpleName)
            commit()
        }
    }
}