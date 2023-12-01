package com.axisbank.kmm.tabsScreen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite


@Composable
fun TabsComponent(
    selectedTabIndex: Int,
    tabTitle: String,
    tabItems: List<String>,
    onTabClick: (Int) -> Unit,
    tabType: TabType,
    containerClicked: Boolean,
    selected: Boolean?,
    TABS_ASSET: Boolean,
    DEFAULT_IS_INDICATOR_ANIM_ENABLE: Boolean,
    CONTAINER_STYLE_INDICATOR_HEIGHT: Dp,
    CONTAINER_STYLE_INDICATOR_WIDTH: Dp,
    CONTAINER_STYLE_INDICATOR_PADDING: Dp,
    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES: Color,
    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES: Color,
    COMMON_TABS_STYLE_BACKGROUND_COLOR_RES: Color,

    ) {
    when (tabType) {
        TabType.Container -> ContainerTabRow(
            selectedTabIndex,
            tabItems,
            onTabClick,
            containerClicked,
            DEFAULT_IS_INDICATOR_ANIM_ENABLE,
            TABS_ASSET,
            CONTAINER_STYLE_INDICATOR_HEIGHT,
            CONTAINER_STYLE_INDICATOR_WIDTH,
            CONTAINER_STYLE_INDICATOR_PADDING,
            CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
            CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
        )
        TabType.Default -> DefaultTabsComponent(
            selectedTabIndex,
            tabItems,
            onTabClick,
            CONTAINER_STYLE_INDICATOR_HEIGHT,
            CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES,
            COMMON_TABS_STYLE_BACKGROUND_COLOR_RES,
            CONTAINER_STYLE_INDICATOR_WIDTH,
            CONTAINER_STYLE_INDICATOR_PADDING,
            DEFAULT_IS_INDICATOR_ANIM_ENABLE,
            CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES
        )
        TabType.DefaultWithAsset -> DefaultTabsComponentWithAssets(
            selectedTabIndex,
            tabItems,
            onTabClick,
            COMMON_TABS_STYLE_BACKGROUND_COLOR_RES,
            CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES,
        )
        TabType.Scrollable -> ScrollableTabRowComponent(
            selectedTabIndex,
            tabItems,
            onTabClick,
            CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES,
            COMMON_TABS_STYLE_BACKGROUND_COLOR_RES,
            CONTAINER_STYLE_INDICATOR_WIDTH,
            sz_spacing_frostbite,
            DEFAULT_IS_INDICATOR_ANIM_ENABLE,
            TABS_ASSET
        )
        TabType.ScrollableWithAssets -> selected?.let {
            ScrollableContainerTabAssets(
                selectedTabIndex,
                tabTitle,
                DEFAULT_IS_INDICATOR_ANIM_ENABLE =DEFAULT_IS_INDICATOR_ANIM_ENABLE,
                it,
                onTabClick,
                containerClicked = containerClicked,
                TABS_ASSET = TABS_ASSET,
                CONTAINER_STYLE_INDICATOR_HEIGHT,
                CONTAINER_STYLE_INDICATOR_WIDTH,
                CONTAINER_STYLE_INDICATOR_PADDING
            )
        }
    }
}