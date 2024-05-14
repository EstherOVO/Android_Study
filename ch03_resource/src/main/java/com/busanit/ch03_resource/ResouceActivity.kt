package com.busanit.ch03_resource

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResouceActivity : AppCompatActivity() {

    val TAG = "myLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resouce)

//      코드에서 문자열 사용하기
        val string = getString(R.string.welcome_message)
        Log.d(TAG, string)

        val textView = findViewById<TextView>(R.id.textView1)
        textView.text = string
    }
}