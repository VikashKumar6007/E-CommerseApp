package com.example.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebView : AppCompatActivity() {
    lateinit var webView : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
//        webView = findViewById<WebView>(R.id.webView) as WebView
//        webView.loadUrl("https://www.google.com")
//        webView.settings.javaScriptEnabled=(true)
//
//        webView.webViewClient= WebViewClient()
//        webView.settings.setSupportZoom(true)
    }
}