package com.busanit.ch05_dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit.ch05_dialog.databinding.ActivityToastBinding
import com.busanit.ch05_dialog.databinding.CustomSnackbarBinding
import com.google.android.material.snackbar.Snackbar

class ToastActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    @RequiresApi(30)    // 하위 호환성 애너테이션의 경우 오류를 무시하기만 한다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityToastBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.button1.setOnClickListener {
//          토스트 메시지 띄우기
//          context, 메시지, 출력되는 시간
//          Toast.LENGTH_SHORT : 약 3초
//          Toast.LENGTH_LONG : 약 5초
            val toast1 = Toast.makeText(this, "일반 토스트 메시지입니다.", Toast.LENGTH_SHORT)
            toast1.show()
        }

        binding.button2.setOnClickListener {
//          API 하위 호환성 고려하기
//          1. 애너테이션(Annotation) 지정 → 2. if 문 통해서 실행
//          안드로이드 11 버전부터 토스트 콜백 기능 추가
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val toast2 = Toast.makeText(this, "조금 긴 토스트 메시지입니다.", Toast.LENGTH_LONG)
                toast2.addCallback(object : Toast.Callback() {
//                  토스트 객체가 나타나고 사라질 때 콜백 이벤트 추가
                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("myLog", "토스트가 등장 때 작동하는 콜백")
                    }

                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("myLog", "토스트가 사라질 때 작동하는 콜백")
                    }
                })
                toast2.show()
            }
        }

        binding.button3.setOnClickListener {
            Snackbar.make(it, "스낵바 메시지입니다.", Snackbar.LENGTH_SHORT).show()
        }

        binding.button4.setOnClickListener {
            val snackBar = Snackbar.make(it, "스낵바 액션 메시지입니다.", Snackbar.LENGTH_LONG)

            snackBar.setTextColor(Color.YELLOW)     // 글자색
            snackBar.setBackgroundTint(Color.RED)   // 배경색
            snackBar.animationMode = Snackbar.ANIMATION_MODE_SLIDE      // 애니메이션
//          Action 설정
            snackBar.setAction("OK") {
                binding.textView.text = "스낵바 'OK'를 눌렀습니다."
            }

            snackBar.show()
        }

        binding.button5.setOnClickListener {
            val snackbar = Snackbar.make(it, "", Snackbar.LENGTH_LONG)

//          커스텀 스낵바 레이아웃 설정하기
            val snackbarBinding = CustomSnackbarBinding.inflate(layoutInflater)

            val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout
            snackbarLayout.addView(snackbarBinding.root)

            snackbarBinding.actionBtn1.setOnClickListener {
                binding.textView.text = "액션1 클릭"
            }
            snackbarBinding.actionBtn2.setOnClickListener {
                binding.textView.text = "액션2 클릭"
            }

            snackbar.show()
        }
    }
}