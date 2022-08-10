package com.berkayatmali.project1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.berkayatmali.project1.NewsDataModel
import com.berkayatmali.project1.databinding.NewsRowBinding

class NewsAdapter: ListAdapter<NewsDataModel, NewsAdapter.ViewHolder>(NewsAdapterDiffUtil()) {
    class ViewHolder(private val binding: NewsRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(addr: NewsDataModel) {
            //binding.rowItem = addr
            binding.tvDescription.text = addr.description
            binding.tvCategory.text = addr.category
            binding.tvLike.text = addr.likeCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsRowBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

}