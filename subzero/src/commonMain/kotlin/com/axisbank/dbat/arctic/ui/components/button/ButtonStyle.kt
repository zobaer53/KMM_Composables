package com.axisbank.dbat.arctic.ui.components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axisbank.dbat.arctic.ui.theme.dialog_width
import com.axisbank.dbat.arctic.ui.theme.fab_size_normal
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_on_surface
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_bitterCold
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_blazing
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_mild
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_bitterCold
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frostbite

//textsize
val smallFont = sz_typo_font_size_frostbite
val mediumFont = sz_typo_font_size_frigid
val largeFont = sz_typo_font_size_bitterCold
private val smallModifierHeight = 34.dp

//Base
var baseShape = RoundedCornerShape(sz_spacing_glacial)
var baseModifier = Modifier.width(dialog_width).height(sz_spacing_blazing).padding(
    start = sz_spacing_bitterCold, end = sz_spacing_bitterCold
)

//large
val largeModifier = Modifier.height(fab_size_normal).padding(
    start = sz_spacing_bitterCold, end = sz_spacing_bitterCold
)

//medium
val mediumModifier = Modifier.height(sz_spacing_blazing).padding(
    start = sz_spacing_bitterCold, end = sz_spacing_bitterCold
)

//small
val smallModifier = Modifier.height(smallModifierHeight).padding(
    start = sz_spacing_glacial, end = sz_spacing_glacial
)

var textColor = sz_color_typo_on_surface
val smallIcon = Modifier.size(sz_spacing_bitterCold)
val mediumIcon = Modifier.size(sz_spacing_mild)
val largeIcon = Modifier.size(sz_spacing_mild)

