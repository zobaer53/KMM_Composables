package com.axisbank.kmm

interface NavigationManager {
    fun navigateToDashboard()
}
expect fun getNavigationManager(): NavigationManager