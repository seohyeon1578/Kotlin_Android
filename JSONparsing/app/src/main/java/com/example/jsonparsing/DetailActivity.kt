package com.example.jsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val webView:WebView = findViewById(R.id.webView)
        val url = intent.getStringExtra("url")
        val settings = webView.settings
        settings.javaScriptEnabled = true

        webView.webViewClient = WebViewClient()
        webView.loadUrl(url!!)

    }
}