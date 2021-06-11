package com.example.hackernewslist.network

import com.example.hackernewslist.model.ListNews
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("search_by_date?query=mobile")
    fun getAllNews(): Call<ListNews>

}