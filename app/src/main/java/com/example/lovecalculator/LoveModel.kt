package com.example.lovecalculator

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serial
import java.io.Serializable

@Entity(tableName = "love_table")
data class LoveModel(
    @SerializedName("fname")
    val fname: String,
    @SerializedName("sname")
    val sname: String,
    val percentage: String,
    val result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var insertTime:Long
) : Serializable

