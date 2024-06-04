package com.busanit.ch12_network.retrofit.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.busanit.ch12_network.databinding.ActivityRetroBinding
import com.busanit.ch12_network.retrofit.model.Post
import com.busanit.ch12_network.retrofit.RetrofitClient
import com.busanit.ch12_network.retrofit.adapter.PostAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetroActivity : AppCompatActivity() {

    lateinit var binding: ActivityRetroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRetroBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val api = RetrofitClient.instance
        api.getPosts().enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful()) {
//                  네트워킹에 성공할 경우 데이터를 가져옴(엘비스 연산자로 널 처리)
                    val posts = response.body() ?: emptyList()

//                  리사이클러 뷰 어댑터 매개변수를 통해 데이터 전달 + 어댑터 연결
                    binding.recyclerView.adapter = PostAdapter(posts)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//              실패처리
            }
        })

//      버튼을 클릭하면 글 작성 액티비티로
        binding.buttonCreate.setOnClickListener {

            val intent = Intent(this, NewPostActivity::class.java)

            startActivity(intent)
        }
    }
}