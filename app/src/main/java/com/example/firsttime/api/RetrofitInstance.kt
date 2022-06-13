package com.example.firsttime.api

import android.util.Log
import com.example.firsttime.utils.Constants.Companion.URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private val retrofit by lazy {
        Log.i("From Retrofit 1", URL)
        Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }




    val api: DataApi by lazy {
        retrofit.create(DataApi::class.java)
    }




}
