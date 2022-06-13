package com.example.firsttime.api

import android.util.Log
import com.example.firsttime.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance2 {

    private val retrofit2 by lazy {
        Log.i("From Retrofit 2", Constants.URL2)
        Retrofit.Builder()
            .baseUrl(Constants.URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api2: DataApi by lazy {
        RetrofitInstance2.retrofit2.create(DataApi::class.java)
    }
}