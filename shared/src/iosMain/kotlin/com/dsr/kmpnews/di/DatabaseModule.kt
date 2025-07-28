package com.dsr.kmpnews.di

import app.cash.sqldelight.db.SqlDriver
import com.dsr.kmpnews.db.DatabaseDriverFactory
import org.koin.dsl.module
import petros.efthymiou.dailypulse.db.DailyPulseDatabase

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}