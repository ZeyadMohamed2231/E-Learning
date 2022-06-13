package com.example.firsttime.Model.DataResources

import com.google.gson.annotations.SerializedName

data class UserDataResources(

        @SerializedName("data")

        val data:HashMap<String,HashMap<String,HashMap<String,String>>>,

        @SerializedName("availableOrNot")

        val data2:String


//        @SerializedName("email")
//
//        val email:String,
//
//        @SerializedName("secretPassword")
//
//        val secretPassword:String,
//
//        @SerializedName("password")
//
//        val password:String,

//        @SerializedName("message")
//
//        val message:String,
//
//        @SerializedName("buildNumber")
//
//        val buildNumber:String

//        @SerializedName("serial")
//
//        val serial:String,



//        @SerializedName("availableOrNot")
//       val status:Boolean
)
//will be changed to fit our  api
//    val email:String,
//    val password:String,
//    val secretPasswordOfStudent: String,
//    val serial:String,
//    val appInfo:String,
//    val message:String,
//    val buildNumber:String












