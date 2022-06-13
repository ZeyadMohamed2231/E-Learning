package com.example.firsttime

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.firsttime.Model.DataResources.SerialUpdate
import com.example.firsttime.databinding.FragmentLoginBinding
import com.example.firsttime.repository.Repository
import com.example.firsttime.utils.Constants.Companion.SERIAL
import com.example.firsttime.utils.Constants.Companion.SERIAL_UPDATE
import com.example.firsttime.utils.Constants.Companion.STUDENTURL
import com.example.firsttime.utils.Constants.Companion.URL
import com.example.firsttime.utils.Constants.Companion.URL2
import com.example.firsttime.utils.Constants.Companion.URL3
import com.example.firsttime.utils.Constants.Companion.isNetworkAvailable
import java.util.regex.Pattern


var binding: FragmentLoginBinding? = null
var Alertflag: Boolean = true

var serialUpdateFlag:Boolean=false

var passwordVerifyFlag:Boolean=false

var serialVerifyFlag :Boolean=false

var buildVerify :Boolean=true

var secretPassword="1"



class Login : Fragment() {
    val args:LoginArgs by navArgs()

    val appData: AppData by activityViewModels()

    private lateinit var viewModel: UserViewModel
  //  private lateinit var courseDataResources: CourseDataResources
    private lateinit var viewModel1: UserViewModel
    private lateinit var viewModel2: UserViewModel

