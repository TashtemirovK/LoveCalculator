package com.example.lovecalculator

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class LoveModel(
    @SerializedName("fname")
    var firstname: String,
    @SerializedName("sname")
    var sname: String,
    var percentage: String,
    var result: String,
)

