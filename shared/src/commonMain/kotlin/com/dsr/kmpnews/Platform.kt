package com.dsr.kmpnews

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform