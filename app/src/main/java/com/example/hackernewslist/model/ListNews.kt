package com.example.hackernewslist.model

import com.google.gson.annotations.SerializedName

data class ListNews(@SerializedName("hits") val news: List<New> ) {
}