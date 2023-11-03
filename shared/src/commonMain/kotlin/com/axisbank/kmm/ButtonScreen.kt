package com.axisbank.kmm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.axisbank.dbat.arctic.ui.components.appBar.AppBar
import com.axisbank.dbat.arctic.ui.components.appBar.AppbarTheme
import com.axisbank.dbat.arctic.ui.components.button.ButtonShape
import com.axisbank.dbat.arctic.ui.components.button.ButtonSize
import com.axisbank.dbat.arctic.ui.components.button.ButtonVariant
import com.axisbank.dbat.arctic.ui.components.button.SubzeroButton
import com.axisbank.dbat.arctic.ui.theme.AppTheme
import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_zero
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_mild

@Composable
fun ButtonScreen(logoutClick: () -> Unit, isDarkMode1: ThemeViewModel) {
    val scrollState = rememberScrollState()
    var isDarkMode by remember { mutableStateOf(isDarkMode1) }

    AppTheme(false,isDarkMode.isDarkMode) {
        Surface{
        Column(
            Modifier.fillMaxSize().padding(sz_spacing_zero)
                .verticalScroll(state = scrollState),
        ) {

            AppBar(
                "Button",
                pressOnBack = { logoutClick.invoke() },
                Icons.Filled.ArrowBack,
                AppbarTheme.BURGUNDY, isDarkMode
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Primary Button medium",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.PRIMARY,
                    "primary Button",
                    true, null,
                    ButtonShape.SQUARED
                    ,
                    darkTheme = isDarkMode1
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.PRIMARY,
                    "Primary Button",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.ICON,
                    "",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.PRIMARY,
                    "Primary Button",
                    false,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }

            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Primary button Large",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.PRIMARY,
                    "primary Button",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.PRIMARY,
                    "Primary Button",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.ICON,
                    "",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Primary button small",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.SMALL,
                    ButtonVariant.PRIMARY,
                    "primary Button",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.SMALL,
                    ButtonVariant.PRIMARY,
                    "Primary Button",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.SMALL,
                    ButtonVariant.ICON,
                    "",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }

            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Secondary Button medium",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.SECONDARY,
                    "Secondary Button",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.SECONDARY,
                    "Secondary Button",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.SECONDARY,
                    "",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.SECONDARY,
                    "Secondary Button",
                    false,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Secondary button large",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.SECONDARY,
                    "Secondary Button",
                    true,
                    null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.SECONDARY,
                    "Secondary Button",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.SECONDARY,
                    "",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Flushed Button medium",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.FLUSHED,
                    "Flushed Button",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )

            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.FLUSHED,
                    "Flushed Button",
                    false,
                    null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Flushed Button large",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.FLUSHED,
                    "Flushed Button",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )

            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Flushed Button small",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.SMALL,
                    ButtonVariant.FLUSHED,
                    "Flushed Button",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )

            }

            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Text Button",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.TEXT,
                    "Text Button",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.TEXT,
                    "Text Button",
                    true,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )

            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.TEXT,
                    "Text Button",
                    false,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Icon Button medium",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.ICON,
                    "",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )

            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.ICON,
                    "",
                    false,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.ICON,
                    "",
                    true, null,
                    ButtonShape.ROUNDED,
                    isDarkMode
                )

            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.MEDIUM,
                    ButtonVariant.ICON,
                    "",
                    false,
                    Icons.Default.Add,
                    ButtonShape.ROUNDED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Icon Button large",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.ICON,
                    "",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )

            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.ICON,
                    "",
                    false,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.ICON,
                    "",
                    true, null,
                    ButtonShape.ROUNDED,
                    isDarkMode
                )

            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.LARGE,
                    ButtonVariant.ICON,
                    "",
                    false,
                    Icons.Default.Add,
                    ButtonShape.ROUNDED,
                    isDarkMode
                )
            }

            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Icon Button small",
                fontSize = sz_typo_font_size_mild,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.SMALL,
                    ButtonVariant.ICON,
                    "",
                    true, null,
                    ButtonShape.SQUARED,
                    isDarkMode
                )

            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.SMALL,
                    ButtonVariant.ICON,
                    "",
                    false,
                    Icons.Default.Add,
                    ButtonShape.SQUARED,
                    isDarkMode
                )
            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "Enabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SubzeroButton(
                    onClick = { },
                    ButtonSize.SMALL,
                    ButtonVariant.ICON,
                    "",
                    true, null,
                    ButtonShape.ROUNDED,
                    isDarkMode
                )

            }
            Spacer(modifier = Modifier.height(sz_spacing_glacial))
            Text(
                text = "disabled",
                fontSize = sz_typo_font_size_frigid,
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Column(
                Modifier.fillMaxSize().padding(sz_spacing_glacial),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(sz_spacing_glacial))
                SubzeroButton(
                    onClick = { },
                    ButtonSize.SMALL,
                    ButtonVariant.ICON,
                    "",
                    false,
                    Icons.Default.Add,
                    ButtonShape.ROUNDED,
                    isDarkMode
                )
            }

        }
    }
    }
}