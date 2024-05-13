package com.busanit.ch01_layout.pr01

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit.ch01_layout.R
import com.busanit.ch01_layout.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      바인딩 객체 획득 → 뷰 바인딩(View Binding)
        val binding = ActivityBindingBinding.inflate(layoutInflater)

//      바인딩 객체로 화면을 출력
        setContentView(binding.root)

        binding.visibleButton.setOnClickListener {
            binding.targetView.visibility = View.VISIBLE
        }

        binding.invisibleButton.setOnClickListener {
            binding.targetView.visibility = View.INVISIBLE
        }

/*
        findViewById를 사용하지 않고 뷰 객체 사용
        val visibleBtn = findViewById<Button>(R.id.visibleButton)
        val targetView = findViewById<TextView>(R.id.targetView)
        val invisibleBtn = findViewById<Button>(R.id.invisibleButton)
*/
    }
}