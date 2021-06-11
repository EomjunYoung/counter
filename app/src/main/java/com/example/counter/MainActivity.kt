package com.example.counter

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //java 1.8버전을 해줘야 됨
    val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.counterText.text = "${viewModel.count}"

        binding.addButton.setOnClickListener {
//            count++
            viewModel.count++
            binding.counterText.text = "${viewModel.count}"
        }

        binding.subButton.setOnClickListener {
//            count--
            viewModel.count--
            binding.counterText.text = "${viewModel.count}"
        }


        //화면이 가로세로 바뀔때 호출되는 콜백메소드... 실제로 화면전환되면 로그찍힘
        registerActivityLifecycleCallbacks(object: Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {
                Log.d(TAG, "onActivityPaused: ")

            }

            override fun onActivityStarted(activity: Activity) {

                Log.d(TAG, "onActivityStarted: ")
            }

            override fun onActivityDestroyed(activity: Activity) {
                Log.d(TAG, "onActivityDestoryed: ")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                Log.d(TAG, "onActivitySaveInstanceState: ")
            }

            override fun onActivityStopped(activity: Activity) {
                Log.d(TAG, "onActivityStopped: ")
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.d(TAG, "onActivityCreated: ")
            }

            override fun onActivityResumed(activity: Activity) {
                Log.d(TAG, "onActivityResumed: ")
            }

        })

    }
}