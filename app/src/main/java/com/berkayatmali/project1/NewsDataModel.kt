package com.berkayatmali.project1

import android.view.MenuInflater

data class NewsDataModel(
    val uid: Int,
    val title: String,
    val image: String,
    val description: String,
    val likeCount: Int,
    val category: String
)
