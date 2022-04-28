package com.jodaehyeon.mmmmmm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jodaehyeon.mmmmmm.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("info","abcd")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}