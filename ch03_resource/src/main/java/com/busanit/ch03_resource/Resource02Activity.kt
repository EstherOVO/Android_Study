package com.busanit.ch03_resource

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Resource02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resource02)

        val textView = findViewById<TextView>(R.id.textView3)

        textView.typeface = ResourcesCompat.getFont(this, R.font.poetsen)
    }
}