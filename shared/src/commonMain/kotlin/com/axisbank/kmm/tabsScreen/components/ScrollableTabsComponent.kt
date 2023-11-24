package com.axisbank.kmm.tabsScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axisbank.dbat.arctic.ui.theme.default_margin
import com.axisbank.dbat.arctic.ui.theme.height_container_tab
import com.axisbank.dbat.arctic.ui.theme.height_standard_tab
import com.axisbank.dbat.arctic.ui.theme.sz_color_neutral_1
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_action_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_cool
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_mild
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_arctic
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_blizzard
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_iceAge
import com.axisbank.dbat.arctic.ui.theme.tabs_min_width
import getStyle
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@Composable
fun ScrollableTabRowComponent(
    selectedTabIndex: Int,
    tabItems: List<String>,
    onTabClick: (Int) -> Unit,
    contentColor: Color,
    backgroundColor: Color,
    tabMinWidth: Dp,
    spacing: Dp,
    enabled: Boolean,
    asset: Boolean
) {
    // Implementation of ScrollableTabRow
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        divider = { Spacer(modifier = Modifier.height(sz_spacing_frostbite)) },
        edgePadding = 0.dp
    ) {
        tabItems.forEachIndexed { index, tabTitle ->
            Tab(
                selected = if (!enabled) enabled else selectedTabIndex == index,
                onClick = {
                    if (!enabled) {

                    } else {
                        onTabClick(index)
                    }
                },
                enabled = enabled,
                modifier = Modifier.padding(horizontal = spacing),
                selectedContentColor = Color.Transparent
            ) {
                if (!asset) {
                    DefaultScrollableTabs(
                        tabMinWidth,
                        spacing,
                        tabTitle,
                        enabled,
                        selectedTabIndex,
                        index,
                        contentColor
                    )
                } else {
                    DefaultScrollableTabsWithAssets(
                        tabTitle,
                        selectedTabIndex,
                        index,
                        contentColor
                    )

                }
            }
        }
    }
}

@Composable
fun DefaultScrollableTabs(
    tabMinWidth: Dp,
    spacing: Dp,
    tabTitle: String,
    enabled: Boolean,
    selectedTabIndex: Int,
    index: Int,
    contentColor: Color
) {
    Box(
        Modifier
            .widthIn(min = tabMinWidth)
            .height(height_standard_tab)
            .padding(
                start = sz_spacing_cool,
                top = spacing,
                end = spacing,
                bottom = spacing
            )
    ) {
        Text(
            tabTitle,
            style = TextStyle(
                fontSize = sz_typo_font_size_frigid,
                fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                color = if (!enabled) Color.Gray else if (selectedTabIndex == index) contentColor else Color.Gray,
                textAlign = TextAlign.Center,
                letterSpacing = sz_typo_character_spacing_arctic.sp
            )
        )
    }

}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun DefaultScrollableTabsWithAssets(
    tabTitle: String,
    selectedTabIndex: Int,
    index: Int,
    contentColor: Color
) {
    Row(
        Modifier
            .widthIn(min = tabs_min_width)
            .height(height_standard_tab).padding(
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
                color = if (selectedTabIndex == index) {
                    contentColor
                } else Color.Gray,
            )
        )
        Spacer(modifier = Modifier.width(sz_spacing_frostbite))
        Box(
            Modifier.size(default_margin)
                .padding(top = sz_spacing_quickFreeze)
        ) {
            Image(
                painter = painterResource("drawable/image_icon.xml"),
                contentDescription = null
            )
        }
    }
}

@Composable
fun ScrollableContainerTabAssets(
    index: Int,
    tabTitle: String,
    enabled: Boolean,
    selected: Boolean,
    onTabSelected: () -> Unit,
    containerClicked: Boolean,
    asset: Boolean
) {
    Tab(
        enabled = enabled,
        selected = selected,
        onClick = {
            onTabSelected()
            containerClicked != containerClicked
        },
        selectedContentColor = Color.Transparent,
        modifier = Modifier.padding(sz_spacing_glacial) then Modifier
            .border(
                width = if (enabled) 1.dp else 1.dp,
                color = if (selected && enabled) {
                    sz_color_typo_action_tertiary
                } else if (!enabled) Color.Transparent else Color.Gray,
                shape = RoundedCornerShape(sz_spacing_quickFreeze)
            ).background(
                if (selected && enabled) {
                    sz_color_neutral_1
                } else Color.Transparent
            )
    ) {
        // Container dimensions from subzero
        if (!asset) {
            ScrollableContainer(tabTitle, selected, enabled)
        } else {
            ScrollableContainerWithAsset(tabTitle, selected, enabled)
        }
    }
}

@Composable
fun ScrollableContainer(tabTitle: String, selected: Boolean, enabled: Boolean) {
    Box(
        modifier = Modifier.widthIn(min = tabs_min_width)
            .height(height_container_tab).padding(
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
                fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                color = if (selected && enabled) sz_color_typo_action_tertiary else Color.Gray,
                textAlign = TextAlign.Center,
                letterSpacing = sz_typo_character_spacing_arctic.sp,
            )
        )
    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ScrollableContainerWithAsset(tabTitle: String, selected: Boolean, enabled: Boolean) {
    Row(
        Modifier
            .widthIn(min = tabs_min_width)
            .height(height_container_tab).padding(
                start = sz_spacing_cool,
                top = sz_spacing_frostbite,
                bottom = sz_spacing_frostbite,
                end = sz_spacing_cool
            )
    ) {
        Text(
            tabTitle.uppercase(),
            style = TextStyle(
                fontSize = sz_typo_font_size_blizzard,
                lineHeight = sz_typo_line_height_iceAge,
                fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                color = if (selected && enabled) sz_color_typo_action_tertiary else Color.Gray,
                textAlign = TextAlign.Center,
                letterSpacing = sz_typo_character_spacing_arctic.sp,
            )
        )
        Spacer(modifier = Modifier.width(sz_spacing_frostbite))
        Box(
            Modifier.size(default_margin)
                .padding(top = sz_spacing_quickFreeze)
        ) {
            Image(
                painter = painterResource("drawable/image_icon.xml"),
                contentDescription = null
            )
        }
    }
}