package com.example.carenta

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    // initiation of the endpoint interface
    val endpoint = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(Endpoint::class.java)

}