package com.example.hackernewslist.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.hackernewslist.MyNesListApp
import com.example.hackernewslist.databse.NewDao
import com.example.hackernewslist.databse.NewDatabase
import com.example.hackernewslist.model.ListNews
import com.example.hackernewslist.model.New
import com.example.hackernewslist.network.RetrofitService
import com.example.hackernewslist.network.RetrofitServiceBuilder
import retrofit2.Call
import retrofit2.Response

private const val BASE_URL = "https://hn.algolia.com/api/v1/"

object NewsRepository {

    //Database
    private var database: NewDatabase? = null
    private var newDao: NewDao? = null


    //Retrofit
    private val newsService: RetrofitService = RetrofitServiceBuilder(BASE_URL)
        .buildService(RetrofitService::class.java)

    //LiveData
    private var newsCompleteLiveData = MutableLiveData<List<New>>()
    private val errorMessage = MutableLiveData<String>()

    init {
        val context = MyNesListApp.appContext
        context?.let {

            database = Room.databaseBuilder(it, NewDatabase::class.java,"database").build()

            newDao = database?.newDao()

        }
    }

    fun getnews(): LiveData<List<New>>{
        val call = newsService.getAllNews()

        call.enqueue(object : retrofit2.Callback<ListNews>{
            override fun onResponse(call: Call<ListNews>, response: Response<ListNews>) {

                if(response.isSuccessful){
                    val news = response.body()?.news ?: listOf()
                    newsCompleteLiveData.value = news

                    //Fill database
                    Thread{
                        newDao?.insertNewsList(news)
                    }.start()

                }

            }

            override fun onFailure(call: Call<ListNews>, t: Throwable) {
                newsCompleteLiveData = (newDao?.loadNews() ?: MutableLiveData<List<New>>()) as MutableLiveData<List<New>>
                //errorMessage.postValue(t.message)

            }


        })
        //return newDao?.loadNews() ?: MutableLiveData<List<New>>()
        return newsCompleteLiveData
    }

}