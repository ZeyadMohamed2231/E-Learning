package com.example.firsttime

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttime.Model.DataResources.CourseDataResources
import com.example.firsttime.databinding.FragmentNavigationBinding
import com.example.firsttime.repository.Repository
import com.example.firsttime.utils.Constants


class navigation : Fragment() {
    val args:navigationArgs by navArgs()
    private lateinit var viewModel: UserViewModel
    private var _binding: FragmentNavigationBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true
    val arrayList=ArrayList<Modell>()
    var flag:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationBinding.inflate(inflater, container, false)
        val view = binding.root


        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        val data=args.exchangeNavigation


        val list=data.split("/")   // [email,secretPassword]
        Log.d("From nav",list.toString())

        Constants.URL = Constants.URL3
        Constants.URL4 = Constants.URL4 + Constants.COURSEURL +list[0]+ "/"

        var courseDataResources:CourseDataResources

        val repository2 = Repository()


        val viewModelFactory = UserViewModelFactory(repository2)
        viewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)


        viewModel.getCourseData()

        viewModel.courseDataResponse.observe(viewLifecycleOwner, Observer { response ->

            if (response==null){
                alertt(
                    "Warning",
                    "Please make sure you are connected to the internet and try again",
                    "close"
                )
                Log.i("From on view1", response?.body()?.data.toString())
            }

            else if (response.isSuccessful) {
                Log.d("From on view1_________", response.body()?.data.toString())


                    courseDataResources = response.body()!!
                    chooseLayout(courseDataResources)

            } else {
                alertt(
                    "Warning",
                    "Please make sure you are connected to the internet and try again",
                    "close"
                )

            }




        })




    }

    private fun moveToNewActivity() {
        val i = Intent(getActivity(),MainActivity::class.java )
        startActivity(i)
        (getActivity() as Activity).overridePendingTransition(0, 0)
    }




    private fun chooseLayout(courseDataResources: CourseDataResources) {
        Log.d("MainActivity", "Choose layout")



        setCourses(courseDataResources)
        when (isLinearLayoutManager) {
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = context?.let { MyAdapter(arrayList, it) }
            }
//            false -> {
//                recyclerView.layoutManager = GridLayoutManager(context, 4)
//                recyclerView.adapter = context?.let { MyAdapter(arrayList, it) }
//            }
        }
    }
    fun setCourses(courseDataResources: CourseDataResources){

        var course="course "

        for (i in 0..(courseDataResources.numberOfCourses-1)) {

            course+=i.toString()
           val courseName= courseDataResources.data.get(course)?.get(0)?.get(0)?.get("courseName").toString()    //get name of course

           val doctorName= courseDataResources.data.get(course)?.get(0)?.get(0)?.get("doctorName").toString()

          ///  var multimediaData:MultimediaData(courseDataResources.data.get(course)?.get(1))
            courseDataResources.data.get(course)?.get(1).toString()
            arrayList.add(Modell(courseName,doctorName,R.drawable.contact,course,courseDataResources))

            course="course "
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




}