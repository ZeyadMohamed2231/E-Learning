package com.example.firsttime


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttime.Model.DataResources.CourseDataResources
import com.example.firsttime.Model.DataResources.SerialUpdate
import com.example.firsttime.Model.DataResources.UpdatePassword
import com.example.firsttime.Model.DataResources.UserDataResources
import com.example.firsttime.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val repository: Repository) : ViewModel() {


    val userDataResponse: MutableLiveData<Response<UserDataResources>> = MutableLiveData()
    val courseDataResponse: MutableLiveData<Response<CourseDataResources>> = MutableLiveData()
    val updatePassword: MutableLiveData<Response<UpdatePassword>> = MutableLiveData()
    val serialUpdate: MutableLiveData<Response<SerialUpdate>> = MutableLiveData()


//    fun getUserData() {
//        viewModelScope.launch {
//
//            repository.getUserData().enqueue(object : Callback<UserDataResources> {
//                override fun onResponse(call: Call<UserDataResources>, response: Response<UserDataResources>) {
//                    myResponse.value = response
//                }
//
//                override fun onFailure(call: Call<UserDataResources>, t: Throwable) {
//                    myResponse.value = null
//                }
//            })
//        }
//    }


    fun getUserData() {
        viewModelScope.launch {

            try {


                val response: Response<UserDataResources> = repository.getUserData()
                userDataResponse.value = response
            }catch (e:Exception){
                courseDataResponse.value=null
            }

        }
    }

    fun getCourseData() {
        viewModelScope.launch {


                try {
                    val response: Response<CourseDataResources> = repository.getCourseData()
                    courseDataResponse.value = response
                }catch (e:Exception){
                    courseDataResponse.value= null
                }



        }
    }

    fun pushPassword(_updatePassword: UpdatePassword){
        viewModelScope.launch {
            try {
                val response: Response<UpdatePassword> = repository.pushPassword(_updatePassword)
                updatePassword.value = response
            }catch (e:Exception) {
                updatePassword.value=null
            }
        }
    }

    fun pushSerial(_updateSerial: SerialUpdate){
        viewModelScope.launch {
            try {
                val response: Response<SerialUpdate> = repository.pushSerial(_updateSerial)
                serialUpdate.value = response
            }catch (e:Exception) {
                updatePassword.value=null
            }
        }
    }





}
//
//    fun pushUserData(userData: UserDataResources) {
//        viewModelScope.launch {
//            val response:Response<UserDataResources> = repository.pushUserData(userData)
//            myResponse.value = response
//        }
//    }                //Use my response incase of not using list and you won't use lists.



//        val repository= Repository()
//        val viewModelFactory=UserViewModelFactory(repository)
//
//        viewModel= ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
//
//        Log.i("hi","1")
//
//        viewModel.getUserData1("soluta aliquam aperiam consequatur illo quis voluptas")    //2 is the thing enterred in the api.
//
//        Log.i("DWORD1","2")
//
//
//
//
//            viewModel.userDataResponse.observe(this, Observer { response ->
//
//                Log.i("DWORD","9")
//                if (response.isSuccessful) {
//
//                    response.body()?.forEach {
//                        Log.d("Frag_success", it.userId.toString())
//                        Log.d("Frag_success", it.id.toString())
//                        Log.d("Frag_success", it.body!!)
//                        Log.d("Frag_success", it.title!!)
//                        Log.i("Frag_success", "------------------------")
//                    }
//                } else{
//                    Log.i("TAKEN","no")
//            }
//            })
//
//

// Set up the action bar for use with the NavController

//        val repository= Repository()
//        val viewModelFactory=UserViewModelFactory(repository)
//
//        viewModel= ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
//
//        viewModel.getUserData()
//
//
//
//        viewModel.myResponse.observe(this, Observer { response ->
//
//            Log.d("Mainhey",response.body()?.userId.toString())
//            Log.d("Mainhey",response.body()?.Id.toString())
//            Log.d("Mainhey",response.body()?.body.toString())
//            Log.d("Mainhey",response.body()?.title.toString())
//
//        })






/////fromm oncreatte fragment
//Log.i("1","1")
//
//val repository= Repository()
//
//Log.i("2","2")
//val viewModelFactory=UserViewModelFactory(repository)
//Log.i("3","3")
//
//viewModel= ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
//Log.i("4","4")
//
//
//
//viewModel.getUserData1("hhh")
////
////
//
//
//
//Log.i("5","5")



























//        val repository= Repository()
//        val viewModelFactory=UserViewModelFactory(repository)
//
//        viewModel= ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
//
//        Log.i("hi","1")
//
//        viewModel.getUserData()
//
//        Log.i("hi","2")
//
//
//        try {
//
//
//        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
//
//                 Log.i("hi","3")
//                if (response.isSuccessful) {
//                    Log.d("Frag_success", response.body()?.userId.toString())
//                    Log.d("Frag_success", response.body()?.Id.toString())
//                    Log.d("Frag_success", response.body()?.body!!)
//                    Log.d("Frag_success", response.body()?.title!!)
//                    Log.i("hi","4")
//                }else{
//                    Log.i("hi","5")
//                    Log.i("No","NONO")
//                    Log.i("hi","6")
//                }
//
//
//        })}catch (e:Exception){
//            Log.i("no","noooo")
//        }

//        val repository= Repository()
//        val viewModelFactory=UserViewModelFactory(repository)
//
//        viewModel= ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
//
//        Log.i("hi","1")
//
//        viewModel.getUserData1("soluta aliquam aperiam consequatur illo quis voluptas")    //2 is the thing enterred in the api.
//
//        Log.i("DWORD1","2")
//
//
//
//
//        viewModel.userDataResponse.observe(viewLifecycleOwner, Observer { response ->
//
//            Log.i("DWORD","9")
//            if (response.isSuccessful) {
//
//                response.body()?.forEach {
//                    Log.d("Frag_success", it.userId.toString())
//                    Log.d("Frag_success", it.id.toString())
//                    Log.d("Frag_success", it.body!!)
//                    Log.d("Frag_success", it.title!!)
//                    Log.i("Frag_success", "------------------------")
//                }
//            } else{
//                Log.i("TAKEN","no")
//            }
//        })






//        val repository = Repository()
//        val viewModelFactory = UserViewModelFactory(repository)
//        viewModel= ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
//
//        viewModel.pushUserData(myPost)
//
//        viewModel.enqueue()
//
//        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
//            if(response.isSuccessful){
//                Log.d("Main", response.body().toString())
//                Log.d("Main", response.code().toString())
//                Log.d("Main", response.message())
//            }else {
//                Log.d("Main", response.errorBody().toString())
//            }
//        })





