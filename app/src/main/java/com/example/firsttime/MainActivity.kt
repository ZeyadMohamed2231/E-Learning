package com.example.firsttime

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.firsttime.utils.Constants.Companion.SERIAL
import com.example.firsttime.utils.Constants.Companion.URL


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    private lateinit var viewModel:UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)



        //User data calling

//        URL= URL+ STUDENTURL +"test@gmail.com"+"/"
//
//
//        val repository= Repository()
//
//
//        val viewModelFactory=UserViewModelFactory(repository)
//        viewModel= ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
//        viewModel.getUserData()
//
//        Log.i("Mainn","1")
//
//        viewModel.userDataResponse.observe(this, Observer { response ->
//                    Log.i("Mainn","2")
//                    if (response.isSuccessful) {
//                        Log.d("Mainn", response.body()?.data.toString())
//                        Log.i("Mainn","3")
//                        Log.i("Frag_success", "------------------------")
//
//                    }else{
//                        Log.d("Error", response.code().toString())
//
//                    }
//
//                    })

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){

            val deviceID = Settings.Secure.getString(contentResolver,
                Settings.Secure.ANDROID_ID)

            SERIAL=deviceID
            Log.i("Mainnn",deviceID)
        } else{
            SERIAL = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                Build.getSerial()
            } else {
                Build.SERIAL;
            }

            Log.i("Mainnn", SERIAL)
        }









        Log.d("DIFF", URL)







        //courses data calling

//        URL= URL+ Constants.COURSEURL +"test@gmail.com"+"/"

//        URL= URL2
//        URL= URL2+SERIAL_UPDATE
//
//        Log.d("DIFF", URL)
//
//        val repository= Repository()
//        val viewModelFactory=UserViewModelFactory(repository)
//        viewModel= ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
//
//        var serial= SerialUpdate("test@gmail.com", SERIAL)
//
//        viewModel.pushSerial(serial)
//
//
//        Log.i("Mainn","1")
//
//        viewModel.serialUpdate.observe(this, Observer { response ->
//                    Log.i("Mainn","2")
//                    if (response.isSuccessful) {
//                        Log.d("Mainn", response.body().toString())
//                        Log.i("Mainn","3")
//                        Log.i("Frag_success", "------------------------")
//
//                    }else{
//                        Log.d("Error", response.code().toString())
//
//                    }
//
//                    })


//-------------------------------------------------------------------------------------------------------------------
//        val repository1= Repository()
//        val viewModelFactory1=UserViewModelFactory(repository1)
//        viewModel = ViewModelProvider(this, viewModelFactory1).get(UserViewModel::class.java)
//        var serial= SerialUpdate("test@gmail.com", SERIAL)
//
//        viewModel1.pushSerial(serial)
//
//        viewModel1.serialUpdate.observe(this, Observer { response1 ->
//
//            Log.i("hey",response1.code().toString())
//            if (!response1.isSuccessful){
//                Log.i("From Login",response1.code().toString())
//                Alertflag=false
//                //alert(Alertflag)
//                alertt("Warning","Please make sure you are connected to the internet","close")
//                passwordVerifyFlag=false
//                serialVerifyFlag=false
//                buildVerify=false
//            }
//
//
//        })




    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}



