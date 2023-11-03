package com.axisbank.kmm

expect class Shared() {
    fun registerListener(listener: EventListener)
    fun sendEvent(data: String)
}

