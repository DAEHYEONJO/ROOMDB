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
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
}