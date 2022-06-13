package com.example.firsttime

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttime.Model.DataResources.CourseDataResources
import com.example.firsttime.databinding.FragmentCoursesBinding

//videos
class Courses : Fragment() {

    val args:CoursesArgs by navArgs()

    private var _binding: FragmentCoursesBinding? = null
    private lateinit var viewModel: UserViewModel
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true
    val arrayList=ArrayList<Modell>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        _binding = FragmentCoursesBinding.inflate(inflater, container, false)

        val view = binding.root

//                Constants.URL = Constants.URL3
//        Constants.URL = Constants.URL + Constants.COURSEURL +"test@gmail.com"+ "/"
//
//
//        val repository2 = Repository()
//
//
//        val viewModelFactory = UserViewModelFactory(repository2)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)
//
//
//        viewModel.getCourseData()
//
//        viewModel.courseDataResponse.observe(viewLifecycleOwner, Observer { response ->
//
//            if (response==null){
//                alertt(
//                    "Warning",
//                    "Please make sure you are connected to the internet and try again",
//                    "close"
//                )
//                Log.i("From on view1", response?.body()?.data.toString())
//            }
//
//            else if (response.isSuccessful) {
//                Log.d("From on view1", response.body()?.data.toString())
//
//            } else {
//                alertt(
//                    "Warning",
//                    "Please make sure you are connected to the internet and try again",
//                    "close"
//                )
//
//            }
//
//
//        })

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        val a7a=args.exchangeNavigation
        val a72=args.courseDataNav!!
        Log.d("MainActivity", a7a)
        Log.d("MainActivity", a72.toString())

        val x="sda"
        Log.d("2ndTest",x)
//        Log.d("courses",)

        chooseLayout(a72)
    }


    private fun chooseLayout(courseDataResources: CourseDataResources) {
        Log.d("MainActivity", "Choose layout")


     setVideos("Cs","a7a tamer zebo zalbya",R.drawable.contact,"yaaaarn",courseDataResources)


        when (isLinearLayoutManager) {
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = context?.let { MyAdapterCourses(arrayList, it) }
            }
//            false -> {
//                recyclerView.layoutManager = GridLayoutManager(context, 4)
//                recyclerView.adapter = context?.let { MyAdapter(arrayList, it) }
//            }
        }
    }

    fun setVideos(Title:String,Des:String,Image:Int,Data:String,courseDataResources: CourseDataResources){
        for(i in 1..10){
            arrayList.add(Modell(Title,Des,Image,Data,courseDataResources))
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