package com.example.hackernewslist.view

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.hackernewslist.R
import com.example.hackernewslist.databinding.ActivityMainBinding
import com.example.hackernewslist.databse.NewDao
import com.example.hackernewslist.databse.NewDatabase
import com.example.hackernewslist.model.New
import com.example.hackernewslist.repository.NewsRepository
import com.example.hackernewslist.view.adapter.NewsAdapter
import com.example.hackernewslist.viewmodel.NewsViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var  adapter: NewsAdapter

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val isMetered = cm.isActiveNetworkMetered()


        //Call API and load data
        val newsObserver = Observer<List<New>>{ news ->

            adapter = NewsAdapter(this,news as MutableList<New>)
            binding.recyclerview.adapter = adapter

            val item = object : SwipeToDelete(this,0,ItemTouchHelper.LEFT){
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    adapter.deleteNew(viewHolder.adapterPosition)
                }
            }

            val itemTouchHelper = ItemTouchHelper(item)
            itemTouchHelper.attachToRecyclerView(binding.recyclerview)


        }

        viewModel.news.observe(this,newsObserver)



        //SwipeRefresh
        binding.swipe.setOnRefreshListener {

            val newsObserverRefresh = Observer<List<New>>{ news ->

                adapter =  NewsAdapter(this,news as MutableList<New>)
                binding.recyclerview.adapter = adapter

                if(binding.swipe.isRefreshing){
                    binding.swipe.isRefreshing = false
                }

            }
            viewModel.news.observe(this,newsObserverRefresh)
        }

    }



}