package com.example.hackernewslist.databse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hackernewslist.model.New

@Database(entities = [New::class], version = 1)
abstract class NewDatabase: RoomDatabase() {

    abstract fun newDao(): NewDao

}