package com.example.firsttime.api

import com.example.firsttime.Model.DataResources.CourseDataResources
import com.example.firsttime.Model.DataResources.SerialUpdate
import com.example.firsttime.Model.DataResources.UpdatePassword
import com.example.firsttime.Model.DataResources.UserDataResources
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DataApi {

    @GET("ddpuP0sVKVPFkj0u9IOVARvg6saY3NrOPeCWlvq")             //This should be the end point for our website.
    suspend fun getUserData():Response<UserDataResources>

    @GET("ddpuP0sVKVPFkj0u9IOVARvg6saY3NrOPeCWlvq")
    suspend fun getCourseData():Response<CourseDataResources>


    @POST("ddpuP0sVKVPFkj0u9IOVARvg6saY3NrOPeCWlvq")
    suspend fun pushPassword(
        @Body userData: UpdatePassword
    ): Response<UpdatePassword>

    @POST("ddpuP0sVKVPFkj0u9IOVARvg6saY3NrOPeCWlvq")
    suspend fun pushSerial(
        @Body userData: SerialUpdate
    ): Response<SerialUpdate>


}
