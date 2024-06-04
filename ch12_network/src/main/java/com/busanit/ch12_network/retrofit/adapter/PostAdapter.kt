package com.busanit.ch12_network.retrofit.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ch12_network.databinding.ItemPostBinding
import com.busanit.ch12_network.retrofit.activity.CommentActivity
import com.busanit.ch12_network.retrofit.model.Post

// 아이템을 리사이클러 뷰 어댑터
class PostAdapter(val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

//      항목 뷰에 데이터를 바인딩
        fun bind(post: Post) {
            binding.titleTextView.text = post.title
            binding.bodyTextView.text = post.body

//          항목을 클릭했을 때 댓글 액티비티를 시작하고, 데이터를 전달
            binding.root.setOnClickListener {

                val context = it.context                                    // 컨텍스트 추출
                val intent = Intent(context, CommentActivity::class.java)   // 인텐트 생성

                intent.putExtra("postId", post.id) // 데이터를 담아서 가져가라

                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

//      XML 레이아웃을 인플레이트하여 뷰 홀더 객체의 매개변수로 넣어 뷰 홀더를 생성
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)

        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

//      주어진 위치의 Post 객체를 뷰 홀더에 바인딩
        holder.bind(posts[position])
    }
}