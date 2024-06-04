package com.busanit.ch12_network.news

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetrofitClient {

    private const val BASE_URL = "https://newsapi.org/"

    val instance: NewsApiService by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(NewsApiService::class.java)
    }
}