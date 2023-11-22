import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axisbank.dbat.arctic.ui.components.appBar.AppBar
import com.axisbank.dbat.arctic.ui.components.appBar.AppbarTheme
import com.axisbank.dbat.arctic.ui.theme.AppTheme
import com.axisbank.dbat.arctic.ui.theme.LightColors
import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel
import com.axisbank.dbat.arctic.ui.theme.default_margin
import com.axisbank.dbat.arctic.ui.theme.fab_icon_size_mini
import com.axisbank.dbat.arctic.ui.theme.height_container_tab
import com.axisbank.dbat.arctic.ui.theme.height_standard_tab
import com.axisbank.dbat.arctic.ui.theme.sz_color_neutral_1
import com.axisbank.dbat.arctic.ui.theme.sz_color_stroke_secondary_selected
import com.axisbank.dbat.arctic.ui.theme.sz_color_surface_background
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_action_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_on_surface
import com.axisbank.dbat.arctic.ui.theme.sz_colour_datavis_5_1
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_bitterCold
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_cool
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_mild
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_arctic
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_blizzard
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_cold
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_iceAge
import com.axisbank.dbat.arctic.ui.theme.tabs_min_width
import com.axisbank.kmm.TabSampleData
import com.axisbank.kmm.TabSampleScrollableData
import com.axisbank.kmm.resources.Resources
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun TabsScreen(tabsClick: () -> Unit, themeViewModel: ThemeViewModel) {

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
                    Resources.strings.tabsString,
                    pressOnBack = { tabsClick.invoke() },
                    Icons.Filled.ArrowBack,
                    AppbarTheme.BURGUNDY, themeViewModel
                )
            },
            backgroundColor = sz_color_surface_background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(sz_spacing_cool)
            ) {
                Column {
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.defaultTabsString,
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                        ),
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        )
                    )
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
                                modifier = Modifier
                                    .widthIn(min =tabs_min_width)
                                    .height(height_standard_tab).padding(horizontal = sz_spacing_glacial),
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
                                    style = TextStyle(
                                        fontSize = sz_typo_font_size_frigid,
                                        lineHeight = sz_typo_line_height_iceAge,
                                        fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                        color = if (selectedTabIndexEnabled == index) {
                                            LightColors.primary
                                        } else Color.Gray,
                                        textAlign = TextAlign.Center,
                                        letterSpacing = sz_typo_character_spacing_arctic.sp,
                                    )
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.defaultTabsDisabledString,
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                        ),
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        )
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
                                modifier = Modifier.widthIn(min =tabs_min_width)
                                    .height(height_standard_tab).padding(horizontal = sz_spacing_glacial)
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
                                    style = TextStyle(
                                        fontSize = sz_typo_font_size_frigid,
                                        fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                    )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.containerTabsString,
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                        ),
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        )
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

                    TabRow(
                        selectedTabIndex = containerTabIndexEnabled,
                        backgroundColor = sz_color_surface_background,
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
                                //container dimens from subzero
                                modifier = Modifier
                                    .widthIn(min =tabs_min_width)
                                    .height(height_container_tab)
                                    .padding(end = sz_spacing_glacial)
                                    .border(
                                        width = 1.dp,
                                        color = if (containerTabIndexEnabled == index) {
                                            sz_color_typo_action_tertiary
                                        } else Color.Gray,
                                        shape = RoundedCornerShape(sz_spacing_quickFreeze)
                                    ).background(
                                        if (containerTabIndexEnabled == index) {
                                            sz_color_neutral_1
                                        } else Color.Transparent
                                    )
                            ) {
                                Text(
                                    tabTitle/*, Modifier
                                        .padding(
                                            top = sz_spacing_frostbite,
                                            bottom = sz_spacing_frostbite
                                        )*/,
                                    style = TextStyle(
                                        fontSize = sz_typo_font_size_frigid,
                                        lineHeight = sz_typo_line_height_iceAge,
                                        fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                        color = if (containerTabIndexEnabled == index) {
                                            sz_color_typo_action_tertiary
                                        } else Color.Gray,
                                        textAlign = TextAlign.Center,
                                        letterSpacing = sz_typo_character_spacing_arctic.sp,
                                    )
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.containerTabsDisabledString,
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        ),
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
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
                                //container dimens from subzero
                                modifier = Modifier
                                    .widthIn(min =tabs_min_width)
                                    .height(height_container_tab)
                                    .padding(horizontal = sz_spacing_glacial)
                            ) {
                                Text(
                                    tabTitle, Modifier
                                        .padding(
                                            start = sz_spacing_cool,
                                            top = sz_spacing_frostbite,
                                            end = sz_spacing_cool,
                                            bottom = sz_spacing_frostbite
                                        ),
                                    style = TextStyle(
                                        fontSize = sz_typo_font_size_frigid,
                                        lineHeight = sz_typo_line_height_iceAge,
                                        fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                        color = Color.Gray,
                                        textAlign = TextAlign.Center,
                                        letterSpacing = sz_typo_character_spacing_arctic.sp,
                                    )
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.defaultTabsWithAssetsString,
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        ),
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        )
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
                                modifier = Modifier.widthIn(min =tabs_min_width)
                                    .height(height_standard_tab).padding(end = sz_spacing_glacial) then
                                        Modifier.border(
                                            width = 1.dp,
                                            color = Color.Transparent,
                                            shape = RoundedCornerShape(sz_spacing_quickFreeze)
                                        ),
                                selectedContentColor = LightColors.primary
                            ) {
                                Row(
                                    Modifier.padding(
                                        start = sz_spacing_cool,
                                        top = sz_spacing_frostbite,
                                        bottom = sz_spacing_frostbite,
                                        end = sz_spacing_cool
                                    )
                                ) {
                                    Text(
                                        tabTitle,
                                        style = TextStyle(
                                            fontSize = sz_typo_font_size_frigid,
                                            fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                            color = if (selectedTabIndexEnabledWithAssets == index) {
                                                LightColors.primary
                                            } else Color.Gray,
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(sz_spacing_frostbite))
                                    Box(
                                        Modifier.size(default_margin)
                                            .padding(top = sz_spacing_quickFreeze)
                                    ) {
                                        Image(
                                            painter = painterResource("drawable/image_icon.xml"), // Replace with the desired icon from Icons
                                            contentDescription = null, // Set to null if you don't need a content descriptio
                                            // Adjust size as needed
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.containerTabsWithAssetsString,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        )
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
                                //container dimens from subzero
                                modifier = Modifier
                                    .widthIn(min =tabs_min_width)
                                    .height(height_container_tab)
                                    .padding(end = sz_spacing_frostbite) then
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
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(
                                        sz_spacing_glacial,
                                        Alignment.CenterHorizontally
                                    ),
                                    verticalAlignment = Alignment.Top,
                                ) {
                                    Text(
                                        tabTitle,
                                        style = TextStyle(
                                            fontSize = sz_typo_font_size_frigid,
                                            lineHeight = sz_typo_line_height_iceAge,
                                            fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                            color = if (containerTabIndexEnabledWithAssets == index) {
                                                sz_color_typo_action_tertiary
                                            } else Color.Gray,
                                            textAlign = TextAlign.Center,
                                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                                        )
                                    )

                                    Box(Modifier.size(fab_icon_size_mini).padding(sz_spacing_quickFreeze)) {
                                        Image(
                                            painter = painterResource("drawable/image_icon.xml"), // Replace with the desired icon from Icons
                                            contentDescription = null// Set to null if you don't need a content description
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.containerTabsDisabledWithAssetsString,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

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
                                //container dimens from subzero
                                modifier = Modifier
                                    .widthIn(min = tabs_min_width)
                                    .height(height_container_tab)
                                    .padding(end = sz_spacing_glacial) then
                                        Modifier.border(
                                            width = 1.dp,
                                            color = Color.Transparent,
                                            shape = RoundedCornerShape(sz_spacing_quickFreeze)
                                        )
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(sz_spacing_glacial,
                                        Alignment.CenterHorizontally
                                    ),
                                    verticalAlignment = Alignment.Top,
                                ) {
                                    Text(
                                        tabTitle,
                                        style = TextStyle(
                                            fontSize = sz_typo_font_size_frigid,
                                            lineHeight = sz_typo_line_height_iceAge,
                                            fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                            color = Color.Gray,
                                            textAlign = TextAlign.Center,
                                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                                        )
                                    )
                                    Box(
                                        Modifier.size(fab_icon_size_mini)
                                            .padding( sz_spacing_quickFreeze)
                                    ) {
                                        Image(
                                            painter = painterResource("drawable/image_icon.xml"), // Replace with the desired icon from Icons
                                            contentDescription = null // Set to null if you don't need a content description
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.defaultScrollableTabsString,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        )
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
                                Box(
                                    Modifier
                                        .widthIn(min =tabs_min_width)
                                        .height(height_standard_tab)
                                        .padding(
                                            start = sz_spacing_cool,
                                            top = sz_spacing_frostbite,
                                            end = sz_spacing_cool,
                                            bottom = sz_spacing_frostbite
                                        )
                                ) {
                                    Text(
                                        tabTitle,
                                        style = TextStyle(
                                            fontSize = sz_typo_font_size_frigid,
                                            lineHeight = sz_typo_line_height_iceAge,
                                            fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                            color = if (selectedScrollableTabIndexEnabled == index) {
                                                LightColors.primary
                                            } else Color.Gray,
                                            textAlign = TextAlign.Center,
                                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                                        )
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.defaultScrollableTabsDisabledString,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        )
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
                                    Box(
                                        Modifier.widthIn(min =tabs_min_width)
                                            .height(height_standard_tab)
                                            .padding(
                                                start = sz_spacing_cool,
                                                top = sz_spacing_quickFreeze,
                                                end = sz_spacing_cool,
                                                bottom = sz_spacing_quickFreeze
                                            ),
                                    ) {
                                        Text(
                                            tabTitle,
                                            style = TextStyle(
                                                fontSize = sz_typo_font_size_frigid,
                                                lineHeight = sz_typo_line_height_iceAge,
                                                fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                                color = Color.Gray,
                                                textAlign = TextAlign.Center,
                                                letterSpacing = sz_typo_character_spacing_arctic.sp,
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.scrollableContainerTabsString,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        )
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
                                    modifier = Modifier
                                        .padding(end = sz_spacing_glacial) then
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

                                    //container dimens from subzero
                                    Box(
                                        modifier = Modifier
                                            .widthIn(min = tabs_min_width)
                                            .height(height_container_tab)
                                            .padding(
                                                start = sz_spacing_mild,
                                                top = sz_spacing_frostbite,
                                                bottom = sz_spacing_frostbite,
                                                end = sz_spacing_mild
                                            )
                                    ) {
                                        Text(
                                            tabTitle.uppercase(),
                                            style = TextStyle(
                                                fontSize = sz_typo_font_size_blizzard,
                                                lineHeight = sz_typo_line_height_iceAge,
                                                fontFamily = getStyle()
                                                    .SZ_Typo_Body_Regular_Medium.fontFamily,
                                                color = if (scrolledContainerTabIndexEnabled == index) {
                                                    sz_color_typo_action_tertiary
                                                } else Color.Gray,
                                                textAlign = TextAlign.Center,
                                                letterSpacing = sz_typo_character_spacing_arctic.sp,
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.disabledScrollableContainerString,
                        fontSize = sz_typo_font_size_frigid,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

                    LazyRow(
                        content = {
                            items(tabItemsScrolable.size) { index ->
                                val tabTitle = tabItemsScrolable[index]
                                Tab(
                                    selected = scrolledContainerTabIndexEnabledWithAssets == index,
                                    onClick = {},
                                    enabled = false,
                                    modifier = Modifier
                                        .padding(horizontal = sz_spacing_glacial) then
                                            Modifier.border(
                                                width = 1.dp, // Border width
                                                shape = RectangleShape, // Shape parameter
                                                brush = SolidColor(Color.Transparent) // Brush parameter
                                            ).background(Color.Transparent),
                                    selectedContentColor = Color.Transparent
                                ) {

                                    //container dimens from subzero
                                    Box(
                                        modifier = Modifier
                                            .widthIn(min = tabs_min_width)
                                            .height(height_container_tab)
                                            .padding(
                                                start = sz_spacing_mild,
                                                top = sz_spacing_frostbite,
                                                bottom = sz_spacing_frostbite,
                                                end = sz_spacing_mild
                                            )
                                    ) {
                                        Text(
                                            tabTitle.uppercase(),
                                            style = TextStyle(
                                                fontSize = sz_typo_font_size_blizzard,
                                                lineHeight = sz_typo_line_height_iceAge,
                                                fontFamily = getStyle()
                                                    .SZ_Typo_Body_Regular_Medium.fontFamily,
                                                textAlign = TextAlign.Center,
                                                color = Color.Gray,
                                                letterSpacing = sz_typo_character_spacing_arctic.sp,
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.defaultScrollableTabsWithAssetsString,
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        ),
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),

                        )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

                    ScrollableTabRow(
                        selectedTabIndex = defaultScrolledTabIndexEnabledWithAssets,
                        backgroundColor = sz_color_surface_background,
                        divider = {
                            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                        },
                        contentColor = LightColors.primary,
                        edgePadding = 0.dp// Set the content color for selected tab
                    ) {
                        tabItemsScrolable.forEachIndexed { index, tabTitle ->
                            Tab(
                                selected = defaultScrolledTabIndexEnabledWithAssets == index,
                                onClick = {
                                    defaultScrolledTabIndexEnabledWithAssets = index
                                },
                                enabled = true,
                                selectedContentColor = LightColors.primary
                            ) {
                                Box(
                                    Modifier
                                        .widthIn(min =tabs_min_width)
                                        .height(height_standard_tab).padding(
                                            start = sz_spacing_cool,
                                            top = sz_spacing_frostbite,
                                            bottom = sz_spacing_frostbite,
                                            end = sz_spacing_cool
                                        )
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(
                                            sz_spacing_glacial,
                                            Alignment.CenterHorizontally
                                        ),
                                        verticalAlignment = Alignment.Top,
                                    ) {
                                        Text(
                                            tabTitle,
                                            fontSize = sz_typo_font_size_frigid,
                                            style = TextStyle(
                                                fontSize = sz_typo_font_size_frigid,
                                                lineHeight = sz_typo_line_height_iceAge,
                                                fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                                                textAlign = TextAlign.Center,
                                                color = if (defaultScrolledTabIndexEnabledWithAssets == index) {
                                                    LightColors.primary
                                                } else Color.Gray,
                                                letterSpacing = sz_typo_character_spacing_arctic.sp,
                                            )
                                        )
                                        Box(
                                            Modifier.size(sz_spacing_bitterCold)
                                                .padding(top = sz_spacing_quickFreeze)
                                        ) {
                                            Image(
                                                painter = painterResource("drawable/image_icon.xml"),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.scrollableContainerTabsWithAssetsString,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ), style = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        )
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
                                    modifier = Modifier
                                        .padding(end = sz_spacing_glacial) then
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
                                    //container dimens from subzero
                                    Box(
                                        Modifier
                                            .widthIn(min =tabs_min_width)
                                            .height(height_container_tab)
                                            .padding(
                                                start = sz_spacing_cool,
                                                top = sz_spacing_frostbite,
                                                bottom = sz_spacing_frostbite,
                                                end = sz_spacing_cool
                                            )
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(
                                                sz_spacing_glacial,
                                                Alignment.CenterHorizontally
                                            ),
                                            verticalAlignment = Alignment.Top,
                                        ) {
                                            Text(
                                                tabTitle.uppercase(),
                                                style = TextStyle(
                                                    fontSize = sz_typo_font_size_blizzard,
                                                    fontFamily = getStyle().SZ_Typo_Body_Regular_Small.fontFamily,
                                                    color = if (scrolledContainerTabIndexEnabledWithAssets == index) {
                                                        sz_color_typo_action_tertiary
                                                    } else Color.Gray,
                                                )
                                            )
                                            Box(
                                                Modifier.size(sz_spacing_bitterCold)
                                                    .padding(top = sz_spacing_quickFreeze)
                                            ) {
                                                Image(
                                                    painter = painterResource("drawable/image_icon.xml"), // Replace with the desired icon from Icons
                                                    contentDescription = null, // Set to null if you don't need a content description
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                    Text(
                        text = Resources.strings.disabledScrollableContainerTabsWithAssetsString,
                        modifier = Modifier.padding(
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_glacial,
                            sz_spacing_quickFreeze
                        ),
                        style = TextStyle(
                            fontSize = sz_typo_font_size_frostbite,
                            lineHeight = sz_typo_line_height_iceAge,
                            fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                            textAlign = TextAlign.Center,
                            letterSpacing = sz_typo_character_spacing_arctic.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(sz_spacing_frostbite))

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
                                    modifier = Modifier
                                        .padding(end = sz_spacing_glacial) then
                                            Modifier.border(
                                                width = 1.dp, // Border width
                                                shape = RoundedCornerShape(sz_spacing_quickFreeze),
                                                color = Color.Transparent // Brush parameter
                                            ).background(Color.Transparent),
                                    selectedContentColor = Color.Transparent
                                ) {
                                    //container dimens from subzero
                                    Box(
                                        Modifier
                                            .widthIn(min =tabs_min_width)
                                            .height(height_container_tab).padding(
                                                start = sz_spacing_cool,
                                                top = sz_spacing_frostbite,
                                                bottom = sz_spacing_frostbite,
                                                end = sz_spacing_cool
                                            )
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(
                                                sz_spacing_glacial,
                                                Alignment.CenterHorizontally
                                            ),
                                            verticalAlignment = Alignment.Top,
                                        ) {
                                            Text(
                                                tabTitle.uppercase(),
                                                style = TextStyle(
                                                    fontSize = sz_typo_font_size_blizzard,
                                                    fontFamily = getStyle().SZ_Typo_Body_Regular_Small.fontFamily,
                                                    color = Color.Gray,
                                                )
                                            )
                                            Box(
                                                Modifier.size(sz_spacing_bitterCold)
                                                    .padding(top = sz_spacing_quickFreeze)
                                            ) {
                                                Image(
                                                    painter = painterResource("drawable/image_icon.xml"), // Replace with the desired icon from Icons
                                                    contentDescription = null // Set to null if you don't need a content description
                                                    // Adjust size as needed
                                                )
                                            }
                                        }
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