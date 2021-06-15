package com.example.counter

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.counter.databinding.ActivityMain2Binding
import com.example.counter.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    //java 1.8버전을 해줘야 됨
    private val viewModel by viewModels<MainViewModel2>()

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.countLiveData.observe(this@MainActivity2, Observer {
            count -> binding.counterText.text = "$count"
        })

        binding.addButton.setOnClickListener {
            viewModel.increaseCount()
        }

        binding.subButton.setOnClickListener {
            viewModel.decreaseCount()
        }

    }
}