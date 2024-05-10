package com.busanit.ch01_layout.pr01

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit.ch01_layout.R

class Test01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test01)

//      이름 문자열을 출력하는 TextView 생성
        val name = TextView(this).apply {
            typeface = Typeface.DEFAULT_BOLD
            text = "Lake Louis"
        }

//      이미지를 출력하는 ImageView 생성
        val image = ImageView(this).also {
            it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.lake_1))
        }

//      TextView 생성
        val address = TextView(this).apply {
            typeface = Typeface.DEFAULT_BOLD
            text = "Canada"
        }

//      레이아웃 객체 생성
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL    // 방향(세로로 갈 건지, 가로로 갈 건지)
            gravity = Gravity.CENTER    // 가운데로 정렬

//          레이아웃에 View 객체 추가
            addView(name, WRAP_CONTENT, WRAP_CONTENT)   // 객체, 너비, 높이
            addView(image, WRAP_CONTENT, WRAP_CONTENT)
            addView(address, WRAP_CONTENT, WRAP_CONTENT)
//          WRAP_CONTENT : 내용물의 크기만큼 객체가 크기를 감싼다.
        }

//      LinearLayout 객체를 화면에 출력
        setContentView(layout)
    }
}