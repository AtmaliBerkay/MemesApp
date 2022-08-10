package com.berkayatmali.project1.adapter

import androidx.recyclerview.widget.DiffUtil
import com.berkayatmali.project1.NewsDataModel

class NewsAdapterDiffUtil: DiffUtil.ItemCallback<NewsDataModel>() {
    override fun areItemsTheSame(oldItem: NewsDataModel, newItem: NewsDataModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NewsDataModel, newItem: NewsDataModel): Boolean {
        return oldItem == newItem
    }
}