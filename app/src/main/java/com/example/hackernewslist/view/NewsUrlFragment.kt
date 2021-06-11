package com.example.hackernewslist.view

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.hackernewslist.R



class NewsUrlFragment : Fragment() {

    private var newUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            if(it.containsKey(NEW_ITEM)){
                newUrl = it.getString(NEW_ITEM)
            }


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_news_url, container, false)

        newUrl?.let {
            val webView = rootView.findViewById<WebView>(R.id.webview)
            webView.webChromeClient = object : WebChromeClient(){
            }
            webView.webViewClient = object : WebViewClient(){

            }

            val settings = webView.settings
            settings.javaScriptEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true

            webView.loadUrl(newUrl?:"No url")

        }

        // Inflate the layout for this fragment
        return rootView
    }

    companion object {
        const val NEW_ITEM = "item"
    }
}