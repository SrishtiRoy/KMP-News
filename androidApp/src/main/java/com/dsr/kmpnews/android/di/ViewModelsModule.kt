package com.dsr.kmpnews.android.di

import com.dsr.kmpnews.articles.presentation.ArticlesViewModel
import com.petros.efthymiou.dailypulse.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { ArticlesViewModel(get()) }
    viewModel { SourcesViewModel(get()) }
}