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
    asset: Boolean
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
            if (!asset) {
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
                    enabled = enabled
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
                    enabled = enabled
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
    enabled: Boolean
) {
    Tab(
        enabled = enabled,
        selected = selected,
        onClick = onClick,
        selectedContentColor = Color.Transparent,
        modifier = Modifier.widthIn(min = tabs_min_width)
            .height(height_container_tab).padding(end = sz_spacing_glacial)
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
        Text(
            tabTitle,
            style = TextStyle(
                fontSize = sz_typo_font_size_frigid,
                lineHeight = sz_typo_line_height_iceAge,
                fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                color = if (selected) {
                    sz_color_typo_action_tertiary
                } else Color.Gray,
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
    enabled: Boolean
) {
    Tab(
        enabled = enabled,
        selected = selected,
        onClick = onClick,
        selectedContentColor = Color.Transparent,
        modifier = Modifier.widthIn(min = tabs_min_width)
            .height(height_container_tab).padding(end = sz_spacing_glacial)
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
                        sz_color_typo_action_tertiary
                    } else Color.Gray,
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
