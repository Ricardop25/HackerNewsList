package com.example.hackernewslist.network

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class RequestVolley {

    fun getNews(context: Context, volleyCallback: VolleyCallback){
        val queue = Volley.newRequestQueue(context)
        val url = "https://hn.algolia.com/api/v1/search_by_date?query=mobile"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                volleyCallback.onSuccess(response)
            },
            {
                volleyCallback.onSuccess(it.toString()) })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)


    }

}