package com.busanit.ch11_persistence.a_preference

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit.ch11_persistence.R
import com.busanit.ch11_persistence.databinding.ActivityPreferenceBinding

class PreferenceActivity : AppCompatActivity() {

    lateinit var binding: ActivityPreferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreferenceBinding.inflate(layoutInflater)

        setContentView(binding.root)

//      SharedPreference
//      간단한 키-값 쌍의 데이터를 저장하는 데 사용된다.
//      일반적인 용도 : 사용자의 설정 값, 작은 크기의 데이터, 로그인 상태

//      1. SharedPreference 객체 얻기
        val sharedPreference = getSharedPreferences("my_pref", MODE_PRIVATE)
//      첫 번째 매개변수 : 파일 이름, 두 번째 매개변수 : 파일이 이 앱에서만 사용됨

        binding.run {
//          1-1. 저장하기
            buttonSave.setOnClickListener {
//              editor 객체 사용
                val editor = sharedPreference.edit()

//              데이터 저장
//              첫 번째 매개변수 : Key, 두 번째 매개변수 : Value
                editor.putString("user_name", editTextName.text.toString())
                editor.apply()  // 변경사항을 적용(저장)
            }

//          2. 불러오기
            buttonLoad.setOnClickListener {
//              첫 번째 매개변수 : Key → 키 이름에 해당하는 값을 읽는다., 두 번째 매개변수 : 값이 없을 경우 기본 값
                val userName = sharedPreference.getString("user_name", "이름 없음")
                textView.text = userName    // 텍스트 뷰에 반영
            }

//          3. 삭제하기
            buttonClear.setOnClickListener {
                sharedPreference.edit()
                    .remove("user_name") // 키에 해당하는 데이터 삭제
//                  .clear()       전체 데이터 삭제
                    .apply()    // 변경사항 적용
            }
        }
    }

    fun sharePrefMethod() {

        val sharedPreferences = getSharedPreferences("file_name", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

//      데이터 저장
        editor.putString("string", "기본 값")
        editor.putInt("int", 0)
        editor.putFloat("float", 0.0f)
        editor.putLong("long", 0L)
        editor.putBoolean("bool", false)
        editor.putStringSet("set", setOf("값1", "값2", "값3")) // 한 번에 여러 값 저장
        editor.apply()

//      데이터 불러오기 (첫 번째 매개변수 : Key(리턴 값), 두 번째 매개변수 : 기본 값)
        val string = sharedPreferences.getString("string", "기본 값")
        val int = sharedPreferences.getInt("int", 0)
        val float = sharedPreferences.getFloat("float", 0.0f)
        val long = sharedPreferences.getLong("long", 0L)
        val boolean = sharedPreferences.getBoolean("bool", false)
        val stringSet = sharedPreferences.getStringSet("set", null)
    }
}