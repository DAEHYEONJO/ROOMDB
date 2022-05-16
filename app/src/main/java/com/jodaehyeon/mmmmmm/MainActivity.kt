package com.jodaehyeon.mmmmmm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jodaehyeon.mmmmmm.data.User
import com.jodaehyeon.mmmmmm.databinding.ActivityMainBinding
import com.jodaehyeon.mmmmmm.viewmodel.UserViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return UserViewModel(GlobalApplication.userRepository) as T
                //ADFAFSDF
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("lifecycletest", "MainActivity onCreate: ")

        binding.run {
            btn1.setOnClickListener {
                viewModel.insert(User(Random(3000).toString(), "wefwef"))
            }
            delete.setOnClickListener {
                viewModel.deleteAll()
            }
        }

        viewModel.allUser.observe(this@MainActivity) { user ->
            Log.d("dsfdsaf", "onCreate: $user")
            binding.txt1.text = user.toString()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycletest", "MainActivity onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycletest", "MainActivity onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycletest", "MainActivity onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycletest", "MainActivity onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycletest", "MainActivity onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifecycletest", "MainActivity onRestart: ")
    }
}