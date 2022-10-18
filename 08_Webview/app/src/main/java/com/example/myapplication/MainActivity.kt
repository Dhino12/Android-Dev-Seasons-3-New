package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl("https://dhino12.netlify.app")

        webView.settings.javaScriptEnabled = true // active javascript

        webView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Toast.makeText(this@MainActivity, "Web Dicoding berhasil dimuat", Toast.LENGTH_SHORT).show()
                view?.loadUrl("javascript:alert('web portfolio berhasil dimuat')")
            }
        }

        //        webView.webChromeClient = WebChromeClient()
        webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(
                view: WebView?,
                url: String?,
                message: String?,
                result: JsResult?
            ): Boolean {
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                result?.confirm()

                return true
            }
        }
        webView.loadUrl("https://dhino12.netlify.app")
    }
}