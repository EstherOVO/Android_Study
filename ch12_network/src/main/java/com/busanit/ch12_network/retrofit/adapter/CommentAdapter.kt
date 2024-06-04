package com.busanit.ch12_network.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busanit.ch12_network.databinding.ItemCommentBinding
import com.busanit.ch12_network.retrofit.model.Comment

// 아이템을 리사이클러 뷰 어댑터
class CommentAdapter(val comments: List<Comment>) : RecyclerView.Adapter<CommentAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root) {

//      항목 뷰에 데이터를 바인딩
        fun bind(comments: Comment) {
            binding.nameTextView.text = comments.name
            binding.emailTextView.text = comments.email
            binding.bodyTextView.text = comments.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

//      XML 레이아웃을 인플레이트하여 뷰 홀더 객체의 매개변수로 넣어 뷰 홀더를 생성
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)

        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

//      주어진 위치의 Comment 객체를 뷰 홀더에 바인딩
        holder.bind(comments[position])
    }
}