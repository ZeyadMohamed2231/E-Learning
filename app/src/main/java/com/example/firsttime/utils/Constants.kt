package com.example.firsttime.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class Constants {


    companion object{

        var STUDENTURL="studentInfo/"

        var COURSEURL="courseInfo/"

        var UPDATE_PASSWORD="updatePasswords/"

        var SERIAL_UPDATE="serielUpdate/"

        var URL = "https://e---learning.herokuapp.com/E-Learning/mobileApp/"    //This will be replaced with our website.

        var URL2 = "https://e---learning.herokuapp.com/E-Learning/mobileApp/"

        var URL3 = "https://e---learning.herokuapp.com/E-Learning/mobileApp/"

        var URL4 = "https://e---learning.herokuapp.com/E-Learning/mobileApp/"


        var SERIAL=""


        fun isNetworkAvailable(context: Context?): Boolean {
            if (context == null) return false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    when {
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                            return true
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                            return true
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                            return true
                        }
                    }
                }
            } else {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                    return true
                }
            }
            return false
        }

    }

}