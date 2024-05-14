package com.busanit.ch03_resource

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class Resource01Activity : AppCompatActivity() {

    val TAG = "myLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resource01)

//      코드에서 문자열 사용하기
        val string = getString(R.string.welcome_message)
        Log.d(TAG, string)

//      텍스트 뷰에 리소스 문자열 적용
        val textView = findViewById<TextView>(R.id.textView1)
        textView.text = string

        textView.textSize = resources.getDimension(R.dimen.text_size)
        textView.setTextColor(ResourcesCompat.getColor(resources, R.color.primary_color, null))
    }
}