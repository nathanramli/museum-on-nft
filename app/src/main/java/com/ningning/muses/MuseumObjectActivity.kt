package com.ningning.muses

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.ningning.muses.data.MUSEUM_OBJECTS

class MuseumObjectActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var webView: WebView

    private var currentObject: Int = 0

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_object)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toolbar?.setNavigationOnClickListener {
            finish()
        }

        webView = findViewById(R.id.webView)
        updateObject()

        findViewById<ImageButton>(R.id.fullscreenButton).setOnClickListener { fullscreenClickEvent() }
        findViewById<ImageButton>(R.id.helpButton).setOnClickListener { helpClickEvent() }

        findViewById<ImageButton>(R.id.previousButton).setOnClickListener {
            if (currentObject == 0) {
                currentObject = MUSEUM_OBJECTS.count() - 1
            } else {
                currentObject -= 1
            }
            updateObject()
        }
        findViewById<ImageButton>(R.id.nextButton).setOnClickListener {
            currentObject = (currentObject + 1) % MUSEUM_OBJECTS.count()
            updateObject()
        }
    }

    private fun fullscreenClickEvent() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        val museumObjectContainer = findViewById<MaterialCardView>(R.id.museumObjectContainer)
        museumObjectContainer.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        museumObjectContainer.requestLayout()
    }

    private fun updateObject() {
        var modelViewer = assets.open("model_viewer.html").bufferedReader().use {
            it.readText()
        }
        modelViewer =
            modelViewer.replace("thumbnail_placeholder", MUSEUM_OBJECTS[currentObject].thumbnail)
        modelViewer = modelViewer.replace("model_placeholder", MUSEUM_OBJECTS[currentObject].model)

        findViewById<TextView>(R.id.objectName).text = MUSEUM_OBJECTS[currentObject].name
        findViewById<TextView>(R.id.objectDescription).text =
            MUSEUM_OBJECTS[currentObject].description

        findViewById<MaterialButton>(R.id.likeButton).text =
            "❤️  " + MUSEUM_OBJECTS[currentObject].likeCount

        webView.loadDataWithBaseURL(null, modelViewer, "text/html", "utf-8", null)
        webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
        }
    }

    private fun helpClickEvent() {
        val bottomSheet = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.fragment_bottom_sheet_alert, null)
        bottomSheet.setContentView(view)
        view.findViewById<TextView>(R.id.bottomSheetTitle).text =
            getString(R.string.object_viewer_helper_title)
        view.findViewById<TextView>(R.id.bottomSheetDesc).text =
            getString(R.string.object_viewer_helper_desc)
        view.findViewById<Button>(R.id.okButton)?.setOnClickListener {
            bottomSheet.dismiss()
        }
        bottomSheet.show()
    }
}