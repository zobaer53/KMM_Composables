package com.axisbank.kmm

import TabsScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.chrynan.navigation.ExperimentalNavigationApi
import com.chrynan.navigation.compose.NavigationContainer
import com.chrynan.navigation.compose.rememberNavigator
import com.chrynan.navigation.popDestination
import com.chrynan.navigation.push


import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel

val LocalThemeViewModel = ThemeViewModel()
@OptIn(ExperimentalNavigationApi::class)
@Composable
fun NavigationMain() {
    val navigator = rememberNavigator(AppDestination.MAIN_SCREEN)
        var isDarkMode by remember { mutableStateOf(LocalThemeViewModel) }
    MaterialTheme {
        NavigationContainer(
            navigator = navigator,
            modifier = Modifier.fillMaxSize()
        ) { (destination, _) ->
            when (destination) {
                AppDestination.MAIN_SCREEN -> App(
                    loginClick = { navigator.push(AppDestination.BUTTON_SCREEN) },
                    dropDownClick = { navigator.push(AppDestination.DROPDOWN_SCREEN) },
                    tabsClick = { navigator.push(AppDestination.TABS_SCREEN) },
                    isDarkMode
                )

                AppDestination.BUTTON_SCREEN -> ButtonScreen(
                    logoutClick = { navigator.popDestination() },isDarkMode
                )
                AppDestination.DROPDOWN_SCREEN -> DropdownScreen(
                    dropDownClick = { navigator.popDestination() },isDarkMode
                )
                AppDestination.TABS_SCREEN -> TabsScreen(
                    tabsClick = { navigator.popDestination() },isDarkMode
                )
            }

        }
    }
}


enum class AppDestination {
    MAIN_SCREEN,
    BUTTON_SCREEN,
    TABS_SCREEN,
    DROPDOWN_SCREEN
}