package com.example.lovecalculator.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator.LoveModel

class AppDatabase {
    @Database(version = 1, entities = [LoveModel::class])
    abstract class AppDatabase : RoomDatabase(){

        abstract fun getLoveDao(): LoveDao
    }
}