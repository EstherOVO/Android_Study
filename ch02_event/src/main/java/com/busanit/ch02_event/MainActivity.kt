package com.busanit.ch02_event

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val TAG = "myLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

//  터치 이벤트
//  ACTION_DOWN(터치를 누른 순간), ACTION_UP(터치를 뗀 순간), ACTION_MOVE(터치를 누르고 이동하는 순간)
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("myLog", "${event.x}, ${event.y} 터치 다운 이벤트가 발생했습니다.")
            }

            MotionEvent.ACTION_UP -> {
                Log.d("myLog", "터치 업 이벤트가 발생했습니다.")
            }

            MotionEvent.ACTION_MOVE -> {
                Log.d("myLog", "터치 이동 이벤트가 발생했습니다.")
            }
        }
        return super.onTouchEvent(event)
    }

//  키를 누르는 순간 이벤트
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode) {
            KeyEvent.KEYCODE_0 -> Log.d(TAG, "0 키가 눌렸습니다.")
            KeyEvent.KEYCODE_A -> Log.d(TAG, "A 키가 눌렸습니다.")
            KeyEvent.KEYCODE_BACK -> Log.d(TAG, "뒤로 가기 키가 눌렸습니다.")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d(TAG, "볼륨 업 키가 눌렸습니다.")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d(TAG, "볼륨 다운 키가 눌렸습니다.")
        }
        return super.onKeyDown(keyCode, event)
    }

//  키를 떼는 순간 이벤트
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyUp(keyCode, event)
    }

//  키를 길게 누르는 순간 이벤트
    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d(TAG, "볼륨 업 버튼을 길게 눌렀습니다.")
        }
        return super.onKeyLongPress(keyCode, event)
    }
}