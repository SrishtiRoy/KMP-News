package com.dsr.kmpnews.articles.application

data class Article(
    val title: String,
    val desc: String?,
    val date: String,
    val imageUrl: String
)