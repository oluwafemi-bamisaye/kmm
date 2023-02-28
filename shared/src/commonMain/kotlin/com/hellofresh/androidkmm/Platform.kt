package com.hellofresh.androidkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform