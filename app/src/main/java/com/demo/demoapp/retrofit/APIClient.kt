package com.demo.demoapp.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    private var retrofit: Retrofit? = null

    fun getInstanse():Retrofit?{
        val client = OkHttpClient
                .Builder()
                .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://demo3231717.mockable.io")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }
}