package com.busanit.ch01_layout.pr01

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit.ch01_layout.R

class Layout01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_layout01)

//      리소스의 id 값으로 뷰 객체를 얻음
        val button1: Button = findViewById<Button>(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4: Button = findViewById<Button>(R.id.button4)

//      버튼 클릭 시 수행되는 이벤트 설정
        button1.setOnClickListener {
            println("버튼 1번 클릭 & 버튼 2번 안 보이게")
            button2.visibility = View.INVISIBLE
        }

        button3.setOnClickListener {
            println("버튼 3번 클릭 & 버튼 2번 보이게")
            button2.visibility = View.VISIBLE
        }
    }
}