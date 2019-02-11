package com.daya.webviewsample

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadWebPage()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWebPage() {
        webView.webViewClient = ToastWebViewClient()
        webView.webChromeClient = ToastWebChromeClient()
        webView.settings.javaScriptEnabled = true
        //webView.loadUrl("https://m.naver.com")
        webView.loadUrl("https://toast.com")
    }

    inner class ToastWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)

            loadingProgressBar.visibility = View.VISIBLE
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)

            loadingProgressBar.visibility = View.GONE
        }
    }

    inner class ToastWebChromeClient : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)

            loadingProgressBar.progress = newProgress
        }
    }
}