package com.axisbank.kmm


class Navigation: NavigationManager {
    override fun navigateToDashboard() {
        TODO("Not yet implemented")

    }
}
actual fun getNavigationManager(): NavigationManager = Navigation()
actual class Shared actual constructor() {
    private var listener: EventListener? = null

    actual fun registerListener(listener: EventListener) {
        this.listener = listener
    }

    actual fun sendEvent(data: String) {
        listener?.onEventOccurred(data)
    }
}
