package com.example.basicretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val apiClient: ApiService = ApiClient.getApiClient()

        button.setOnClickListener {
            //enqueue asynchron
            apiClient.getPostList().enqueue(object : Callback<List<Post>> {
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    Log.e("getPostList", "onFailure:${t.message}")
                }

                override fun onResponse(
                    call: Call<List<Post>>,
                    response: Response<List<Post>>
                ) {
                    for (i in 0 until response.body()!!.size) {
                        Log.d("getPostList", "onResponse:${response.body()?.get(i)?.title}")
                    }
                }

            })
        }

        button2.setOnClickListener {
            apiClient.getSinglePost(1).enqueue(object : Callback<Post> {
                override fun onFailure(call: Call<Post>, t: Throwable) {
                    Log.e("getSinglePost", "onFailure:${t.message}")
                }

                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    Log.d("getPostList", "onResponseGetPostList:${response.body()?.title}")
                }

            })
        }

        button3.setOnClickListener {
            apiClient.getPostWithQuery(10).enqueue(object : Callback<List<Post>> {
                override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                    Log.e("getPostQuery", "onFailure:${t.message}")
                }

                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    for (i in 0 until response.body()!!.size) {
                        Log.d("getPostWithQuery", "onResponse:${response.body()?.get(i)?.title}")
                    }
                }

            })
        }

        button4.setOnClickListener {
            apiClient.savePostWithField("test title", "test body").enqueue(object : Callback<Post> {
                override fun onFailure(call: Call<Post>, t: Throwable) {

                    Log.e("savePostWithField", "onFailure:${t.message}")
                }

                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    Log.d(
                        "savePostWithField",
                        "onResponse: Title = ${response.body()?.title} body = ${response.body()?.body}"
                    )
                }

            })
        }

        button5.setOnClickListener {
            apiClient.updatePost(1, "update title", "updated body")
                .enqueue(object : Callback<Post> {
                    override fun onFailure(call: Call<Post>, t: Throwable) {

                        Log.e("updatePost", "onFailure:${t.message}")
                    }

                    override fun onResponse(call: Call<Post>, response: Response<Post>) {

                        Log.d(
                            "updatePost",
                            "onResponse: Title = ${response.body()?.title} body = ${response.body()?.body}"
                        )
                    }

                })
        }

        button6.setOnClickListener {
            apiClient.deletePost(2).enqueue(object : Callback<Post> {
                override fun onFailure(call: Call<Post>, t: Throwable) {
                    Log.e("deletePost", "onFailure:${t.message}")
                }

                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    Log.d("deletePost", "onrResponse = ${response.body()}")
                }

            })
        }

    }

}

