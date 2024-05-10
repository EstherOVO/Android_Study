package com.busanit.ch01_layout.pr01

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit.ch01_layout.R

class Test02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//      화면에 출력될 레이아웃 XML을 매개변수에 명시
        setContentView(R.layout.activity_test02)
    }
}