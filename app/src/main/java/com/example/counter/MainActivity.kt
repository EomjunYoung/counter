package com.example.counter

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //java 1.8버전을 해줘야 됨
    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.counterText.text = "${viewModel.count}"

        //MutableLiveData를 상속받은 변수가 변할때마다 추적하기 위해 observe(관찰하는 것) 셋팅
        viewModel.countLiveData.observe(this@MainActivity, Observer {
            count -> binding.counterText.text = "$count"
        })

        /** 아래와같이 일일이 viewModel.count를 써서 값이 보여주는것이 아닌
         * 위와같은 LiveData방식을 활용하면 값이 변할때마다 추적하여 값을 자동갱신시켜준다 **/
        binding.addButton.setOnClickListener {
//            count++
//            viewModel.count++
//            binding.counterText.text = "${viewModel.count}"
            viewModel.increaseCount()
        }

        binding.subButton.setOnClickListener {
//            count--
//            viewModel.count--
//            binding.counterText.text = "${viewModel.count}"

            viewModel.decreaseCount()
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

    //화면전환될때 보여주기 위해 저장하는 것
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

//        outState.putInt("count", viewModel.count)
    }

    //onSaveInstanceState에 저장된것을 받는 곳
    /**
     *
     * TODO: Android SDK가 설치된 위치(내 pc: D:\Android\Sdk\platfrom-tools)
     * adb shell로 들어간 뒤 am force-stop 패키지명(com.example.counter) 를 하면
     * 에뮬레이터로 실행중인 앱을 죽일수있음
     *
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

//        viewModel.count = savedInstanceState.getInt("count")
    }
}