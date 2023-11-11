package com.axisbank.kmm

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.axisbank.dbat.arctic.ui.theme.sz_color_icon_action_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_color_neutral_1
import com.axisbank.dbat.arctic.ui.theme.sz_colour_datavis_5_1
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_cool
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_deepFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite1
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_cold
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_iceAge
import getTypography


@OptIn(ExperimentalComposeUiApi::class)
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
    val context = LocalContext.current
    // Example of how to get FontFamily from Typography
    val typography = getTypography()

    val latoRegular: FontFamily? = typography.body1.fontFamily
    val latoBold: FontFamily? = typography.h1.fontFamily
    val latoSemiBold: FontFamily? = typography.subtitle1.fontFamily

    // Use rememberUpdatedState to keep track of IconButton click state
    val iconButtonClicked by rememberUpdatedState(newValue = isMenuExpanded)
    var selectedValueRemembered by remember { mutableStateOf(selectedValue) }

    var imeAction by remember { mutableStateOf(ImeAction.Done) }
    var keyboardController by remember { mutableStateOf<SoftwareKeyboardController?>(null) }


    Column(Modifier.padding(end = sz_spacing_cool)) {
        Text(
            text = title,
            fontSize = sz_typo_font_size_cold,
            fontFamily = latoBold,
            modifier = Modifier.padding(
                sz_spacing_glacial,
                sz_spacing_glacial,
                sz_spacing_glacial,
                sz_spacing_quickFreeze
            )
        )
        Spacer(
            modifier = Modifier
                .height(sz_spacing_frostbite)
        )
        Column(
            modifier = Modifier
                .padding(
                    start = sz_spacing_cool,
                    top = sz_spacing_frostbite
                )
        ) {
            Box(
                modifier = Modifier
                    .padding(end = sz_spacing_glacial)
            ) {

                TextField(
                    enabled = !isDisabled,
                    modifier = Modifier
                        .padding(end = sz_spacing_glacial)
                        .clickable {
                            // Toggle the menu expansion when the box is clicked
                            onMenuExpandedChange(!isMenuExpanded)
                            Log.i("dropdown", "text field clicked, isMenuExpanded $isMenuExpanded")
                        }
                    .onFocusChanged {
                        if (it.isFocused) {
                            // TextField gained focus, expand the menu
                            onMenuExpandedChange(true)
                            Log.i("dropdown","text field clicked has focus isMenuExpanded $isMenuExpanded")
                        }else{
                            Log.i("dropdown","text field lost focus isMenuExpanded $isMenuExpanded")
                            //onMenuExpandedChange(false)
                        }
                    },
                    label = {
                        Text(
                            text = "Label",
                            color = sz_colour_datavis_5_1,
                            fontSize = sz_typo_font_size_frigid,
                            fontFamily = latoRegular
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = imeAction
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            onMenuExpandedChange(false)
                            keyboardController?.hide()
                        }
                    ),
                    isError = isError,
                    value = selectedValueRemembered,
                    onValueChange = {
                        selectedValueRemembered = it
                        onSelectedValueChange(selectedValueRemembered)
                        onMenuExpandedChange(false)

                    },
                    textStyle = MaterialTheme.typography.body1.copy(
                        fontSize = sz_typo_font_size_frigid,
                        fontFamily = latoRegular
                    ),
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null,
                            modifier = Modifier.clickable { onMenuExpandedChange(!isMenuExpanded) })
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = sz_color_neutral_1,
                        focusedIndicatorColor =
                        if (iconButtonClicked)
                            sz_color_icon_action_tertiary
                        else sz_color_icon_action_tertiary,
                        unfocusedIndicatorColor = if (isError) Color.Red else Color.Gray
                    )
                )

            }

            if(noPlaceHolder == false){
                IconText(
                    isError = isError, // Set to true to show the error icon and text in red
                    isSuccess = isSuccess,
                    text = title,
                    latoRegular = latoRegular
                )
            }

        }

        // Dropdown menu positioned below the selected item box
        if (isMenuExpanded && !isDisabled) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                DropdownMenu(
                    expanded = isMenuExpanded,
                    onDismissRequest = { onMenuExpandedChange(false) },
                    properties = PopupProperties(focusable = true,dismissOnBackPress = true,dismissOnClickOutside = true)
                ) {

                    items.subList(1, items.size).forEach { item ->
                        DropdownMenuItem(onClick = {
                            onSelectedValueChange(item)
                            selectedValueRemembered = item
                            onMenuExpandedChange(false)
                            Log.i("dropdown","drop down menu clicked and isMenuExpanded $isMenuExpanded")

                            Toast.makeText(context,"Selected $item",Toast.LENGTH_SHORT).show()
                        }) {
                            Text(
                                text = item,
                                fontSize = sz_typo_font_size_frigid,
                                fontFamily = latoRegular
                            )
                        }
                    }

                    Log.i("dropdown","drop down menu not clicked and isMenuExpanded $isMenuExpanded")
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
    text: String,
    latoRegular: FontFamily?
) {
    Row(
        modifier = Modifier
            .padding(
                start = sz_spacing_frostbite1
            )
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
                    .size(sz_spacing_frostbite1)
                    .padding(end = sz_spacing_quickFreeze)
            )
        }

        Text(
            text = if (text == "Without Placeholder") {
                " "
            } else if (isSuccess) {
                "Success message"
            } else if (isError) {
                "Error message"
            } else text,
            color = if (isError) Color.Red else if (isSuccess) Color.Green else Color.Gray,
            fontSize = sz_typo_font_size_frostbite,
            fontFamily = latoRegular

        )
    }
}
