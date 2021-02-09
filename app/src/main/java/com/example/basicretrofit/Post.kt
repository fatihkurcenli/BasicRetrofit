package com.example.basicretrofit

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId")
    var userId:Int,
    @SerializedName("id")
    var id:Int,
    @SerializedName("title")
    var title:String,
    @SerializedName("body")
    var body:String
)