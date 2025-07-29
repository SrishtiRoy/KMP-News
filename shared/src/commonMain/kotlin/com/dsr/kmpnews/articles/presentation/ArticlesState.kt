package com.dsr.kmpnews.articles.presentation

import com.dsr.kmpnews.articles.application.Article


data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
