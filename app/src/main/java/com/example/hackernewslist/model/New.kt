package com.example.hackernewslist.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class New(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("story_title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("story_url") val url: String?)

