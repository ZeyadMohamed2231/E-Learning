package com.example.firsttime

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.firsttime.Model.DataResources.UpdatePassword
import com.example.firsttime.databinding.FragmentChangePassBinding
import com.example.firsttime.repository.Repository
import com.example.firsttime.utils.Constants
import com.example.firsttime.utils.Constants.Companion.UPDATE_PASSWORD
import com.example.firsttime.utils.Constants.Companion.URL
import com.example.firsttime.utils.Constants.Companion.URL3
import java.util.regex.Pattern

class ChangePass : Fragment() {
    private var binding: FragmentChangePassBinding?= null
    private lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentChangePassBinding.inflate(inflater, container, false)
        binding = fragmentBinding
//        binding?.submit?.setOnClickListener{
//
//            val Email= binding!!.Email.text.toString()
//            val OldPass= binding!!.OldPassword.text.toString()
//            val NewPass= binding!!.NewPassword.text.toString()
//            //check(Email,OldPass,NewPass)
//        }
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.submit?.setOnClickListener {
            val Email = binding!!.Email.text.toString()
            val OldPass = binding!!.OldPassword.text.toString()
            val NewPass = binding!!.NewPassword.text.toString()
            if (!Constants.isNetworkAvailable(context)) {
                alertt(
                    "No internet",
                    "Please make sure you are connected to the internet and that your email and password are right.",
                    "close"
                )
                Log.i("_____try", "1")
            } else {

                URL=URL3
                URL= URL+ UPDATE_PASSWORD
                Log.i("_____try", "2")

                val repository1 = Repository()
                val viewModelFactory1 = UserViewModelFactory(repository1)
                viewModel =
                    ViewModelProvider(this, viewModelFactory1).get(UserViewModel::class.java)
                var updatePassword = UpdatePassword(Email, OldPass, NewPass)

                viewModel.pushPassword(updatePassword)

                Log.i("_____try", "3")

                viewModel.updatePassword.observe(viewLifecycleOwner, Observer { response1 ->

                    Log.i("_____try", "4")

                    Log.i("hey", response1.code().toString())

//                    if (response1.body() == null) {
//
//                        Log.i("_____try", "5")
//
//                        Log.d("no internet", response1.code().toString())
//                        Log.d("code_", response1.code().toString())
//                        //alert(Alertflag)
//                        alertt(
//                            "Warning",
//                            "Something went wrong.",
//                            "close"
//                        )
//                    }
                    if (response1.isSuccessful) {

                        Log.i("_____try", "6")

                        Log.i("From Login", response1.code().toString())
                        Alertflag = false
                        //alert(Alertflag)
                        alertt(
                            "Succefully executed",
                            "Your password was changed ",
                            "close"
                        )

                    } else {

                        Log.i("_____try", "7")

                        alertt(

                            "Error",
                            "Please make sure you have entered your info correctly ",
                            "close"
                        )
                    }


                })


            }


        }
    }





    fun alertt(Title: String, Message: String, Buttonanme: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(Title)
        builder.setMessage(Message)
        builder.setPositiveButton(Buttonanme, { dialogInterface: DialogInterface, i: Int -> })
        Log.d("MainActivity", "onCreate Alert")
        builder.show()
    }


    fun check(Email: String,OldPass:String,NewPass:String){

        if(isEmailValid(Email)&&isValidPasswordFormat(OldPass)&&isValidPasswordFormat(NewPass)){
            val builder = AlertDialog.Builder(context)
            val dialogView =layoutInflater.inflate(R.layout.custom_dialog,null)
            val message =dialogView.findViewById<TextView>(R.id.message)
            message.text ="Loading.."
            builder.setView(dialogView)
            builder.setCancelable(false)
            val dialog =builder.create()
            Log.d("MainActivity", "onCreate Loading")
            dialog.show()
            Handler().postDelayed({dialog.dismiss()},5000)
            findNavController().navigate(R.id.action_changePass_to_login)
        }else{
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Wrong Email or Password")
            builder.setMessage("Check Your Email and Password")
            builder.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int -> })
            Log.d("MainActivity", "onCreate Alert")
            builder.show()
        }
    }
    fun isEmailValid(email: String): Boolean {
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true}
        else {
            return false
        }
    }
    fun isValidPasswordFormat(password: String): Boolean {
        val passwordREGEX = Pattern.compile(
            "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$")
        if(passwordREGEX.matcher(password).matches()){
            return true
        }else{
            return false
        }
    }



}