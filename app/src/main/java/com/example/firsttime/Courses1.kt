package com.example.firsttime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firsttime.databinding.FragmentCourses1Binding

class Courses1 : Fragment() {


    private var _binding: FragmentCourses1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourses1Binding.inflate(inflater, container, false)

        return binding.root
    }

//    private fun moveToNewActivity() {
//        val i = Intent(getActivity(),MainActivity2::class.java )
//        startActivity(i)
//        (getActivity() as Activity).overridePendingTransition(0, 0)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }






}