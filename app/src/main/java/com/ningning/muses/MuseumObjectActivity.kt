package com.ningning.muses

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
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

        currentObject = intent.getIntExtra("index", 0)

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
        val context = this
        val intent = Intent(this, LandscapeObjectActivity::class.java)
        intent.putExtra("index", currentObject)
        context.startActivity(intent)
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
        val view = layoutInflater.inflate(R.layout.fragment_bottom_sheet_nft, null)
        bottomSheet.setContentView(view)
        view.findViewById<TextView>(R.id.addressText).text = MUSEUM_OBJECTS[currentObject].address
        view.findViewById<TextView>(R.id.ownerText).text = MUSEUM_OBJECTS[currentObject].owner
        view.findViewById<TextView>(R.id.standardText).text =
            MUSEUM_OBJECTS[currentObject].tokenStandard
        view.findViewById<TextView>(R.id.blockchainText).text =
            MUSEUM_OBJECTS[currentObject].blockchain
        view.findViewById<Button>(R.id.okButton)?.setOnClickListener {
            bottomSheet.dismiss()
        }
        bottomSheet.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_bar_menu_museum_object, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menuObjectList) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}