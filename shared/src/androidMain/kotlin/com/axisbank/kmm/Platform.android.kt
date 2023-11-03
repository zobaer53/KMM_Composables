package com.axisbank.kmm

import android.util.Log

class AndroidPlatform : NavigationManager {
    override fun navigateToDashboard() {
   Log.e("AndroidPlatform", "Login Button Click")
    }
}


actual fun getNavigationManager(): NavigationManager = AndroidPlatform()

actual class Shared actual constructor() {
    private var listener: EventListener? = null

    actual fun registerListener(listener: EventListener) {
        this.listener = listener
    }

    actual fun sendEvent(data: String) {
        listener?.onEventOccurred(data)
    }
}
