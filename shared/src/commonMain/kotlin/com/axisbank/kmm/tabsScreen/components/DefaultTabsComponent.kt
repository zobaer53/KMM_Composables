package com.axisbank.kmm.tabsScreen.components

import androidx.compose.foundation.Image
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
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.axisbank.dbat.arctic.ui.theme.default_margin
import com.axisbank.dbat.arctic.ui.theme.height_standard_tab
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_cool
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.tabs_min_width
import getStyle
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun DefaultTabsComponent(
    selectedTabIndex: Int,
    tabItems: List<String>,
    onTabClick: (Int) -> Unit,
    CONTAINER_STYLE_INDICATOR_HEIGHT: Dp,
    selectedContentColor: Color,
    CONTAINER_STYLE_BACKGROUND_COLOR_RES: Color,
    tabMinWidth: Dp,
    spacing: Dp,
    DEFAULT_IS_INDICATOR_ANIM_ENABLE: Boolean,
    CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES: Color
) {
    // Implementation of TabRow
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = CONTAINER_STYLE_BACKGROUND_COLOR_RES,
        divider = { Spacer(modifier = Modifier.height(sz_spacing_frostbite)) },
        contentColor = selectedContentColor
    ) {
        tabItems.forEachIndexed { index, tabTitle ->
            Tab(
                selected = if(!DEFAULT_IS_INDICATOR_ANIM_ENABLE) {DEFAULT_IS_INDICATOR_ANIM_ENABLE }else {selectedTabIndex == index},
                onClick = { onTabClick(index) },
                enabled = DEFAULT_IS_INDICATOR_ANIM_ENABLE,
                modifier = Modifier
                    .widthIn(min = tabMinWidth)
                    .height(CONTAINER_STYLE_INDICATOR_HEIGHT)
                    .padding(horizontal = spacing),
                selectedContentColor = CONTAINER_STYLE_BACKGROUND_COLOR_RES
            ) {
                Text(
                    tabTitle,
                    Modifier.padding(
                        start = spacing,
                        top = spacing,
                        end = spacing,
                        bottom = spacing
                    ),
                    color = if(DEFAULT_IS_INDICATOR_ANIM_ENABLE) CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES
                    else if (selectedTabIndex == index) selectedContentColor
                    else CONTAINER_STYLE_TEXT_UNSELECTED_COLOR_RES,
                    fontSize = sz_typo_font_size_frigid,
                    fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily
                )
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun DefaultTabsComponentWithAssets(
    selectedTabIndex: Int,
    tabItems: List<String>,
    onTabClick: (Int) -> Unit,
    COMMON_TABS_STYLE_BACKGROUND_COLOR_RES: Color,
    CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES: Color
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = COMMON_TABS_STYLE_BACKGROUND_COLOR_RES,
        divider = { Spacer(modifier = Modifier.height(sz_spacing_frostbite)) },
        contentColor = CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
    ) {
        tabItems.forEachIndexed { index, tabTitle ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabClick(index) },
                enabled = true,
                modifier = Modifier
                    .padding(horizontal =  sz_spacing_glacial) then
                        Modifier.border(
                            width = 1.dp,
                            color = Color.Transparent,
                            shape = RoundedCornerShape(sz_spacing_quickFreeze)
                        ),
                selectedContentColor = COMMON_TABS_STYLE_BACKGROUND_COLOR_RES
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
                                CONTAINER_STYLE_TEXT_SELECTED_COLOR_RES
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
        }
    }
}