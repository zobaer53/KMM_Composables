package com.axisbank.kmm.tabsScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axisbank.dbat.arctic.ui.theme.fab_icon_size_mini
import com.axisbank.dbat.arctic.ui.theme.height_container_tab
import com.axisbank.dbat.arctic.ui.theme.sz_color_neutral_1
import com.axisbank.dbat.arctic.ui.theme.sz_color_surface_background
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_action_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_arctic
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_iceAge
import com.axisbank.dbat.arctic.ui.theme.tabs_min_width
import getStyle
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContainerTabRow(
    selectedTabIndex: Int,
    tabItems: List<String>,
    onTabSelected: (Int) -> Unit,
    containerClicked: Boolean,
    enabled: Boolean,
    TABS_ASSET: Boolean,
    CONTAINER_STYLE_INDICATOR_HEIGHT: Dp,
    CONTAINER_STYLE_INDICATOR_WIDTH: Dp,
    CONTAINER_STYLE_INDICATOR_PADDING : Dp,
    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES :Color,
    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES : Color
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = sz_color_surface_background,
        divider = {
            Spacer(modifier = Modifier.height(sz_spacing_frostbite))
        },
        contentColor = Color.Transparent
    ) {
        tabItems.forEachIndexed { index, tabTitle ->
            if (!TABS_ASSET) {
                ContainerTab(
                    selected = if (!enabled) {
                        enabled
                    } else {
                        selectedTabIndex == index
                    },
                    onClick = {
                        onTabSelected(index)
                    },
                    tabTitle = tabTitle,
                    enabled = enabled,
                    CONTAINER_STYLE_INDICATOR_HEIGHT,
                CONTAINER_STYLE_INDICATOR_WIDTH,
                    CONTAINER_STYLE_INDICATOR_PADDING,
                    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                )
            } else {
                ContainerTabWithAsset(
                    selected = if (!enabled) {
                        enabled
                    } else {
                        selectedTabIndex == index
                    },
                    onClick = {
                        onTabSelected(index)
                    },
                    tabTitle = tabTitle,
                    enabled = enabled,
                    CONTAINER_STYLE_INDICATOR_HEIGHT,
                    CONTAINER_STYLE_INDICATOR_WIDTH,
                    CONTAINER_STYLE_INDICATOR_PADDING,
                    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES ,
                    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                )
            }
        }
    }
}

@Composable
fun ContainerTab(
    selected: Boolean,
    onClick: () -> Unit,
    tabTitle: String,
    enabled: Boolean,
    CONTAINER_STYLE_INDICATOR_HEIGHT: Dp,
    CONTAINER_STYLE_INDICATOR_WIDTH:  Dp,
    CONTAINER_STYLE_INDICATOR_PADDING :Dp,
    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES :Color,
    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES : Color
) {
    Tab(
        enabled = enabled,
        selected = selected,
        onClick = onClick,
        selectedContentColor = Color.Transparent,
        modifier = Modifier.widthIn(min = CONTAINER_STYLE_INDICATOR_WIDTH)
            .height(CONTAINER_STYLE_INDICATOR_HEIGHT)
            .padding(end = CONTAINER_STYLE_INDICATOR_PADDING)
            .border(
                width = if (enabled) 1.dp else 1.dp,
                color = if (selected && enabled) {
                    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                } else if (!enabled) Color.Transparent else CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                shape = RoundedCornerShape(sz_spacing_quickFreeze)
            ).background(
                if (selected && enabled) {
                    sz_color_neutral_1
                } else Color.Transparent
            )
    ) {
        Text(
            tabTitle,
            style = TextStyle(
                fontSize = sz_typo_font_size_frigid,
                lineHeight = sz_typo_line_height_iceAge,
                fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                color = if (selected) {
                    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                } else CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                textAlign = TextAlign.Center,
                letterSpacing = sz_typo_character_spacing_arctic.sp,
            )
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ContainerTabWithAsset(
    selected: Boolean,
    onClick: () -> Unit,
    tabTitle: String,
    enabled: Boolean,
    CONTAINER_STYLE_INDICATOR_HEIGHT: Dp,
    CONTAINER_STYLE_INDICATOR_WIDTH: Dp,
    CONTAINER_STYLE_INDICATOR_PADDING : Dp,
    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES :Color,
    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES : Color
) {
    Tab(
        enabled = enabled,
        selected = selected,
        onClick = onClick,
        selectedContentColor = Color.Transparent,
        modifier = Modifier.widthIn(min = CONTAINER_STYLE_INDICATOR_WIDTH)
            .height(CONTAINER_STYLE_INDICATOR_HEIGHT)
            .padding(end = sz_spacing_glacial)
            .border(
                width = if (enabled) 1.dp else 1.dp,
                color = if (selected && enabled) {
                    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                } else if (!enabled) Color.Transparent else CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                shape = RoundedCornerShape(sz_spacing_quickFreeze)
            ).background(
                if (selected && enabled) {
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
                    color = if (selected) {
                        CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
                    } else CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                    textAlign = TextAlign.Center,
                    letterSpacing = sz_typo_character_spacing_arctic.sp
                )
            )
            Box(
                Modifier.size(fab_icon_size_mini)
                    .padding(sz_spacing_quickFreeze)
            ) {
                Image(
                    painter = painterResource("drawable/image_icon.xml"), // Replace with the desired icon from Icons
                    contentDescription = null// Set to null if you don't need a content description
                )
            }
        }
    }
}
