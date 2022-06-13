package com.example.firsttime

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.firsttime.databinding.FragmentWelcomeBinding
import com.example.firsttime.utils.Constants


class Welcome : Fragment() {
    private var binding: FragmentWelcomeBinding?= null
    val appData: AppData by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root


    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){

            val deviceID = Settings.Secure.getString(
                activity?.contentResolver,
                Settings.Secure.ANDROID_ID
            )

            Constants.SERIAL =deviceID
            Log.i("Mainnn", deviceID)
        } else{
            Constants.SERIAL = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                Build.getSerial()
            } else {
                Build.SERIAL;
            }

            Log.i("Mainnn", Constants.SERIAL)
        }


        binding?.button?.setOnClickListener{




            val serial=Constants.SERIAL
            val action=WelcomeDirections.actionWelcomeToLogin(serial)
            findNavController().navigate(action)


        }


    }





    }





