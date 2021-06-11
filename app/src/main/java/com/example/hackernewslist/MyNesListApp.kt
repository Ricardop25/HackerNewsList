package com.example.hackernewslist

import android.app.Application
import android.content.Context

class MyNesListApp: Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        private var context: Context? = null
        val appContext: Context?
            get() = context
    }

}