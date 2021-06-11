package com.example.hackernewslist.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hackernewslist.repository.NewsRepository

class NewsViewModel: ViewModel() {

    val news = NewsRepository.getnews()


}