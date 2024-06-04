package com.busanit.ch12_network.retrofit.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.busanit.ch12_network.databinding.ActivityNewPostBinding
import com.busanit.ch12_network.retrofit.RetrofitClient
import com.busanit.ch12_network.retrofit.model.NewPost
import com.busanit.ch12_network.retrofit.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "mylog"

class NewPostActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewPostBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val api = RetrofitClient.instance

        binding.run {

            buttonSubmit.setOnClickListener {

//              사용자로부터 데이터를 입력받아 데이터 객체 생성
                val title = editTextTitle.text.toString()
                val body = editTextBody.text.toString()

                val newPost = NewPost(userId = 1, title = title, body = body)

                api.createPost(newPost).enqueue(object : Callback<Post> {

                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                        if (response.isSuccessful()) {

                            Toast.makeText(this@NewPostActivity, "글쓰기에 성공했습니다.", Toast.LENGTH_SHORT).show()
                            Log.d(TAG, "onResponse: ${response.body()}")

                            finish()    // 새 글 작성 성공 시, Activity 종료 및 이전으로 돌아감

                        } else {

//                          네트워크는 연결 됐으나, 글쓰기 실패 등의 문제
                            Toast.makeText(this@NewPostActivity, "글쓰기에 실패했습니다. ${response.message()}", Toast.LENGTH_SHORT).show()
                        }
                    }

//                  네트워크 자체의 문제 → 실패 처리하며, 네트워크 요청 자체가 안 돼서 예외(t)를 던짐
                    override fun onFailure(call: Call<Post>, t: Throwable) {

                        Toast.makeText(this@NewPostActivity, "네트워크 연결 실패 ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}