import android.util.Log
import com.example.firsttime.api.DataApi
import com.example.firsttime.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance3 {

    private val retrofit3 by lazy {
        Log.i("From Retrofit 2", Constants.URL4)
        Retrofit.Builder()
            .baseUrl(Constants.URL4)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api3: DataApi by lazy {
        RetrofitInstance3.retrofit3.create(DataApi::class.java)
    }
}