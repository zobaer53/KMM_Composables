package com.axisbank.kmm


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.axisbank.dbat.arctic.ui.components.appBar.AppBar
import com.axisbank.dbat.arctic.ui.components.appBar.AppbarTheme
import com.axisbank.dbat.arctic.ui.theme.cardElevation
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_zero
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_cool
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_iceAge
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_mild
import com.axisbank.dbat.arctic.ui.theme.AppTheme
import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App(
    loginClick: () -> Unit,
    dropDownClick: () -> Unit,
    tabsClick: () -> Unit,
    isDarkMode1: ThemeViewModel
) {
    var isDarkMode by remember { mutableStateOf(isDarkMode1) }

    AppTheme(false, isDarkMode.isDarkMode) {
        Surface {
            Column(
                Modifier.fillMaxSize()
                    .padding(sz_spacing_zero),
            ) {
                AppBar("Arctic", pressOnBack = {}, null, AppbarTheme.BURGUNDY, isDarkMode)
                Text(
                    text = "Components",
                    fontSize = sz_typo_font_size_mild,
                    modifier = Modifier.padding(
                        sz_spacing_glacial,
                        sz_spacing_glacial,
                        sz_spacing_glacial,
                        sz_spacing_glacial
                    )
                )
                Column(
                    Modifier.fillMaxSize(),
                ) {
                    Card(
                        onClick = { loginClick.invoke() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(sz_spacing_frostbite),
                        shape = RoundedCornerShape(sz_spacing_quickFreeze),
                        elevation = cardElevation
                    ) {

                        Column(
                            Modifier.fillMaxWidth()
                                .padding(start = sz_spacing_frostbite)
                        ) {
                            Text(
                                "Button",
                                Modifier.padding(
                                    sz_spacing_zero,
                                    sz_spacing_glacial,
                                    sz_spacing_glacial,
                                    sz_spacing_quickFreeze
                                ),
                                fontSize = sz_typo_font_size_cool
                            )
                            Text(
                                "The Button enables the user to initiate an action or process",
                                Modifier.padding(
                                    sz_spacing_zero,
                                    sz_spacing_zero,
                                    sz_spacing_frostbite,
                                    sz_spacing_glacial
                                ),
                                fontSize = sz_typo_font_size_iceAge
                            )
                        }
                    }

                    Card(
                        onClick = { dropDownClick.invoke() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(sz_spacing_frostbite),
                        shape = RoundedCornerShape(sz_spacing_quickFreeze),
                        elevation = cardElevation
                    ) {

                        Column(
                            Modifier.fillMaxWidth()
                                .padding(start = sz_spacing_frostbite)
                        ) {
                            Text(
                                "Dropdown",
                                Modifier.padding(
                                    sz_spacing_zero,
                                    sz_spacing_glacial,
                                    sz_spacing_glacial,
                                    sz_spacing_quickFreeze
                                ),
                                fontSize = sz_typo_font_size_cool
                            )
                            Text(
                                "Dropdown allows users to select from a large number of options.",
                                Modifier.padding(
                                    sz_spacing_zero,
                                    sz_spacing_zero,
                                    sz_spacing_frostbite,
                                    sz_spacing_glacial
                                ),
                                fontSize = sz_typo_font_size_iceAge
                            )

                        }
                    }

                    Card(
                        onClick = { tabsClick.invoke() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(sz_spacing_frostbite),
                        shape = RoundedCornerShape(sz_spacing_quickFreeze),
                        elevation = cardElevation
                    ) {

                        Column(
                            Modifier.fillMaxWidth()
                                .padding(start = sz_spacing_frostbite)
                        ) {
                            Text(
                                "Tabs",
                                Modifier.padding(
                                    sz_spacing_zero,
                                    sz_spacing_glacial,
                                    sz_spacing_glacial,
                                    sz_spacing_quickFreeze
                                ),
                                fontSize = sz_typo_font_size_cool
                            )
                            Text(
                                "Used for easy navigation of information at the same level of hierarchy",
                                Modifier.padding(
                                    sz_spacing_zero,
                                    sz_spacing_zero,
                                    sz_spacing_frostbite,
                                    sz_spacing_glacial
                                ),
                                fontSize = sz_typo_font_size_iceAge
                            )

                        }
                    }
                }


            }
        }
    }

}
