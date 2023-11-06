import android.annotation.SuppressLint
import android.hardware.lights.Light
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.axisbank.dbat.arctic.ui.components.appBar.AppBar
import com.axisbank.dbat.arctic.ui.components.appBar.AppbarTheme
import com.axisbank.dbat.arctic.ui.theme.AppTheme
import com.axisbank.dbat.arctic.ui.theme.DarkColors
import com.axisbank.dbat.arctic.ui.theme.LightColors
import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel
import com.axisbank.dbat.arctic.ui.theme.sz_color_action_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_color_neutral_6
import com.axisbank.dbat.arctic.ui.theme.sz_color_stroke_secondary_selected
import com.axisbank.dbat.arctic.ui.theme.sz_color_surface_primary
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_action_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_cool
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_deepFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_cold
import com.axisbank.kmm.TabSampleData
import com.axisbank.kmm.TabSampleScrollableData

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun TabsScreen(tabsClick: () -> Unit, themeViewModel: ThemeViewModel) {

    // Example of how to get FontFamily from Typography
    val typography = getTypography()

    val latoRegular: FontFamily? = typography.body1.fontFamily
    val latoBold: FontFamily? = typography.h1.fontFamily
    val latoSemiBold: FontFamily? = typography.subtitle1.fontFamily

// You can access other text styles in a similar way

    val tabSampleData = TabSampleData()
    val tabScrollableSampleData = TabSampleScrollableData()
    val tabItems = tabSampleData.getSampleItems()
    val tabItemsScrolable = tabScrollableSampleData.getSampleItems()
    var selectedTabIndexEnabled by remember { mutableIntStateOf(0) }
    var selectedTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }
    var selectedScrollableTabIndexEnabled by remember { mutableIntStateOf(0) }
    var containerTabIndexEnabled by remember { mutableIntStateOf(0) }
    var containerTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }
    var scrolledContainerTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }
    var selectedTabIndexDisabled by remember { mutableIntStateOf(0) }
    var containerClicked by remember { mutableStateOf(false) }

    AppTheme(false, themeViewModel.isDarkMode) {
        Scaffold(
            topBar = {
                AppBar(
                    "Tabs",
                    pressOnBack = { tabsClick.invoke() },
                    Icons.Filled.ArrowBack,
                    AppbarTheme.BURGUNDY, themeViewModel
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(sz_spacing_cool)
            ) {
                Column {
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Default Tabs",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    TabRow(
                        selectedTabIndex = selectedTabIndexEnabled,
                        backgroundColor = if (themeViewModel.isDarkMode) {
                            DarkColors.background
                        } else LightColors.background,
                        contentColor = if (themeViewModel.isDarkMode) {
                            DarkColors.primary
                        } else LightColors.primary // Set the content color for selected tab
                    ) {
                        tabItems.forEachIndexed { index, tabTitle ->
                            Tab(
                                selected = selectedTabIndexEnabled == index,
                                onClick = {
                                    selectedTabIndexEnabled = index
                                },
                                enabled = true,
                                modifier = Modifier.padding(horizontal = sz_spacing_glacial),
                                selectedContentColor = LightColors.primary
                            ) {
                                Text(
                                    tabTitle,
                                    color = if (selectedTabIndexEnabled == index) {
                                        LightColors.primary
                                    } else Color.Gray,
                                    fontFamily = latoRegular
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    Text(
                        text = "Default Tabs Disabled",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    TabRow(
                        selectedTabIndex = selectedTabIndexDisabled,
                        backgroundColor = if (themeViewModel.isDarkMode) {
                            DarkColors.background
                        } else LightColors.background,
                        contentColor = Color.Transparent
                    ) {
                        tabItems.forEachIndexed { index, tabTitle ->
                            Tab(
                                enabled = false,
                                selected = false,
                                onClick = {},
                                selectedContentColor = Color.Transparent,
                                modifier = Modifier.padding(horizontal = sz_spacing_glacial)
                            ) {
                                Text(
                                    tabTitle,
                                    color = if (selectedTabIndexDisabled == index) {
                                        LightColors.primary
                                    } else Color.Gray,
                                    fontFamily = latoRegular
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Container Tabs",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    TabRow(
                        selectedTabIndex = containerTabIndexEnabled,
                        backgroundColor = if (themeViewModel.isDarkMode) {
                            DarkColors.background
                        } else LightColors.background,
                        contentColor = Color.Transparent
                    ) {
                        tabItems.forEachIndexed { index, tabTitle ->
                            Tab(
                                selected = containerTabIndexEnabled == index,
                                onClick = {
                                    containerTabIndexEnabled = index
                                    containerClicked != containerClicked
                                },
                                selectedContentColor = Color.Transparent,
                                modifier = Modifier.padding(horizontal = sz_spacing_glacial) then
                                        Modifier.border(
                                            width = 1.dp,
                                            color = Color.Gray,
                                            shape = RectangleShape
                                        ).background(
                                            if (containerTabIndexEnabled == index) {
                                                if (themeViewModel.isDarkMode) {
                                                    sz_color_typo_action_tertiary
                                                } else sz_color_stroke_secondary_selected
                                            } else Color.Transparent
                                        )
                            ) {
                                Text(
                                    tabTitle,
                                    color = if (containerTabIndexEnabled == index) {
                                        if (themeViewModel.isDarkMode) {
                                            Color.White
                                        } else sz_color_typo_action_tertiary
                                    } else Color.Gray,
                                    modifier = Modifier.padding(sz_spacing_quickFreeze),
                                    fontFamily = latoRegular
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Container Tabs Disabled",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    TabRow(
                        selectedTabIndex = selectedTabIndexDisabled,
                        backgroundColor = if (themeViewModel.isDarkMode) {
                            DarkColors.background
                        } else LightColors.background,
                        contentColor = Color.Transparent
                    ) {
                        tabItems.forEachIndexed { index, tabTitle ->
                            Tab(
                                enabled = false,
                                selected = false,
                                onClick = {
                                    /*  containerTabIndexEnabled = index
                                      containerClicked != containerClicked*/
                                },
                                selectedContentColor = Color.Transparent,
                                modifier = Modifier.padding(horizontal = sz_spacing_glacial)
                            ) {
                                Text(
                                    tabTitle,
                                    modifier = Modifier.padding(sz_spacing_quickFreeze),
                                    color = Color.Gray,
                                    fontFamily = latoRegular
                                )
                            }
                        }
                    }


                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Default Tabs With Assets",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    TabRow(
                        selectedTabIndex = selectedTabIndexEnabledWithAssets,
                        backgroundColor = if (themeViewModel.isDarkMode) {
                            DarkColors.background
                        } else LightColors.background,
                        contentColor = if (themeViewModel.isDarkMode) {
                            DarkColors.primary
                        } else LightColors.primary // Set the content color for selected tab
                    ) {
                        tabItems.forEachIndexed { index, tabTitle ->
                            Tab(
                                selected = selectedTabIndexEnabledWithAssets == index,
                                onClick = {
                                    selectedTabIndexEnabledWithAssets = index
                                },
                                enabled = true,
                                modifier = Modifier.padding(horizontal = sz_spacing_glacial),
                                selectedContentColor = LightColors.primary
                            ) {
                                Row {
                                    Text(
                                        tabTitle,
                                        modifier = Modifier.padding(sz_spacing_quickFreeze),
                                        color = if (selectedTabIndexEnabledWithAssets == index) {
                                            LightColors.primary
                                        } else Color.Gray,
                                        fontFamily = latoRegular
                                    )
                                    Spacer(modifier = Modifier.width(sz_spacing_quickFreeze))
                                    Image(
                                        imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                        contentDescription = null, // Set to null if you don't need a content description
                                        modifier = Modifier.padding(sz_spacing_quickFreeze) // Adjust size as needed
                                    )
                                }

                            }
                        }
                    }


                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Container Tabs With Assets",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    TabRow(
                        selectedTabIndex = containerTabIndexEnabledWithAssets,
                        backgroundColor = if (themeViewModel.isDarkMode) {
                            DarkColors.background
                        } else LightColors.background,
                        contentColor = Color.Transparent
                    ) {
                        tabItems.forEachIndexed { index, tabTitle ->
                            Tab(
                                selected = containerTabIndexEnabledWithAssets == index,
                                onClick = {
                                    containerTabIndexEnabledWithAssets = index
                                    containerClicked != containerClicked
                                },
                                selectedContentColor = Color.Transparent,
                                modifier = Modifier.padding(horizontal = sz_spacing_glacial) then
                                        Modifier.border(
                                            width = 1.dp,
                                            color = Color.Gray,
                                            shape = RectangleShape
                                        ).background(
                                            if (containerTabIndexEnabledWithAssets == index) {
                                                sz_color_stroke_secondary_selected
                                            } else Color.Transparent
                                        )
                            ) {
                                Row {
                                    Text(
                                        tabTitle,
                                        color = if (containerTabIndexEnabledWithAssets == index) {
                                            if (themeViewModel.isDarkMode) {
                                                sz_color_typo_action_tertiary
                                            } else Color.White
                                        } else Color.Gray,
                                        modifier = Modifier.padding(sz_spacing_quickFreeze),
                                        fontFamily = latoRegular
                                    )
                                    Spacer(modifier = Modifier.width(sz_spacing_quickFreeze))
                                    Image(
                                        imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                        contentDescription = null, // Set to null if you don't need a content description
                                        modifier = Modifier.padding(sz_spacing_quickFreeze) // Adjust size as needed
                                    )
                                }
                            }
                        }
                    }



                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Container Tabs Disabled With Assets",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    TabRow(
                        selectedTabIndex = selectedTabIndexDisabled,
                        backgroundColor = if (themeViewModel.isDarkMode) {
                            DarkColors.background
                        } else LightColors.background,
                        contentColor = Color.Transparent
                    ) {
                        tabItems.forEachIndexed { index, tabTitle ->
                            Tab(
                                enabled = false,
                                selected = false,
                                onClick = {
                                    /*  containerTabIndexEnabled = index
                                      containerClicked != containerClicked*/
                                },
                                selectedContentColor = Color.Transparent,
                                modifier = Modifier.padding(horizontal = sz_spacing_glacial)
                            ) {
                                Row {
                                    Text(
                                        tabTitle,
                                        modifier = Modifier.padding(sz_spacing_quickFreeze),
                                        color = Color.Gray,
                                        fontFamily = latoRegular
                                    )
                                    Spacer(modifier = Modifier.width(sz_spacing_quickFreeze))
                                    Image(
                                        imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                        contentDescription = null, // Set to null if you don't need a content description
                                        modifier = Modifier.padding(sz_spacing_quickFreeze) // Adjust size as needed
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Default Scrollable Tabs",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    LazyRow(
                        content = {
                            items(tabItemsScrolable.size) { index ->
                                val tabTitle = tabItemsScrolable[index]
                                Tab(
                                    selected = selectedScrollableTabIndexEnabled == index,
                                    onClick = {
                                        selectedScrollableTabIndexEnabled = index
                                    },
                                    enabled = true,
                                    modifier = Modifier.padding(horizontal = sz_spacing_glacial) then Modifier.border(
                                        width = 1.dp, // Border width
                                        shape = RectangleShape, // Shape parameter
                                        brush = if (selectedScrollableTabIndexEnabled == index) SolidColor(
                                            LightColors.primary
                                        ) else SolidColor(Color.Transparent) // Brush parameter
                                    ),
                                    selectedContentColor = if (selectedScrollableTabIndexEnabled == index) LightColors.primary else Color.Transparent
                                ) {
                                    Text(
                                        tabTitle, Modifier
                                            .padding(
                                                start = sz_spacing_cool,
                                                top = sz_spacing_quickFreeze,
                                                end = sz_spacing_cool,
                                                bottom = sz_spacing_quickFreeze
                                            ),
                                        color = Color.Gray,
                                        fontFamily = latoRegular
                                    )
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Default Scrollable Tabs Disabled",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoRegular
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    LazyRow(
                        content = {
                            items(tabItemsScrolable.size) { index ->
                                val tabTitle = tabItemsScrolable[index]
                                Tab(
                                    selected = selectedScrollableTabIndexEnabled == index,
                                    onClick = {
                                        //selectedScrollableTabIndexEnabled = index
                                    },
                                    enabled = false,
                                    modifier = Modifier.padding(horizontal = sz_spacing_glacial) then Modifier.border(
                                        width = 1.dp, // Border width
                                        shape = RectangleShape, // Shape parameter
                                        brush = SolidColor(Color.Transparent) // Brush parameter
                                    ),
                                    selectedContentColor = Color.Gray
                                ) {
                                    Text(
                                        tabTitle,
                                        Modifier.padding(
                                            start = sz_spacing_cool,
                                            top = sz_spacing_quickFreeze,
                                            end = sz_spacing_cool,
                                            bottom = sz_spacing_quickFreeze
                                        ),
                                        color = Color.Gray,
                                        fontFamily = latoRegular
                                    )
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Scrollable Container Tabs With Assets",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    LazyRow(
                        content = {
                            items(tabItemsScrolable.size) { index ->
                                val tabTitle = tabItemsScrolable[index]
                                Tab(
                                    selected = scrolledContainerTabIndexEnabledWithAssets == index,
                                    onClick = {
                                        scrolledContainerTabIndexEnabledWithAssets = index
                                    },
                                    enabled = true,
                                    modifier = Modifier.padding(horizontal = sz_spacing_glacial) then Modifier.border(
                                        width = 1.dp, // Border width
                                        shape = RectangleShape, // Shape parameter
                                        brush = if (scrolledContainerTabIndexEnabledWithAssets == index) SolidColor(
                                            LightColors.primary
                                        ) else SolidColor(Color.Transparent) // Brush parameter
                                    ).background(
                                        if (scrolledContainerTabIndexEnabledWithAssets == index) {
                                            sz_color_stroke_secondary_selected
                                        } else Color.Transparent
                                    ),
                                    selectedContentColor = if (selectedScrollableTabIndexEnabled == index) LightColors.primary else Color.Transparent
                                ) {
                                    Row {
                                        Text(
                                            tabTitle,
                                            Modifier.padding(
                                                start = sz_spacing_cool,
                                                top = sz_spacing_quickFreeze,
                                                end = sz_spacing_quickFreeze,
                                                bottom = sz_spacing_quickFreeze
                                            ),
                                            color = if (scrolledContainerTabIndexEnabledWithAssets == index) {
                                                sz_color_typo_action_tertiary
                                            } else Color.Gray,
                                            fontFamily = latoRegular
                                        )
                                        Image(
                                            imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                            contentDescription = null, // Set to null if you don't need a content description
                                            modifier = Modifier.padding(sz_spacing_quickFreeze) // Adjust size as needed
                                        )
                                    }
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Disabled Scrollable Container Tabs With Assets",
                        fontSize = sz_typo_font_size_cold,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    LazyRow(
                        content = {
                            items(tabItemsScrolable.size) { index ->
                                val tabTitle = tabItemsScrolable[index]
                                Tab(
                                    selected = scrolledContainerTabIndexEnabledWithAssets == index,
                                    onClick = {
                                        //scrolledContainerTabIndexEnabledWithAssets = index
                                    },
                                    enabled = false,
                                    modifier = Modifier.padding(horizontal = sz_spacing_glacial) then Modifier.border(
                                        width = 1.dp, // Border width
                                        shape = RectangleShape, // Shape parameter
                                        brush = SolidColor(Color.Transparent) // Brush parameter
                                    ).background(Color.Transparent),
                                    selectedContentColor = Color.Transparent
                                ) {
                                    Row {
                                        Text(
                                            tabTitle,
                                            Modifier.padding(
                                                start = sz_spacing_cool,
                                                top = sz_spacing_quickFreeze,
                                                end = sz_spacing_quickFreeze,
                                                bottom = sz_spacing_quickFreeze
                                            ),
                                            color = Color.Gray,
                                            fontFamily = latoRegular
                                        )
                                        Image(
                                            imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                            contentDescription = null, // Set to null if you don't need a content description
                                            modifier = Modifier.padding(sz_spacing_quickFreeze) // Adjust size as needed
                                        )
                                    }
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(sz_spacing_glacial))


                }
            }
        }
    }
}