    override fun onCreateView(




        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {

        SERIAL=args.Bye.toString()
        Log.d("MainActivity", SERIAL)
        val fragmentBinding = FragmentLoginBinding.inflate(inflater, container, false)

        binding = fragmentBinding






//        binding?.login?.setOnClickListener {
//            Alertflag=true
//            //alert(Alertflag)
//
//
//
//
//
//            val Email = binding!!.Email.text.toString()
//            val Pass = binding!!.Password.text.toString()






//            URL=URL3
//            URL = URL + Constants.COURSEURL +Email+ "/"
//
//            Log.d("URLLL", URL)

//            val repository2 = Repository()
//
//
//            val viewModelFactory2 = UserViewModelFactory(repository2)
//            viewModel2 = ViewModelProvider(this, viewModelFactory2).get(UserViewModel::class.java)
//
//
//            viewModel2.getCourseData()
//
//
//
//            viewModel2.courseDataResponse.observe(viewLifecycleOwner, Observer { response2 ->
//
//
//
//                 if (response2.isSuccessful) {
//                    Log.d("From on view", response2.body()?.data.toString())
//
//                    val x= response2.body()?.data?.let { CourseDataResources(it,0,"") }
//
//                    Log.d("From view 2",x?.data.toString())
//
//                } else {
//                    alertt(
//                        "Warning",
//                        "Please make sure you dsare connected to the internet and try again",
//                        "close"
//                    )
//
//                }
//
//
//            })









//
//            Log.d("Email", Email)
//
//            URL=URL3
//            URL = URL + STUDENTURL + Email + "/"
//
//
//            val repository = Repository()
//
//
//            val viewModelFactory = UserViewModelFactory(repository)
//            viewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)
//
//
//            viewModel.getUserData()
//
//            Log.i("Mainn", "1")
//
//            //Log.d("URL", URL)
//
//            if (!isNetworkAvailable(context)){
//                 alertt(
//                     "No internet",
//                     "Please make sure you are connected to the internet and that your email and password are right.",
//                     "close"
//                 )
//                }
//
//            viewModel.userDataResponse.observe(viewLifecycleOwner, Observer { response ->
//
//                if (response.body() == null) {
////                    Alertflag = false
//
//                    //alert(Alertflag)
//                    alertt(
//                        "Warning",
//                        "Something went wrong.",
//                        "close"
//                    )
//
//
//                   context?.let { it1 -> restart(it1) }
//
//                    URL = URL3
//
//                } else if (response.isSuccessful) {
//                    Log.d("data1111", response.body()?.data.toString())
//
//                    if (response.body()?.data?.get("StudentInfo")?.get("app")?.get("availableOrNot")
//                            .toString() == "true"
//                    ) {
//                        if (response.body()?.data?.get("StudentInfo")?.get("app")
//                                ?.get("buildNumber").toString().toDouble() > 1.0
//                        ) {
//                            buildVerify = false
//                            Alertflag = false
//                            //alert(Alertflag)
//                            alertt("Need update", "Please update your app", "close")
//                        } else {
//
//                            if (response.body()?.data?.get("StudentInfo")?.get("student")
//                                    ?.get("serial") == ""
//                            ) {
//                                serialUpdateFlag = true
//                                serialVerifyFlag = true
//                            } else if (response.body()?.data?.get("StudentInfo")?.get("student")
//                                    ?.get("serial") == SERIAL
//                            ) {
//                                serialVerifyFlag = true
//                            } else {
//                                serialVerifyFlag = false
//                                Alertflag = false
//                                //alert(Alertflag)
//                                alertt(
//                                    "Warning",
//                                    "Please enter the app with your registerred phone",
//                                    "close"
//                                )
//
//                            }
//                        }
//
//                        if (response.body()?.data?.get("StudentInfo")?.get("student")
//                                ?.get("password") == Pass
//                        ) {
//                            passwordVerifyFlag =
//                                true              //meaning the password is correct
//
//                            secretPassword =
//                                response.body()?.data?.get("StudentInfo")?.get("student")
//                                    ?.get("secretPassword")!!
//
//                        } else {
//                            passwordVerifyFlag = false
//                            alertt(
//                                "Warning",
//                                "Please enter correct email or password",
//                                "close"
//                            )
//
//                        }
//
//                    } else {
//                        Alertflag = false
//                        //alert(Alertflag)
//                        alertt(
//                            "Warning",
//                            response.body()?.data?.get("StudentInfo")?.get("app")?.get("message")
//                                .toString(), "close"
//                        )  //if response wasn't succeful.
//                    }
//
//
//                } else {
//                    Alertflag = false
//                    //alert(Alertflag)
//                    alertt(
//                        "Warning",
//                        "Something went wrong please make sure you have enterred your email and password correctly",
//                        "close"
//                    )
//                    URL = URL3
//
//                }
//
//
//
//                if (serialUpdateFlag) {
//
//                    URL2 = URL2 + SERIAL_UPDATE
//
//                    Log.d("from serial", URL2)
//
//                    val repository1 = Repository()
//                    val viewModelFactory1 = UserViewModelFactory(repository1)
//                    viewModel1 =
//                        ViewModelProvider(this, viewModelFactory1).get(UserViewModel::class.java)
//                    var serial = SerialUpdate(Email, SERIAL)
//
//                    viewModel1.pushSerial(serial)
//
//                    viewModel1.serialUpdate.observe(viewLifecycleOwner, Observer { response1 ->
//
//                        Log.i("hey", response1.code().toString())
//
//                        if (!response1.isSuccessful) {
//                            Log.i("From Login", response1.code().toString())
//                            Alertflag = false
//                            //alert(Alertflag)
//                            alertt(
//                                "Warning",
//                                "Please make sure you are connected to the internet",
//                                "close"
//                            )
//                            passwordVerifyFlag = false
//                            serialVerifyFlag = false
//                            buildVerify = false
//                        } else {
//                            serialVerifyFlag = true
//                        }
//
//
//                    })
//
//
//                }
//
//
//                Log.i("Overhere", "!!")
//
//                Log.i("serial", serialVerifyFlag.toString())
//                Log.i("serial", passwordVerifyFlag.toString())
//                Log.i("serial", buildVerify.toString())
//                if (serialVerifyFlag == true && passwordVerifyFlag == true && buildVerify == true) {
//
//                    //val action=WelcomeDirections.actionWelcomeToLogin(serial)
//
//
//                      val data=Email+"/"+ secretPassword
//                      val action=LoginDirections.actionLoginToNavigation(data,courseDataResources)
//
//                    findNavController().navigate(action)
//
//                }
//
//
//            })
//            URL=URL3
//        }
        binding?.Needhelp?.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_changePass)
        }

