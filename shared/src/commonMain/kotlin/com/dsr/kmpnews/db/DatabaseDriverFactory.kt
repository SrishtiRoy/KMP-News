package com.dsr.kmpnews.db

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {

    fun createDriver(): SqlDriver
}