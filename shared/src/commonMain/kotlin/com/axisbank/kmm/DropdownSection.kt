package com.axisbank.kmm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axisbank.dbat.arctic.ui.theme.sz_color_surface_secondary
import com.axisbank.dbat.arctic.ui.theme.sz_colour_datavis_5_1
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_bitterCold
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_deepFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_cold
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_iceAge

@Composable
fun DropdownSection(
    title: String,
    selectedValue: String,
    onSelectedValueChange: (String) -> Unit,
    isMenuExpanded: Boolean,
    onMenuExpandedChange: (Boolean) -> Unit,
    isDisabled: Boolean = false,
    isError: Boolean = false,
    isSuccess: Boolean = false,
    noPlaceHolder: Boolean? = false,
    items: List<String>
) {
    Column {
        Text(
            text = title,
            fontSize = sz_typo_font_size_cold,
            modifier = Modifier.padding(
                sz_spacing_glacial,
                sz_spacing_glacial,
                sz_spacing_glacial,
                sz_spacing_quickFreeze
            )
        )
        Spacer(modifier = Modifier.height(sz_spacing_glacial))

        // Box to display the selected item or error message
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .border(
                    width = sz_spacing_deepFreeze,
                    color = if (isError) Color.Red
                    else if (isSuccess) Color.Green
                    else Color.Gray, // Set border color based on 'isError'
                    shape = RectangleShape
                )
                .padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
                .clickable { onMenuExpandedChange(!isMenuExpanded) }
        ) {
            Column {
                Text(
                    text = "Label",
                    color = sz_colour_datavis_5_1,
                    fontSize = sz_typo_font_size_frigid,
                    modifier = Modifier
                        .padding(start = sz_spacing_quickFreeze)

                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = sz_spacing_quickFreeze),
                       verticalAlignment = (Alignment.CenterVertically), // Align the children vertically
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = selectedValue,
                        fontSize = sz_typo_font_size_frigid,
                    )
                    IconButton(
                        modifier = Modifier,
                        onClick = {  },
                        enabled = !isDisabled
                    ) {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                    }
                }
            }
        }





        IconText(
            isError = isError, // Set to true to show the error icon and text in red
            isSuccess = isSuccess,
            text = title
        )


        // Dropdown menu positioned below the selected item box
        if (isMenuExpanded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                DropdownMenu(
                    expanded = isMenuExpanded,
                    onDismissRequest = { onMenuExpandedChange(false) }
                ) {

                    items.subList(1, items.size).forEach { item ->
                        DropdownMenuItem(onClick = {
                            onSelectedValueChange(item)
                            onMenuExpandedChange(false)
                        }) {
                            Text(text = item,
                                fontSize = 12.sp,
                            )
                        }
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(sz_spacing_quickFreeze))

}


@Composable
fun IconText(
    isError: Boolean,
    isSuccess: Boolean,
    text: String
) {
    Row(
        modifier = Modifier.padding(start = sz_spacing_glacial)
    ) {
        val icon = if (isError) {
            Icons.Default.Warning
        } else if (isSuccess) {
            Icons.Default.CheckCircle
        } else null

        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = null, // Provide an appropriate content description
                tint = if (isError) Color.Red else Color.Green,
                modifier = Modifier
                    .size(sz_spacing_frostbite)
                    .padding(end = sz_spacing_quickFreeze)
            )
        }

        Text(
            text = if (text == "Without Placeholder"){ " "} else if(isSuccess){"Success message"}else if(isError){"Error message"} else text,
            color = if (isError) Color.Red else if (isSuccess) Color.Green else Color.Gray,
            fontSize = sz_typo_font_size_iceAge
        )
    }
}
