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
import com.google.android.material.card.MaterialCardView
import com.ningning.muses.data.MUSEUM_OBJECTS

class MuseumObjectActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var webView: WebView

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

        webView = findViewById<WebView>(R.id.webView)
        var modelViewer = assets.open("model_viewer.html").bufferedReader().use {
            it.readText()
        }
        modelViewer = modelViewer.replace("thumbnail_placeholder", MUSEUM_OBJECTS[0].thumbnail)
        modelViewer = modelViewer.replace("model_placeholder", MUSEUM_OBJECTS[0].model)

        findViewById<TextView>(R.id.objectName).text = MUSEUM_OBJECTS[0].name
        findViewById<TextView>(R.id.objectDescription).text = MUSEUM_OBJECTS[0].description

        webView.loadDataWithBaseURL(null, modelViewer, "text/html", "utf-8", null)
        webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
        }

        findViewById<ImageButton>(R.id.fullscreenButton).setOnClickListener { fullscreenClickEvent() }
        findViewById<ImageButton>(R.id.helpButton).setOnClickListener { helpClickEvent() }
    }

    private fun fullscreenClickEvent() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        val museumObjectContainer = findViewById<MaterialCardView>(R.id.museumObjectContainer)
        museumObjectContainer.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        museumObjectContainer.requestLayout()
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