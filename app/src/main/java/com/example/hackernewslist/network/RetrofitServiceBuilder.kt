package com.example.hackernewslist.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceBuilder(url: String) {

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }

}