        return fragmentBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val x =view.findViewById<View>(R.id.login)
        x.setOnClickListener {

            val Email = binding!!.Email.text.toString()
            val Pass = binding!!.Password.text.toString()

//            URL = URL3
//            URL4 = URL4 + COURSEURL + Email + "/"
//
//
//
//            val repository2 = Repository()
//
//
//            val viewModelFactory2 = UserViewModelFactory(repository2)
//            viewModel2 = ViewModelProvider(this, viewModelFactory2).get(UserViewModel::class.java)
//
//
//            viewModel2.getCourseData()
//
//
//
//            viewModel2.courseDataResponse.observe(viewLifecycleOwner, Observer { response2 ->
//
//                if (response2== null) {
//                    alertt(
//                        "Warning",
//                        "Please make sure you are connecsadted to the internet and try again",
//                        "close"
//                    )
////               Log.i("From on view", response2?.body()?)
//                } else if (response2.isSuccessful) {
//                    Log.d("From on view", response2.body()?.data.toString())
//
//                    //courseDataResources = response2.body()?.data?.let { CourseDataResources(it, 0, "") }!!
//
//                 //   Log.d("From view 2", courseDataResources.data.toString())
//
//                } else {
//                    alertt(
//                        "Warning",
//                        "Please make sure you are connecdfsted to the internet and try again",
//                        "close"
//                    )
//
//                }
//
//
//            })
//
//
//




//
//            URL=URL3
//            URL = URL + Constants.COURSEURL +Email+ "/"
//
//            Log.d("URLLL", URL)
//
//            val repository2 = Repository()
//
//
//            val viewModelFactory2 = UserViewModelFactory(repository2)
//            viewModel2 = ViewModelProvider(this, viewModelFactory2).get(UserViewModel::class.java)
//
//
//            viewModel2.getCourseData()
//
//
//
//            viewModel2.courseDataResponse.observe(viewLifecycleOwner, Observer { response2 ->
//
//
//
//                 if (response2.isSuccessful) {
//                    Log.d("From on view", response2.body()?.data.toString())
//
//                    val x= response2.body()?.data?.let { CourseDataResources(it,0,"") }
//
//                    Log.d("From view 2",x?.data.toString())
//
//                } else {
//                    alertt(
//                        "Warning",
//                        "Please make sure you dsare connected to the internet and try again",
//                        "close"
//                    )
//
//                }
//
//
//            })










            Log.d("Email", Email)

            URL=URL3
            URL = URL + STUDENTURL + Email + "/"

            Log.d("URL", URL)

            val repository = Repository()


            val viewModelFactory = UserViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)


            viewModel.getUserData()

            Log.i("Mainn", "1")

            //Log.d("URL", URL)

            if (!isNetworkAvailable(context)){
                 alertt(
                     "No internet",
                     "Please make sure you are connected to the internet and that your email and password are right.",
                     "close"
                 )
                }

