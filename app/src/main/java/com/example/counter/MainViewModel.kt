package com.example.counter

import androidx.lifecycle.ViewModel

//counter(값)를 기존 MainActivit에서 MainViewModel로 옮김..(화면에 보이게하는 값)
//MainActivity는 View의 역할을함 그래서 count를 보여줌
class MainViewModel: ViewModel() {

    var count = 0
}