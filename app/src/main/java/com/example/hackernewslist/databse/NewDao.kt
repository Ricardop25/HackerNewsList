package com.example.hackernewslist.databse

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hackernewslist.model.New

@Dao
interface NewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNew(new: New)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsList(news: List<New>)

    @Update
    fun updateNew(new: New)

    @Delete
    fun deleteNew(new: New)

    @Query("SELECT * FROM new")
    fun loadNews(): LiveData<List<New>>






}