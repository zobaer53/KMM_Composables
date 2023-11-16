import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.axisbank.dbat.arctic.ui.components.appBar.AppBar
import com.axisbank.dbat.arctic.ui.components.appBar.AppbarTheme
import com.axisbank.dbat.arctic.ui.theme.AppTheme
import com.axisbank.dbat.arctic.ui.theme.LightColors
import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel
import com.axisbank.dbat.arctic.ui.theme.sz_color_neutral_1
import com.axisbank.dbat.arctic.ui.theme.sz_color_stroke_secondary_selected
import com.axisbank.dbat.arctic.ui.theme.sz_color_surface_background
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_action_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_on_surface
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_cool
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_mild
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_blizzard
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frostbite
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
    var selectedTabIndexEnabledClicked by remember { mutableStateOf(false) }
    var selectedTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }
    var selectedScrollableTabIndexEnabled by remember { mutableIntStateOf(0) }
    var containerTabIndexEnabled by remember { mutableIntStateOf(0) }
    var containerTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }
    var scrolledContainerTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }
    var scrolledContainerTabIndexEnabled by remember { mutableIntStateOf(0) }
    var defaultScrolledTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }
    var selectedTabIndexDisabled by remember { mutableIntStateOf(0) }
    var containerClicked by remember { mutableStateOf(false) }

    AppTheme(false, themeViewModel.isDarkMode) {
        Scaffold(
            topBar = {
                AppBar(
                    "Tabs",
                    pressOnBack = { tabsClick.invoke() },
                    Icons.Filled.ArrowBack,
                    AppbarTheme.BURGUNDY, themeViewModel) },
            backgroundColor = sz_color_surface_background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(sz_spacing_cool)) {
                Column {
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Default Tabs",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze), fontFamily = latoSemiBold)
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    TabRow(
                        selectedTabIndex = selectedTabIndexEnabled,
                        backgroundColor = sz_color_surface_background,
                        divider = {
                            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                        },
                        contentColor = LightColors.primary,
                    ) {
                        tabItems.forEachIndexed { index, tabTitle ->
                            Tab(
                                selected = selectedTabIndexEnabled == index,
                                onClick = {
                                    selectedTabIndexEnabled = index
                                    selectedTabIndexEnabledClicked != selectedTabIndexEnabledClicked
                                },
                                enabled = true,
                                modifier = Modifier.padding(horizontal = sz_spacing_glacial),
                                selectedContentColor = LightColors.primary
                            ) {

                                Text(
                                    tabTitle, Modifier
                                        .padding(
                                            start = sz_spacing_cool,
                                            top = sz_spacing_frostbite,
                                            end = sz_spacing_cool,
                                            bottom = sz_spacing_frostbite
                                        ),
                                    color = if (selectedTabIndexEnabled == index) {
                                        LightColors.primary
                                    } else Color.Gray,
                                    fontSize = sz_typo_font_size_frigid,
                                    fontFamily = latoRegular
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Default Tabs Disabled",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    TabRow(
                        selectedTabIndex = selectedTabIndexDisabled,
                        backgroundColor = sz_color_surface_background,
                        contentColor = sz_color_surface_background
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
                                    tabTitle, Modifier
                                        .padding(
                                            start = sz_spacing_cool,
                                            top = sz_spacing_frostbite,
                                            end = sz_spacing_cool,
                                            bottom = sz_spacing_frostbite
                                        ),
                                    color = Color.Gray,
                                    fontSize = sz_typo_font_size_frigid,
                                    fontFamily = latoRegular
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Container Tabs",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

                    TabRow(
                        selectedTabIndex = containerTabIndexEnabled,
                        backgroundColor =sz_color_surface_background,
                        divider = {
                            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                        },
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
                                modifier = Modifier.padding(end = sz_spacing_glacial) then
                                        Modifier.border(
                                            width = 1.dp,
                                            color = if (containerTabIndexEnabled == index) {
                                                sz_color_typo_action_tertiary
                                            } else Color.Gray,
                                            shape = RoundedCornerShape(sz_spacing_quickFreeze)
                                        ).background(
                                            if (containerTabIndexEnabled == index) {
                                                sz_color_neutral_1
                                            } else Color.Transparent)
                            ) {
                                Text(
                                    tabTitle, Modifier
                                        .padding(
                                            top = sz_spacing_frostbite,
                                            bottom = sz_spacing_frostbite
                                        ),
                                    color = if (containerTabIndexEnabled == index) {
                                        sz_color_typo_action_tertiary
                                    } else Color.Gray,
                                    fontSize = sz_typo_font_size_frigid,
                                    fontFamily = latoRegular
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Container Tabs Disabled",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

                    TabRow(
                        selectedTabIndex = selectedTabIndexDisabled,
                        backgroundColor = sz_color_surface_background,
                        divider = {
                            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                        },
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
                                    tabTitle, Modifier
                                        .padding(
                                            start = sz_spacing_cool,
                                            top = sz_spacing_frostbite,
                                            end = sz_spacing_cool,
                                            bottom = sz_spacing_frostbite
                                        ),
                                    color = Color.Gray,
                                    fontSize = sz_typo_font_size_frigid,
                                    fontFamily = latoRegular
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Default Tabs With Assets",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

                    TabRow(
                        selectedTabIndex = selectedTabIndexEnabledWithAssets,
                        backgroundColor = sz_color_surface_background,
                        divider = {
                            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                        },
                        contentColor = LightColors.primary
                    ) {
                        tabItems.forEachIndexed { index, tabTitle ->
                            Tab(
                                selected = selectedTabIndexEnabledWithAssets == index,
                                onClick = {
                                    selectedTabIndexEnabledWithAssets = index
                                },
                                enabled = true,
                                modifier = Modifier.padding(end = sz_spacing_glacial) then
                                        Modifier.border(
                                            width = 1.dp,
                                            color = Color.Transparent,
                                            shape = RoundedCornerShape(sz_spacing_quickFreeze)
                                        ),
                                selectedContentColor = LightColors.primary
                            ) {
                                Row {
                                    Text(
                                        tabTitle,
                                        modifier = Modifier
                                            .padding(
                                                start = sz_spacing_cool,
                                                end = sz_spacing_quickFreeze,
                                                top = sz_spacing_frostbite,
                                                bottom = sz_spacing_frostbite
                                            ),
                                        color = if (selectedTabIndexEnabledWithAssets == index) {
                                            LightColors.primary
                                        } else Color.Gray,
                                        fontSize = sz_typo_font_size_frigid,
                                        fontFamily = latoRegular
                                    )
                                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                                    Image(
                                        imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                        contentDescription = null, // Set to null if you don't need a content description
                                        modifier = Modifier
                                            .padding(
                                                top = sz_spacing_frostbite,
                                                bottom = sz_spacing_frostbite, end = sz_spacing_cool
                                            ) // Adjust size as needed
                                    )
                                }

                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Container Tabs With Assets",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

                    TabRow(
                        selectedTabIndex = containerTabIndexEnabledWithAssets,
                        backgroundColor = sz_color_surface_background,
                        divider = {
                            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                        },
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
                                modifier = Modifier.padding(end = sz_spacing_frostbite) then
                                        Modifier.border(
                                            width = 1.dp,
                                            color = if (containerTabIndexEnabledWithAssets == index) {
                                                sz_color_typo_action_tertiary
                                            } else Color.Gray,
                                            shape = RoundedCornerShape(sz_spacing_quickFreeze)
                                        ).background(

                                            if (containerTabIndexEnabledWithAssets == index) {
                                                sz_color_neutral_1
                                            } else Color.Transparent
                                        )
                            ) {
                                Row {
                                    Text(
                                        tabTitle,
                                        color = if (containerTabIndexEnabledWithAssets == index) {
                                            sz_color_typo_action_tertiary
                                        } else Color.Gray,
                                        fontSize = sz_typo_font_size_frostbite,
                                        modifier = Modifier
                                            .padding(
                                                start = sz_spacing_cool,
                                                top = sz_spacing_frostbite,
                                                end = sz_spacing_quickFreeze,
                                                bottom = sz_spacing_frostbite
                                            ),
                                        fontFamily = latoRegular
                                    )
                                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                                    Image(
                                        imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                        contentDescription = null, // Set to null if you don't need a content description
                                        modifier = Modifier
                                            .padding(start = 4.dp,
                                                top = sz_spacing_frostbite,
                                                bottom = sz_spacing_frostbite, end = sz_spacing_cool
                                            )
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Container Tabs Disabled With Assets",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))

                    TabRow(
                        selectedTabIndex = selectedTabIndexDisabled,
                        backgroundColor = sz_color_surface_background,
                        divider = {
                            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                        },
                        contentColor = Color.Transparent,
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
                                modifier = Modifier.padding(end = sz_spacing_frostbite) then
                                        Modifier.border(
                                            width = 1.dp,
                                            color = Color.Transparent,
                                            shape = RoundedCornerShape(sz_spacing_quickFreeze)
                                        )
                            ) {
                                Row {
                                    Text(
                                        tabTitle,
                                        color = Color.Gray,
                                        fontSize = sz_typo_font_size_frostbite,
                                        modifier = Modifier
                                            .padding(
                                                start = sz_spacing_cool,
                                                top = sz_spacing_frostbite,
                                                end = sz_spacing_quickFreeze,
                                                bottom = sz_spacing_frostbite
                                            ),
                                        fontFamily = latoRegular
                                    )
                                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                                    Image(
                                        imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                        contentDescription = null, // Set to null if you don't need a content description
                                        modifier = Modifier
                                            .padding(start = sz_spacing_quickFreeze,
                                                top = sz_spacing_frostbite,
                                                bottom = sz_spacing_frostbite, end = sz_spacing_cool
                                            ) // Adjust size as needed
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Default Scrollable Tabs",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

                    ScrollableTabRow(
                        selectedTabIndex = selectedScrollableTabIndexEnabled,
                        backgroundColor = sz_color_surface_background,
                        divider = {
                            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                        },
                        contentColor = LightColors.primary,
                        edgePadding = 0.dp// Set the content color for selected tab
                    ) {
                        tabItemsScrolable.forEachIndexed { index, tabTitle ->
                            Tab(
                                selected = selectedScrollableTabIndexEnabled == index,
                                onClick = {
                                    selectedScrollableTabIndexEnabled = index
                                },
                                enabled = true,
                                modifier = Modifier.padding(horizontal = sz_spacing_glacial),
                                selectedContentColor = LightColors.primary
                            ) {

                                Text(
                                    tabTitle, Modifier
                                        .padding(
                                            start = sz_spacing_cool,
                                            top = sz_spacing_frostbite,
                                            end = sz_spacing_cool,
                                            bottom = sz_spacing_frostbite
                                        ),
                                    color = if (selectedScrollableTabIndexEnabled == index) {
                                        LightColors.primary
                                    } else Color.Gray,
                                    fontSize = sz_typo_font_size_frigid,
                                    fontFamily = latoRegular
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Default Scrollable Tabs Disabled",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
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
                                        tabTitle, Modifier
                                            .padding(
                                                start = sz_spacing_cool,
                                                top = sz_spacing_quickFreeze,
                                                end = sz_spacing_cool,
                                                bottom = sz_spacing_quickFreeze
                                            ),
                                        color = Color.Gray,
                                        fontSize = sz_typo_font_size_frigid,
                                        fontFamily = latoRegular
                                    )
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Scrollable Container Tabs",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    LazyRow(
                        content = {
                            items(tabItemsScrolable.size) { index ->
                                val tabTitle = tabItemsScrolable[index]
                                Tab(
                                    enabled = true,
                                    selected = scrolledContainerTabIndexEnabled == index,
                                    onClick = {
                                        scrolledContainerTabIndexEnabled = index
                                        containerClicked != containerClicked
                                    },
                                    selectedContentColor = Color.Transparent,
                                    modifier = Modifier.padding(end = sz_spacing_glacial) then
                                            Modifier.border(
                                                width = 1.dp,
                                                color = if (scrolledContainerTabIndexEnabled == index) {
                                                    sz_color_typo_action_tertiary
                                                } else Color.Gray,
                                                shape = RoundedCornerShape(sz_spacing_quickFreeze)
                                            ).background(
                                                if (scrolledContainerTabIndexEnabled == index) {
                                                    sz_color_neutral_1
                                                } else Color.Transparent
                                            )
                                ) {
                                    Row {
                                        Text(
                                            tabTitle.uppercase(),
                                            color = if (scrolledContainerTabIndexEnabled == index) {
                                                sz_color_typo_action_tertiary
                                            } else Color.Gray,
                                            fontSize = sz_typo_font_size_blizzard,
                                            modifier = Modifier
                                                .padding(
                                                    start = sz_spacing_mild,
                                                    top = sz_spacing_frostbite,
                                                    bottom = sz_spacing_frostbite,
                                                    end = sz_spacing_mild
                                                ),
                                            fontFamily = latoRegular
                                        )
                                    }
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Disabled Scrollable Container",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
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
                                            tabTitle.uppercase(),
                                            color = Color.Gray,

                                            fontSize = sz_typo_font_size_blizzard,
                                            modifier = Modifier
                                                .padding(
                                                    start = sz_spacing_mild,
                                                    top = sz_spacing_frostbite,
                                                    bottom = sz_spacing_frostbite,
                                                    end = sz_spacing_mild
                                                ),
                                            fontFamily = latoRegular
                                        )
                                    }
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))



                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Default Scrollable Tabs With Assets",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    ScrollableTabRow(
                        selectedTabIndex = defaultScrolledTabIndexEnabledWithAssets,
                        backgroundColor =sz_color_surface_background,
                        divider = {
                            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                        },
                        contentColor = LightColors.primary,
                        edgePadding = 0.dp// Set the content color for selected tab
                    ) {
                        tabItemsScrolable.forEachIndexed { index, tabTitle ->
                            Tab(
                                    enabled = true,
                                    selected = defaultScrolledTabIndexEnabledWithAssets == index,
                                    onClick = {
                                        defaultScrolledTabIndexEnabledWithAssets = index
                                        containerClicked != containerClicked
                                    },
                                    selectedContentColor = Color.Transparent,
                                    modifier = Modifier.padding(end = sz_spacing_glacial)
                                ) {
                                    Column {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding( sz_spacing_frostbite) then
                                                    Modifier.border(
                                                        width = 1.dp,
                                                        color = Color.Transparent,
                                                        shape = RoundedCornerShape(
                                                            sz_spacing_quickFreeze
                                                        )
                                                    ).background(
                                                        if (defaultScrolledTabIndexEnabledWithAssets == index) {
                                                            sz_color_typo_on_surface
                                                        } else Color.Transparent
                                                    )

                                        ) {
                                            Text(
                                                tabTitle,
                                                color = if (defaultScrolledTabIndexEnabledWithAssets == index) {
                                                    LightColors.primary
                                                } else Color.Gray,
                                                fontSize = sz_typo_font_size_frigid,
                                                modifier = Modifier
                                                    .padding(
                                                        start = sz_spacing_frostbite,
                                                        top = sz_spacing_frostbite,
                                                        bottom = sz_spacing_frostbite
                                                    ),
                                                fontFamily = latoRegular
                                            )
                                            Spacer(modifier = Modifier.width(sz_spacing_quickFreeze))
                                            Image(
                                                imageVector = Icons.Default.AccountBox,
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .padding(start = sz_spacing_quickFreeze,
                                                        top = sz_spacing_frostbite,
                                                        bottom = sz_spacing_frostbite,
                                                        end = sz_spacing_frostbite
                                                    )
                                            )
                                        }
                                    }
                                }
                            }
                        }

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = "Scrollable Container Tabs With Assets",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
                    )

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    LazyRow(
                        content = {
                            items(tabItemsScrolable.size) { index ->
                                val tabTitle = tabItemsScrolable[index]
                                Tab(
                                    enabled = true,
                                    selected = scrolledContainerTabIndexEnabledWithAssets == index,
                                    onClick = {
                                        scrolledContainerTabIndexEnabledWithAssets = index
                                        containerClicked != containerClicked
                                    },
                                    selectedContentColor = Color.Transparent,
                                    modifier = Modifier.padding(end = sz_spacing_glacial) then
                                            Modifier.border(
                                                width = 1.dp,
                                                color = if (scrolledContainerTabIndexEnabledWithAssets == index) {
                                                    sz_color_typo_action_tertiary
                                                } else Color.Gray,
                                                shape = RoundedCornerShape(sz_spacing_quickFreeze)
                                            ).background(
                                                if (scrolledContainerTabIndexEnabledWithAssets == index) {
                                                    sz_color_neutral_1
                                                } else Color.Transparent
                                            )
                                ) {
                                    Row {
                                        Text(
                                            tabTitle,
                                            color = if (scrolledContainerTabIndexEnabledWithAssets == index) {
                                                sz_color_typo_action_tertiary
                                            } else Color.Gray,
                                            fontSize = sz_typo_font_size_frigid,
                                            modifier = Modifier
                                                .padding(
                                                    start = sz_spacing_cool,
                                                    top = sz_spacing_frostbite,
                                                    bottom = sz_spacing_frostbite
                                                ),
                                            fontFamily = latoRegular
                                        )
                                        Spacer(modifier = Modifier.width(sz_spacing_quickFreeze))
                                        Image(
                                            imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                            contentDescription = null, // Set to null if you don't need a content description
                                            modifier = Modifier
                                                .padding(
                                                    top = sz_spacing_frostbite,
                                                    bottom = sz_spacing_frostbite,
                                                    end = sz_spacing_cool
                                                )
                                        )
                                    }
                                }
                            }
                        }
                    )



                    Spacer(modifier = Modifier.height(sz_spacing_glacial))
                    Text(
                        text = "Disabled Scrollable Container Tabs With Assets",
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        fontFamily = latoSemiBold
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
                                            color = Color.Gray,

                                            fontSize = sz_typo_font_size_frigid,
                                            modifier = Modifier
                                                .padding(
                                                    start = sz_spacing_cool,
                                                    top = sz_spacing_frostbite,
                                                    bottom = sz_spacing_frostbite
                                                ),
                                            fontFamily = latoRegular
                                        )
                                        Image(
                                            imageVector = Icons.Default.AccountBox, // Replace with the desired icon from Icons
                                            contentDescription = null, // Set to null if you don't need a content description
                                            modifier = Modifier
                                                .padding(
                                                    top = sz_spacing_frostbite,
                                                    bottom = sz_spacing_frostbite,
                                                    end = sz_spacing_cool
                                                ) // Adjust size as needed
                                        )
                                    }
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                }
            }
        }
    }
}