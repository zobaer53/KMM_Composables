package com.axisbank.dbat.arctic.ui.components.button

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.axisbank.dbat.arctic.ui.theme.AppTheme
import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel
import com.axisbank.dbat.arctic.ui.theme.dialog_width
import com.axisbank.dbat.arctic.ui.theme.fieldContainerHeight
import com.axisbank.dbat.arctic.ui.theme.sz_color_action_primary
import com.axisbank.dbat.arctic.ui.theme.sz_color_state_disabled_surface
import com.axisbank.dbat.arctic.ui.theme.sz_color_state_disabled_typo
import com.axisbank.dbat.arctic.ui.theme.sz_color_stroke_default
import com.axisbank.dbat.arctic.ui.theme.sz_color_stroke_disabled
import com.axisbank.dbat.arctic.ui.theme.sz_color_surface_secondary
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_action_secondary
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_on_surface
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_secondary
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_bitterCold
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_blazing
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_mild
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_warm
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_zero


@Composable
fun SubzeroButton(
    onClick: () -> Unit,
    buttonSize: ButtonSize,
    buttonVariant: ButtonVariant,
    text: String,
    enable: Boolean = true,
    buttonIconResource: ImageVector?,
    buttonShape: ButtonShape,
    darkTheme:ThemeViewModel

) {
    val isSystemInDarkTheme = darkTheme.isDarkMode
    val largeRoundedCorner = 27.dp
    //BackGroundColor
    val backgroundColor: ButtonColors = when (buttonVariant) {
        ButtonVariant.PRIMARY -> {
            if (!isSystemInDarkTheme) {
                ButtonDefaults.textButtonColors(backgroundColor = sz_color_action_primary)
            } else {
                ButtonDefaults.textButtonColors(backgroundColor = sz_color_stroke_disabled)
            }
        }

        ButtonVariant.SECONDARY -> {
            if (!isSystemInDarkTheme) {
                ButtonDefaults.textButtonColors(
                    backgroundColor = sz_color_surface_secondary,
                    contentColor = sz_color_stroke_default
                )
            } else {
                ButtonDefaults.textButtonColors(
                    backgroundColor = sz_color_state_disabled_surface,
                    contentColor = sz_color_stroke_default
                )
            }
        }

        ButtonVariant.FLUSHED -> {
            if (!isSystemInDarkTheme) {
                ButtonDefaults.textButtonColors(backgroundColor = sz_color_action_primary)
            } else {
                ButtonDefaults.textButtonColors(backgroundColor = sz_color_stroke_disabled)
            }
        }

        ButtonVariant.TEXT -> ButtonDefaults.textButtonColors(backgroundColor = Color.Transparent)
        ButtonVariant.ICON -> if (!isSystemInDarkTheme) {
            ButtonDefaults.textButtonColors(backgroundColor = sz_color_action_primary)
        } else {
            ButtonDefaults.textButtonColors(backgroundColor = sz_color_stroke_disabled)
        }
    }
    //TextColor
    textColor = when (buttonVariant) {
        ButtonVariant.PRIMARY, ButtonVariant.FLUSHED, ButtonVariant.ICON -> if (enable) sz_color_typo_on_surface else sz_color_typo_on_surface
        ButtonVariant.SECONDARY -> if (enable) sz_color_action_primary else sz_color_typo_secondary
        ButtonVariant.TEXT -> if (enable) sz_color_typo_action_secondary else sz_color_state_disabled_typo
    }
    //IconTint
    val iconTint = when (buttonVariant) {
        ButtonVariant.PRIMARY, ButtonVariant.FLUSHED, ButtonVariant.ICON -> if (enable) sz_color_typo_on_surface else sz_color_typo_on_surface
        ButtonVariant.SECONDARY -> if (enable) sz_color_action_primary else sz_color_typo_secondary
        ButtonVariant.TEXT -> if (enable) sz_color_typo_action_secondary else sz_color_state_disabled_typo
    }
    //IconSize
    val iconSize = when (buttonSize) {
        ButtonSize.SMALL -> {
            smallIcon
        }

        ButtonSize.MEDIUM -> {
            mediumIcon
        }

        ButtonSize.LARGE -> {
            largeIcon
        }
    }

    //Modifier
    baseModifier = when (buttonVariant) {
        ButtonVariant.PRIMARY, ButtonVariant.SECONDARY, ButtonVariant.FLUSHED -> {
            when (buttonSize) {
                ButtonSize.SMALL -> {
                    smallModifier
                }

                ButtonSize.MEDIUM -> {
                    mediumModifier
                }

                ButtonSize.LARGE -> {
                    largeModifier
                }
            }
        }

        ButtonVariant.ICON -> when (buttonSize) {
            ButtonSize.SMALL -> {
                Modifier.size(sz_spacing_warm)
            }

            ButtonSize.MEDIUM -> {
                Modifier.size(sz_spacing_blazing)
            }

            ButtonSize.LARGE -> {
                Modifier.size(fieldContainerHeight)
            }
        }

        ButtonVariant.TEXT -> Modifier.width(dialog_width).height(sz_spacing_blazing).padding(
            start = sz_spacing_bitterCold, end = sz_spacing_bitterCold
        )
    }

    //Shape

    baseShape = when (buttonVariant) {
        ButtonVariant.FLUSHED -> RoundedCornerShape(sz_spacing_zero)
        ButtonVariant.ICON -> when (buttonSize) {
            ButtonSize.SMALL -> {
                if (buttonShape == ButtonShape.ROUNDED) {
                    RoundedCornerShape(sz_spacing_bitterCold)
                } else {
                    RoundedCornerShape(sz_spacing_glacial)
                }
            }

            ButtonSize.MEDIUM -> {
                if (buttonShape == ButtonShape.ROUNDED) {
                    RoundedCornerShape(sz_spacing_mild)
                } else {
                    RoundedCornerShape(sz_spacing_glacial)
                }
            }

            ButtonSize.LARGE -> {
                if (buttonShape == ButtonShape.ROUNDED) {
                    RoundedCornerShape(largeRoundedCorner)
                } else {
                    RoundedCornerShape(sz_spacing_glacial)
                }
            }
        }

        else -> {
            RoundedCornerShape(sz_spacing_glacial)
        }
    }
    //TextSize
    val buttonTextSize = when (buttonSize) {
        ButtonSize.SMALL -> {
            smallFont
        }

        ButtonSize.MEDIUM -> {
            mediumFont
        }

        ButtonSize.LARGE -> {
            largeFont
        }
    }

    AppTheme(false,isSystemInDarkTheme) {
        Button(
            shape = baseShape, modifier = baseModifier, colors = backgroundColor,
            onClick = {
            }, elevation = null
        ) {
            Text(
                text = text,
                color = textColor,
                textAlign = TextAlign.Center,
                fontSize = buttonTextSize,
                style = MaterialTheme.typography.body1,

                )
            if (buttonIconResource != null) {
                Icon(
                    imageVector = buttonIconResource,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = iconSize
                )
            }
        }

    }
}
