@file:JvmName("TabsScreenKt")

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.axisbank.dbat.arctic.ui.components.appBar.AppBar
import com.axisbank.dbat.arctic.ui.components.appBar.AppbarTheme
import com.axisbank.dbat.arctic.ui.theme.AppTheme
import com.axisbank.dbat.arctic.ui.theme.LightColors
import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel
import com.axisbank.dbat.arctic.ui.theme.height_container_tab
import com.axisbank.dbat.arctic.ui.theme.height_standard_tab
import com.axisbank.dbat.arctic.ui.theme.sz_color_surface_background
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_action_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_cool
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_arctic
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_iceAge
import com.axisbank.dbat.arctic.ui.theme.tabs_min_width
import com.axisbank.kmm.TabSampleData
import com.axisbank.kmm.TabSampleScrollableData
import com.axisbank.kmm.resources.Resources
import com.axisbank.kmm.tabsScreen.components.ContainerTabRow
import com.axisbank.kmm.tabsScreen.components.ScrollableContainerTabAssets
import com.axisbank.kmm.tabsScreen.components.ScrollableTabRowComponent
import com.axisbank.kmm.tabsScreen.components.DefaultTabsComponent
import com.axisbank.kmm.tabsScreen.components.DefaultTabsComponentWithAssets

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun TabsScreen(tabsClick: () -> Unit, themeViewModel: ThemeViewModel) {

// You can access other text styles in a similar way
    val tabSampleData = TabSampleData()
    val tabScrollableSampleData = TabSampleScrollableData()
    val tabItems = tabSampleData.getSampleItems()


    /*CONTAINER VARIANT*/
    val CONTAINER_STYLE_INDICATOR_PADDING = sz_spacing_glacial
    val CONTAINER_STYLE_INDICATOR_HEIGHT = height_container_tab
    val CONTAINER_STYLE_INDICATOR_WIDTH = tabs_min_width
    val CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES = sz_color_typo_action_tertiary
    val CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES = Color.Gray
    val containerClicked by remember { mutableStateOf(false) }
    var containerTabIndexEnabled by remember { mutableIntStateOf(0) }
    var containerTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }


    /*COMMON*/
     val DEFAULT_IS_INDICATOR_ANIM_ENABLE = false
    var selectedTabIndexDisabled by remember { mutableIntStateOf(0) }
    var selectedTabIndexEnabled by remember { mutableIntStateOf(0) }
    val selectedTabIndexEnabledClicked by remember { mutableStateOf(false) }
    var selectedTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }


    /*SCROLLABLE*/
    var defaultScrolledTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }
    var scrolledContainerTabIndexEnabledWithAssets by remember { mutableIntStateOf(0) }
    var scrolledContainerTabIndexEnabled by remember { mutableIntStateOf(0) }
    var selectedScrollableTabIndexEnabled by remember { mutableIntStateOf(0) }
    val tabItemsScrolable = tabScrollableSampleData.getSampleItems()



    AppTheme(false, themeViewModel.isDarkMode) {
        Scaffold(
            topBar = {
                AppBar(
                    Resources.strings.tabsString,
                    pressOnBack = { tabsClick.invoke() },
                    Icons.Filled.ArrowBack,
                    AppbarTheme.BURGUNDY,
                    themeViewModel
                )
            },
            backgroundColor = sz_color_surface_background,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())
                    .padding(sz_spacing_cool)
            ) {

                // default tab
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

                DefaultTabsComponent(
                    selectedTabIndex = selectedTabIndexEnabled,
                    tabItems = tabItems,
                    onTabClick = { index ->
                        selectedTabIndexEnabled = index
                        selectedTabIndexEnabledClicked != selectedTabIndexEnabledClicked
                    },
                    height = height_standard_tab,
                    selectedContentColor = LightColors.primary,
                    backgroundColor = sz_color_surface_background,
                    tabMinWidth = tabs_min_width,
                    spacing = sz_spacing_glacial,
                    !DEFAULT_IS_INDICATOR_ANIM_ENABLE,
                    textColor = Color.Gray
                )

                // default tabs disabled
                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                Text(
                    text = Resources.strings.defaultTabsDisabledString, style = TextStyle(
                        fontSize = sz_typo_font_size_frigid,
                        fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                    ), modifier = Modifier.padding(
                        sz_spacing_glacial,
                        sz_spacing_glacial,
                        sz_spacing_glacial,
                        sz_spacing_quickFreeze
                    )
                )
                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                DefaultTabsComponent(
                    selectedTabIndex = selectedTabIndexDisabled,
                    tabItems = tabItems,
                    onTabClick = {},
                    height = height_standard_tab,
                    selectedContentColor = sz_color_surface_background,
                    backgroundColor = sz_color_surface_background,
                    tabMinWidth = tabs_min_width,
                    spacing = sz_spacing_glacial,
                    !DEFAULT_IS_INDICATOR_ANIM_ENABLE,
                    textColor = Color.Gray,

                    )
                //container tabs
                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                Text(
                    text = Resources.strings.containerTabsString, style = TextStyle(
                        fontSize = sz_typo_font_size_frigid,
                        fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                    ), modifier = Modifier.padding(
                        sz_spacing_glacial,
                        sz_spacing_glacial,
                        sz_spacing_glacial,
                        sz_spacing_quickFreeze
                    )
                )
                Spacer(modifier = Modifier.height(sz_spacing_frostbite))

                // Inside your main composable function
                ContainerTabRow(
                    selectedTabIndex = containerTabIndexEnabled,
                    tabItems = tabItems,
                    onTabSelected = {
                        containerTabIndexEnabled = it
                        containerClicked != containerClicked
                    },
                    containerClicked = containerClicked,
                    enabled = true,
                    asset = false,
                    CONTAINER_STYLE_INDICATOR_HEIGHT,
                    CONTAINER_STYLE_INDICATOR_WIDTH,
                    CONTAINER_STYLE_INDICATOR_PADDING,
                    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                )


                // container tabs disabled
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

                // Inside your main composable function
                ContainerTabRow(
                    selectedTabIndex = containerTabIndexEnabled,
                    tabItems = tabItems,
                    onTabSelected = {
                        containerTabIndexEnabled = it
                        containerClicked != containerClicked
                    },
                    containerClicked = containerClicked,
                    enabled = false,
                    asset = false,
                    CONTAINER_STYLE_INDICATOR_HEIGHT,
                    CONTAINER_STYLE_INDICATOR_WIDTH,
                    CONTAINER_STYLE_INDICATOR_PADDING,
                    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                )

                // default tabs with assets
                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                Text(
                    text = Resources.strings.defaultTabsWithAssetsString, style = TextStyle(
                        fontSize = sz_typo_font_size_frigid,
                        lineHeight = sz_typo_line_height_iceAge,
                        fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                        textAlign = TextAlign.Center,
                        letterSpacing = sz_typo_character_spacing_arctic.sp,
                    ), modifier = Modifier.padding(
                        sz_spacing_glacial,
                        sz_spacing_glacial,
                        sz_spacing_glacial,
                        sz_spacing_quickFreeze
                    )
                )
                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                DefaultTabsComponentWithAssets(
                    selectedTabIndex = selectedTabIndexEnabledWithAssets,
                    tabItems = tabItems,
                    onTabClick = { selectedTabIndexEnabledWithAssets = it },
                    backgroundColor = sz_color_surface_background,
                    contentColor = LightColors.primary
                )

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

                ContainerTabRow(
                    selectedTabIndex = containerTabIndexEnabledWithAssets,
                    tabItems = tabItems,
                    onTabSelected = {
                        containerTabIndexEnabledWithAssets = it
                        containerClicked != containerClicked
                    },
                    containerClicked = containerClicked,
                    enabled = true,
                    asset = true,
                    CONTAINER_STYLE_INDICATOR_HEIGHT,
                    CONTAINER_STYLE_INDICATOR_WIDTH,
                    CONTAINER_STYLE_INDICATOR_PADDING,
                    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                )

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

                ContainerTabRow(
                    selectedTabIndex = containerTabIndexEnabledWithAssets,
                    tabItems = tabItems,
                    onTabSelected = {
                        containerTabIndexEnabledWithAssets = it
                        containerClicked != containerClicked
                    },
                    containerClicked = containerClicked,
                    enabled = false,
                    asset = true,
                    CONTAINER_STYLE_INDICATOR_HEIGHT,
                    CONTAINER_STYLE_INDICATOR_WIDTH,
                    CONTAINER_STYLE_INDICATOR_PADDING,
                    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                )

                // Example of using a function to create a ScrollableTabRow

                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                Text(
                    text = Resources.strings.defaultScrollableTabsString,
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
                ScrollableTabRowComponent(
                    selectedTabIndex = selectedScrollableTabIndexEnabled,
                    tabItems = tabItemsScrolable,
                    onTabClick = { index -> selectedScrollableTabIndexEnabled = index },
                    contentColor = LightColors.primary,
                    backgroundColor = sz_color_surface_background,
                    tabMinWidth = tabs_min_width,
                    spacing = sz_spacing_glacial,
                    !DEFAULT_IS_INDICATOR_ANIM_ENABLE,
                    asset = false
                )


                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                Text(
                    text = Resources.strings.defaultScrollableTabsDisabledString,
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
                ScrollableTabRowComponent(
                    selectedTabIndex = selectedTabIndexDisabled,
                    tabItems = tabItemsScrolable,
                    onTabClick = { index -> selectedTabIndexDisabled = index },
                    contentColor = Color.Transparent,
                    backgroundColor = sz_color_surface_background,
                    tabMinWidth = tabs_min_width,
                    spacing = sz_spacing_glacial,
                    DEFAULT_IS_INDICATOR_ANIM_ENABLE,
                    asset = false
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
                LazyRow(content = {
                    items(tabItemsScrolable.size) { index ->
                        val tabTitle = tabItemsScrolable[index]
                        ScrollableContainerTabAssets(
                            index = index,
                            tabTitle = tabTitle,
                            enabled = true,
                            selected = scrolledContainerTabIndexEnabled == index,
                            onTabSelected = { scrolledContainerTabIndexEnabled = index },
                            containerClicked = containerClicked,
                            asset = false,
                            CONTAINER_STYLE_INDICATOR_HEIGHT,
                            CONTAINER_STYLE_INDICATOR_WIDTH,
                            CONTAINER_STYLE_INDICATOR_PADDING
                        )
                    }
                })
                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                Text(
                    text = Resources.strings.disabledScrollableContainerString,
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
                LazyRow(content = {
                    items(tabItemsScrolable.size) { index ->
                        val tabTitle = tabItemsScrolable[index]
                        ScrollableContainerTabAssets(
                            index = index,
                            tabTitle = tabTitle,
                            enabled = false,
                            selected = scrolledContainerTabIndexEnabled == index,
                            onTabSelected = { scrolledContainerTabIndexEnabled = index },
                            containerClicked = containerClicked,
                            asset = false,
                            CONTAINER_STYLE_INDICATOR_HEIGHT,
                            CONTAINER_STYLE_INDICATOR_WIDTH,
                            CONTAINER_STYLE_INDICATOR_PADDING
                        )
                    }
                })

                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                Text(
                    text = Resources.strings.defaultScrollableTabsWithAssetsString,
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
                ScrollableTabRowComponent(
                    selectedTabIndex = defaultScrolledTabIndexEnabledWithAssets,
                    tabItems = tabItemsScrolable,
                    onTabClick = { index -> defaultScrolledTabIndexEnabledWithAssets = index },
                    contentColor = LightColors.primary,
                    backgroundColor = sz_color_surface_background,
                    tabMinWidth = tabs_min_width,
                    spacing = sz_spacing_glacial,
                    !DEFAULT_IS_INDICATOR_ANIM_ENABLE,
                    asset = true
                )


                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                Text(
                    text = Resources.strings.scrollableContainerTabsWithAssetsString,
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
                LazyRow(content = {
                    items(tabItemsScrolable.size) { index ->
                        val tabTitle = tabItemsScrolable[index]
                        ScrollableContainerTabAssets(
                            index = index,
                            tabTitle = tabTitle,
                            enabled = true,
                            selected = scrolledContainerTabIndexEnabledWithAssets == index,
                            onTabSelected = { scrolledContainerTabIndexEnabledWithAssets = index },
                            containerClicked = containerClicked,
                            asset = true,
                            CONTAINER_STYLE_INDICATOR_HEIGHT,
                            CONTAINER_STYLE_INDICATOR_WIDTH,
                            CONTAINER_STYLE_INDICATOR_PADDING
                        )
                    }
                })


                Spacer(modifier = Modifier.height(sz_spacing_frostbite))
                Text(
                    text = Resources.strings.defaultScrollableTabsWithAssetsString,
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
                LazyRow(content = {
                    items(tabItemsScrolable.size) { index ->
                        val tabTitle = tabItemsScrolable[index]
                        ScrollableContainerTabAssets(
                            index = index,
                            tabTitle = tabTitle,
                            enabled = false,
                            selected = defaultScrolledTabIndexEnabledWithAssets == index,
                            onTabSelected = { defaultScrolledTabIndexEnabledWithAssets = index },
                            containerClicked = containerClicked,
                            asset = true,
                            CONTAINER_STYLE_INDICATOR_HEIGHT,
                            CONTAINER_STYLE_INDICATOR_WIDTH,
                            CONTAINER_STYLE_INDICATOR_PADDING
                        )
                    }
                })
            }
        }
    }
}










