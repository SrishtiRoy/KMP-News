package com.dsr.kmpnews.android.di

import app.cash.sqldelight.db.SqlDriver
import com.dsr.kmpnews.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import com.dsr.kmpnews.db.DailyPulseDatabase

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}