            viewModel.userDataResponse.observe(viewLifecycleOwner, Observer { response ->

                if (response == null) {
//                    Alertflag = false

                    //alert(Alertflag)
                    alertt(
                        "Warning",
                        "Something went wrong.",
                        "close"
                    )


                   context?.let { it1 -> restart(it1) }



                } else if (response.isSuccessful) {
                    Log.d("data1111", response.body()?.data.toString())
                        URL= URL3
                    if (response.body()?.data?.get("StudentInfo")?.get("app")?.get("availableOrNot")
                            .toString() == "true"
                    ) {
                        if (response.body()?.data?.get("StudentInfo")?.get("app")
                                ?.get("buildNumber").toString().toDouble() > 1.0
                        ) {
                            buildVerify = false
                            Alertflag = false
                            //alert(Alertflag)
                            alertt("Need update", "Please update your app", "close")
                        } else {

                            if (response.body()?.data?.get("StudentInfo")?.get("student")
                                    ?.get("serial") == ""
                            ) {
                                serialUpdateFlag = true
                                serialVerifyFlag = true
                            } else if (response.body()?.data?.get("StudentInfo")?.get("student")
                                    ?.get("serial").toString() == SERIAL
                            ) {
                                serialVerifyFlag = true
                            } else {
                                serialVerifyFlag = false
                                Alertflag = false
                                //alert(Alertflag)
                                Log.d("mobile serial", SERIAL)
                                Log.d("api serial",response.body()?.data?.get("StudentInfo")?.get("student")
                                    ?.get("serial").toString())
                                alertt(
                                    "Warning",
                                    "Please enter the app with your registerred phone",
                                    "close"
                                )

                            }
                        }

                        if (response.body()?.data?.get("StudentInfo")?.get("student")
                                ?.get("password") == Pass
                        ) {
                            passwordVerifyFlag =
                                true              //meaning the password is correct

                            secretPassword =
                                response.body()?.data?.get("StudentInfo")?.get("student")
                                    ?.get("secretPassword")!!

                        } else {
                            passwordVerifyFlag = false
                            alertt(
                                "Warning",
                                "Please enter correct password",
                                "close"
                            )

                        }

                    } else {
                        Alertflag = false
                        //alert(Alertflag)
                        alertt(
                            "Warning",
                            response.body()?.data?.get("StudentInfo")?.get("app")?.get("message")
                                .toString(), "close"
                        )  //if response wasn't succeful.
                    }


                } else {
                    Alertflag = false
                    //alert(Alertflag)
                    alertt(
                        "Warning",
                        "Something went wrong please make sure you have enterred your email and password correctly",
                        "close"
                    )
                    URL = URL3


                    context?.let { it1 -> restart(it1) }
                }



                if (serialUpdateFlag) {

                    URL2 = URL2 + SERIAL_UPDATE

                    Log.d("from serial", URL2)

                    val repository1 = Repository()
                    val viewModelFactory1 = UserViewModelFactory(repository1)
                    viewModel1 =
                        ViewModelProvider(this, viewModelFactory1).get(UserViewModel::class.java)
                    var serial = SerialUpdate(Email, SERIAL)

                    viewModel1.pushSerial(serial)

                    viewModel1.serialUpdate.observe(viewLifecycleOwner, Observer { response1 ->

                        Log.i("hey", response1.code().toString())

                        if (!response1.isSuccessful) {
                            Log.i("From Login", response1.code().toString())
                            Alertflag = false
                            //alert(Alertflag)
                            alertt(
                                "Warning",
                                "Please make sure you are connected to the internet",
                                "close"
                            )
                            passwordVerifyFlag = false
                            serialVerifyFlag = false
                            buildVerify = false
                        } else {
                            serialVerifyFlag = true
                        }


                    })


                }


                Log.i("Overhere", "!!")

                Log.i("serial", serialVerifyFlag.toString())
                Log.i("serial", passwordVerifyFlag.toString())
                Log.i("serial", buildVerify.toString())
                if (serialVerifyFlag == true && passwordVerifyFlag == true && buildVerify == true) {

                    //val action=WelcomeDirections.actionWelcomeToLogin(serial)

                      Log.d("here","to nav")
                      val data=Email+"/"+ secretPassword
                      val action=LoginDirections.actionLoginToNavigation(data)

                    findNavController().navigate(action)

                }else if(serialVerifyFlag==false ){
                    context?.let { it1 -> restart(it1) }
                }


            })
            URL=URL3













        }



    }

//    fun alert(alertFlag:Boolean) {
//        val builder = AlertDialog.Builder(context)
//        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
//        val message = dialogView.findViewById<TextView>(R.id.message)
//        message.text = "Loading.."
//        builder.setView(dialogView)
//        builder.setCancelable(false)
//        val dialog = builder.create()
//        Log.d("MainActivity", "onCreate Loading")
//        if (alertFlag) {
//            dialog.show()
//        } else {
//            dialog.dismiss()
//        }
//
//
//    }


    fun alertt(Title: String, Message: String, Buttonanme: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(Title)
        builder.setMessage(Message)
        builder.setPositiveButton(Buttonanme, { dialogInterface: DialogInterface, i: Int -> })
        Log.d("MainActivity", "onCreate Alert")
        builder.show()
    }


//    fun check(Email: String, Pass: String) {
//
//        if (isEmailValid(Email) && isValidPasswordFormat(Pass)) {
//            navigate()
//
//        } else {
//            alertt("InValid Email or Pass", "Check Your Email or Pass", "OK")
//        }
//    }

    fun isEmailValid(email: String): Boolean {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true
        } else {
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
                    "$"
        )
        if (passwordREGEX.matcher(password).matches()) {
            return true
        } else {
            return false
        }
    }

    fun navigate() {
        findNavController().navigate(R.id.action_login_to_navigation)
    }

    fun triggerRestart(context: Activity) {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
        if (context is Activity) {
            (context as Activity).finish()
        }
        Runtime.getRuntime().exit(0)
    }




    fun restart(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
        Runtime.getRuntime().exit(0)
    }






}