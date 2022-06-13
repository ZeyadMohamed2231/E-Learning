package com.example.firsttime.Model.DataResources

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CourseDataResources(
        @SerializedName("data")
        val data:HashMap<String,List<List<HashMap<String,String>>>>
        ,

        @SerializedName("numberOfCourses")
        val numberOfCourses: Int,

        @SerializedName("status")
        val status:String

        //val data:HashMap<String,List<Pair<HashMap<String,String>,List<HashMap<String,String>>>>>
):Parcelable
//val data:HashMap<String,<HashMap<String,String>List<HashMap<String,String>>>>

//coursesInfo:{courseName:{DrName:--,videosInfo:{videoName:video's link,secretPassword:--},testInfo:{testName:{testQuestions}}

