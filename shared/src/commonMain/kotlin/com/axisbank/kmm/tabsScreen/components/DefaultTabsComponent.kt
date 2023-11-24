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
    height: Dp,
    selectedContentColor: Color,
    backgroundColor: Color,
    tabMinWidth: Dp,
    spacing: Dp,
    enabled: Boolean,
    textColor: Color
) {
    // Implementation of TabRow
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = backgroundColor,
        divider = { Spacer(modifier = Modifier.height(sz_spacing_frostbite)) },
        contentColor = selectedContentColor
    ) {
        tabItems.forEachIndexed { index, tabTitle ->
            Tab(
                selected = if(!enabled) {enabled }else {selectedTabIndex == index},
                onClick = { onTabClick(index) },
                enabled = enabled,
                modifier = Modifier
                    .widthIn(min = tabMinWidth)
                    .height(height)
                    .padding(horizontal = spacing),
                selectedContentColor = selectedContentColor
            ) {
                Text(
                    tabTitle,
                    Modifier.padding(
                        start = spacing,
                        top = spacing,
                        end = spacing,
                        bottom = spacing
                    ),
                    color = if(!enabled) textColor else if (selectedTabIndex == index) selectedContentColor else textColor,
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
    backgroundColor: Color,
    contentColor: Color
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = backgroundColor,
        divider = { Spacer(modifier = Modifier.height(sz_spacing_frostbite)) },
        contentColor = contentColor
    ) {
        tabItems.forEachIndexed { index, tabTitle ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabClick(index) },
                enabled = true,
                modifier = Modifier
                    .padding(end = sz_spacing_glacial) then
                        Modifier.border(
                            width = 1.dp,
                            color = Color.Transparent,
                            shape = RoundedCornerShape(sz_spacing_quickFreeze)
                        ),
                selectedContentColor = contentColor
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
        }
    }
}