package com.example.firsttime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firsttime.Model.DataResources.CourseDataResources
import com.example.firsttime.Model.DataResources.UserDataResources
import retrofit2.Response

class AppData : ViewModel() {


    private val _email = MutableLiveData<String>("dumy")
    var email: LiveData<String> = _email
//
//    private val _password = MutableLiveData<String>("dumy")
//    val password: LiveData<String> = _password
//
    private val _secretPassword = MutableLiveData<String>("dumy")
    var secretPassword: LiveData<String> = _secretPassword
//
//
//    public var _serial = MutableLiveData<String>("dumy")
//
//
//    private val _appInfo = MutableLiveData<String>("dumy")
//    val appInfo: LiveData<String> = _appInfo
//
//    private val _message = MutableLiveData<String>("dumy")
//    val message: LiveData<String> = _message
//
//    private val _buildNumber = MutableLiveData<String>("dumy")
//    val buildNumber: LiveData<String> = _buildNumber

    var userDataResponse: MutableLiveData<Response<UserDataResources>> = MutableLiveData()
    val courseDataResponse: MutableLiveData<Response<CourseDataResources>> = MutableLiveData()


//    private val coursData:MutableLiveData<HashMap<String,HashMap<String,HashMap<String,String>>>>
//        get() {
//            val userData=_userData
//            return userData
//        }
//


}