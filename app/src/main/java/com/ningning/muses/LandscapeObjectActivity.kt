package com.ningning.muses

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import com.ningning.muses.data.MUSEUM_OBJECTS

class LandscapeObjectActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var webView: WebView

    private var currentObject: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landscape_object)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toolbar?.setNavigationOnClickListener {
            navigate2ObjectDetail()
        }

        currentObject = intent.getIntExtra("index", 0)

        webView = findViewById(R.id.webView)
        updateObject()

        findViewById<ImageButton>(R.id.exitLandscape).setOnClickListener { navigate2ObjectDetail() }
    }

    private fun navigate2ObjectDetail() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        finish()
    }

    private fun updateObject() {
        var modelViewer = assets.open("model_viewer.html").bufferedReader().use {
            it.readText()
        }
        modelViewer =
            modelViewer.replace("thumbnail_placeholder", MUSEUM_OBJECTS[currentObject].thumbnail)
        modelViewer = modelViewer.replace("model_placeholder", MUSEUM_OBJECTS[currentObject].model)

        toolbar.title = MUSEUM_OBJECTS[currentObject].name

        webView.loadDataWithBaseURL(null, modelViewer, "text/html", "utf-8", null)
        webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
        }
    }
}