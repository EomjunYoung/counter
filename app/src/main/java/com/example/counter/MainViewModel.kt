package com.example.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//counter(값)를 기존 MainActivit에서 MainViewModel로 옮김..(화면에 보이게하는 값)
//MainActivity는 View의 역할을함 그래서 count를 보여줌
class MainViewModel(private val handle: SavedStateHandle): ViewModel() {

    //이렇게 SavedStateHandle을 사용하면 앱이 강제로 죽어도 count값을 살려서
    //앱을 다시 실행해도 그 값을 불러올 수 있다.
    private var count:Int = handle.get<Int>("count") ?: 0

    //이렇게 set을 설정하면 count가 바뀔때 자동으로 값이 입력받게함으로써
    //리액티브하게 만든다.(이렇게안하면 수동으로 해줘야하는데(주석처리한부분) 놓치면 에러로 이어진다)
//    private var count = 0
        set(value) {
            countLiveData.value = value
            field = value //filed라함은 12번라인의 count에 갱신된 값을 넣겠다는 의미
            handle.set("count", value)
        }

    val countLiveData = MutableLiveData<Int>()
    fun increaseCount() {
        count++
//        countLiveData.value = count
    }
    fun decreaseCount() {
        count--
//        countLiveData.value = count
    }
}