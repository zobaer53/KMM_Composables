package com.axisbank.dbat.arctic.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    primary: Color,
    primaryVariant: Color,
    onPrimary: Color,
) {
    private var primary by mutableStateOf(primary)
    private var primaryVariant by mutableStateOf(primaryVariant)
    private var onPrimary by mutableStateOf(onPrimary)


    fun copy(
        primary: Color = this.primary,
        primaryVariant: Color = this.primaryVariant,
        onPrimary: Color = this.onPrimary,
    ): AppColors = AppColors(
        primary, primaryVariant, onPrimary
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        primaryVariant = other.primaryVariant
        onPrimary = other.onPrimary

    }
}


fun primaryBrandColor(
    colorPrimary: Color = sz_color_action_primary,
    colorPrimaryVariant: Color = sz_color_action_primary,
    colorOnPrimary: Color = sz_color_surface_primary
): AppColors = AppColors(
    colorPrimary, colorPrimaryVariant, colorOnPrimary

)

fun secondaryBrandColor(
    colorSecondary: Color = sz_color_action_secondary,
    colorSecondaryVariant: Color = sz_color_action_secondary,
    colorOnSecondary: Color = sz_color_typo_primary,

    ): AppColors = AppColors(
    colorSecondary,
    colorSecondaryVariant,
    colorOnSecondary,

    )

var LocalColors = staticCompositionLocalOf { primaryBrandColor() }