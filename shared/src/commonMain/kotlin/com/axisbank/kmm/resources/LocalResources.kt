package com.axisbank.kmm.resources

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf


private val localStringResources = staticCompositionLocalOf { StringResources() }

object Resources {
    val strings: StringResources
        @Composable
        @ReadOnlyComposable
        get() = localStringResources.current
}