package com.example.webviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView:WebView = findViewById(R.id.webView)
        val btn1:Button = findViewById(R.id.button4)
        val btn2:Button = findViewById(R.id.button5)
        val btn3:Button = findViewById(R.id.button6)
        val settings = webView.settings
        settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com")

        btn1.setOnClickListener {
            webView.loadUrl("https://www.naver.com")
        }

        btn2.setOnClickListener {
            webView.loadUrl("https://www.google.com")
        }

        btn3.setOnClickListener {
            webView.loadUrl("https://www.daum.net")
        }
    }
}