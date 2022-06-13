package com.example.firsttime

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttime.Model.DataResources.CourseDataResources
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val arrayList: ArrayList<Modell>,val context:Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(model: Modell){
            itemView.titleTv.text = model.title
            itemView.descriptionTv.text=model.des
            itemView.imageIv.setImageResource(model.image)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)

        return ViewHolder(v)
    }

    inline fun <reified T : Fragment> NavController.safeNavigate(directions: NavDirections) {
        val destination = this.currentDestination as FragmentNavigator.Destination
        if (T::class.java.name == destination.className) {
            Log.d("MainActivity","Doneeee")
            navigate(directions)
        }else{
            Log.d("MainActivity","Errrrooorrrrrrrrr")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])



        holder.itemView.setOnClickListener {





            val model =arrayList.get(position)

            var gtitle:String=model.data
            var gdis:CourseDataResources=model.courseDataResources

            Log.d("MainActivity","Holdder Loading 0")
              val action = navigationDirections.actionNavigationToCourses2(gtitle,gdis)
              Log.d("MainActivity","Holdder Loading 1")
            holder.itemView.findNavController().safeNavigate<navigation>(action)

            Log.d("MainActivity", "Holdder Loading 2")

        }
    }





    override fun getItemCount(): Int {
        return arrayList.size
    }

}