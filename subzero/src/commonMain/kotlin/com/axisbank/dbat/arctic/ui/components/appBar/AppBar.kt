package com.axisbank.dbat.arctic.ui.components.appBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import com.axisbank.dbat.arctic.ui.theme.AppColors
import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel
import com.axisbank.dbat.arctic.ui.theme.sz_color_action_primary
import com.axisbank.dbat.arctic.ui.theme.sz_color_surface_secondary
import com.axisbank.dbat.arctic.ui.theme.sz_color_surface_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_on_surface
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_primary

// Define your custom dark and light themes with color schemes
private val darkColors = AppColors(
    primary = Color(0xFF000000), // Replace with your dark mode primary color
    primaryVariant = Color(0xFF000000), // Replace with your dark mode primary variant color
    onPrimary = Color(0xFFFFFFFF) // Replace with your dark mode onPrimary color
)

private val lightColors = AppColors(
    primary = Color(0xFF000000), // Replace with your light mode primary color
    primaryVariant = Color(0xFF000000), // Replace with your light mode primary variant color
    onPrimary = Color(0xFFFFFFFF) // Replace with your light mode onPrimary color
)


@Composable
fun AppBar(
    title: String, pressOnBack: () -> Unit, backButtonIcon: ImageVector?, theme: AppbarTheme, isDarkMode1:ThemeViewModel
) {
    var isDarkMode by remember { mutableStateOf(isDarkMode1) }

    val (backGroundColor, textColor, iconColor) = if (isDarkMode1.isDarkMode) {
        Triple(sz_color_surface_tertiary, sz_color_surface_secondary, sz_color_typo_primary)
    } else {
        Triple(sz_color_action_primary, sz_color_typo_on_surface, sz_color_typo_on_surface)
    }
    TopAppBar(title = {
        Text(text = title)
    }, backgroundColor = backGroundColor, contentColor = textColor, actions = {
        IconButton(onClick = {
        }) {
            Icon(imageVector = Icons.Outlined.Refresh, contentDescription = "Lock")
        }
        IconButton(onClick = {
            //isDarkMode1.toggleDarkMode()

        }) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
        }
        IconButton(onClick = {
        }) {
            Icon(imageVector = Icons.Outlined.Menu, contentDescription = "Lock")
        }
    }, navigationIcon = if (backButtonIcon != null) {
        @Composable {
            Image(imageVector = backButtonIcon,
                colorFilter = ColorFilter.tint(iconColor),
                contentDescription = null,
                modifier = Modifier.clickable {
                    pressOnBack()
                })
        }
    } else null)
}
