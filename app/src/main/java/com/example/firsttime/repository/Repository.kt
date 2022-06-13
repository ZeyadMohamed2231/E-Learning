package com.example.firsttime.repository

import RetrofitInstance3
import com.example.firsttime.Model.DataResources.CourseDataResources
import com.example.firsttime.Model.DataResources.SerialUpdate
import com.example.firsttime.Model.DataResources.UpdatePassword
import com.example.firsttime.Model.DataResources.UserDataResources
import com.example.firsttime.api.RetrofitInstance
import com.example.firsttime.api.RetrofitInstance2
import retrofit2.Response

class Repository {

    suspend fun getUserData(): Response<UserDataResources> {
        return RetrofitInstance.api.getUserData()
    }


    suspend fun getCourseData(): Response<CourseDataResources> {
        return RetrofitInstance3.api3.getCourseData()
    }

    suspend fun pushPassword(updatePassword: UpdatePassword): Response<UpdatePassword> {
        return RetrofitInstance.api.pushPassword(updatePassword)
    }

    suspend fun pushSerial(serialUpdate: SerialUpdate): Response<SerialUpdate> {
        return RetrofitInstance2.api2.pushSerial(serialUpdate)
    }


}
//    suspend fun getUserData1(title: String): Response<List<UserDataResources>> {
//        return RetrofitInstance.api.getUserData1(title)
    // }




//    suspend fun pushUserData(userData: UserDataResources): Response<UserDataResources> {
//        return RetrofitInstance.api.pushUserData(userData)
//    }
//}