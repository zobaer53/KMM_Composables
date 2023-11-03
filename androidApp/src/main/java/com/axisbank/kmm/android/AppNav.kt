package com.axisbank.kmm.android

sealed class AppNav(val route: String) {
    object Login : AppNav("login")
    object Dashboard : AppNav("dashboard")
}