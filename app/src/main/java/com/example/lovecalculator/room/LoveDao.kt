package com.example.lovecalculator.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.LoveModel

interface LoveDao {
    @Dao
    interface LoveDao {

        @Insert
        fun insert(loveModel: LoveModel)

        @Delete
        fun delete(loveModel: LoveModel)

        @Query("SELECT * FROM love_table ORDER BY id DESC")
        fun getAll(): List<LoveModel>

        @Query("SELECT * FROM love_table ORDER BY id DESC")
        fun getAllSort(): List<LoveModel>

    }
}