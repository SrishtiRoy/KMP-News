package com.petros.efthymiou.dailypulse.di

import com.dsr.kmpnews.articles.di.articlesModule
import com.dsr.kmpnews.di.networkModule
import com.petros.efthymiou.dailypulse.sources.di.sourcesModule

val sharedKoinModules = listOf(
    articlesModule,
    sourcesModule,
    networkModule,
)