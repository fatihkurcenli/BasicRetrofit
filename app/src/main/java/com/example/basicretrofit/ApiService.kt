package com.example.basicretrofit

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    //https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    fun getPostList(): Call<List<Post>>

    //https://jsonplaceholder.typicode.com/posts/1
    @GET("posts/{id}")
    fun getSinglePost(@Path("id") postId: Int): Call<Post>

    //https://jsonplaceholder.typicode.com/posts?userId=10
    @GET("posts")
    fun getPostWithQuery(@Query("userId") userId: Int): Call<List<Post>>

    @POST("posts")
    @FormUrlEncoded
    fun savePost(@Body post: Post): Call<Post>

    @POST("posts")
    @FormUrlEncoded
    fun savePostWithField(@Field("title") title: String, @Field("body") body: String): Call<Post>

    @PUT("posts/{id}")
    @FormUrlEncoded
    fun updatePost(
        @Path("id") postId: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Call<Post>

    @DELETE("post/{id}")
    fun deletePost(@Path("id") postId: Int): Call<Post>
}