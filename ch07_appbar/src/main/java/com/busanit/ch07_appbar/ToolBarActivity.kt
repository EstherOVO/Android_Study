package com.busanit.ch07_appbar

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit.ch07_appbar.databinding.ActivityToolBarBinding

class ToolBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityToolBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.run {
            title = "툴 바"
            setTitleTextColor(Color.WHITE)
            inflateMenu(R.menu.menu1)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.item1 -> {
                        Toast.makeText(this@ToolBarActivity, "항목 1을 눌렀습니다.", Toast.LENGTH_SHORT)
                            .show()
                        false
                    }

                    R.id.item2 -> {
                        Toast.makeText(this@ToolBarActivity, "항목 1을 눌렀습니다.", Toast.LENGTH_SHORT)
                            .show()
                        false
                    }
                    else -> false
                }
            }
        }

    }
}