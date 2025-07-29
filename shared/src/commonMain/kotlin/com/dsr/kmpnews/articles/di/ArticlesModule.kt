package com.dsr.kmpnews.articles.di


import com.dsr.kmpnews.articles.application.ArticlesUseCase
import com.dsr.kmpnews.articles.presentation.ArticlesViewModel
import com.dsr.kmpnews.data.ArticlesDataSource
import com.dsr.kmpnews.data.ArticlesRepository
import com.dsr.kmpnews.data.ArticlesService
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}