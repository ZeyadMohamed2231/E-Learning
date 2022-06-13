package com.example.firsttime

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.firsttime.databinding.FragmentRow1Binding


class row1 : Fragment() {
    private var _binding: FragmentRow1Binding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val callback=object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Log.d("MainActivity", "onhandle loadiinnggg")
                val builder = AlertDialog.Builder(context)
                builder.setMessage("Are you Sure To Exit ?")
                builder.setCancelable(true)
                builder.setNegativeButton("No", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                    dialogInterface.cancel()
                })
                builder.setPositiveButton("Yes", DialogInterface.OnClickListener{
                    dialogInterface, i ->
                    getActivity()?.finish()
                })
                val alertDialog =builder.create()
                alertDialog.show()
            }
        }

        _binding = FragmentRow1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun alertt(Title: String, Message: String, Buttonanme: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(Title)
        builder.setMessage(Message)
        builder.setPositiveButton(Buttonanme, { dialogInterface: DialogInterface, i: Int -> })
        Log.d("MainActivity", "onCreate Alert")
        builder.show()
    }


}