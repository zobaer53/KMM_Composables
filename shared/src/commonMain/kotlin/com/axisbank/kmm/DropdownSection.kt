package com.axisbank.kmm

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.axisbank.dbat.arctic.ui.theme.sz_color_icon_action_tertiary
import com.axisbank.dbat.arctic.ui.theme.sz_color_neutral_1
import com.axisbank.dbat.arctic.ui.theme.sz_color_state_disabled_surface
import com.axisbank.dbat.arctic.ui.theme.sz_colour_datavis_5_1
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_bitterCold
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_cool
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_spacing_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_arctic
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_iceAge
import com.axisbank.kmm.resources.Resources
import getStyle
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

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

    // Use rememberUpdatedState to keep track of IconButton click state
    val iconButtonClicked by rememberUpdatedState(newValue = isMenuExpanded)
    var selectedValueRemembered by remember { mutableStateOf(selectedValue) }

    val imeAction by remember { mutableStateOf(ImeAction.Done) }
    val keyboardController by remember { mutableStateOf<SoftwareKeyboardController?>(null) }
    val defaultHelperText = Resources.strings.withOutPlaceholder
    val defaultLabel = Resources.strings.labelString
    val errorText = Resources.strings.errorMessage
    val successText = Resources.strings.successMessage
     val colorError = Color.Red
     val colorSuccess = Color.Green
    val colorHelper = Color.Gray
    val isHelperEnabled = noPlaceHolder

        Column() {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = sz_typo_font_size_frostbite,
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
                            }
                            .onFocusChanged {
                                if (it.isFocused) {
                                    // TextField gained focus, expand the menu
                                    onMenuExpandedChange(true)
                                }
                            },
                        label = {
                            Text(
                                text = defaultLabel,
                                style = TextStyle(
                                    fontSize = sz_typo_font_size_frigid,
                                    lineHeight = sz_typo_line_height_iceAge,
                                    fontFamily = getStyle().SZ_Typo_Body_Regular_Large.fontFamily,
                                    color = sz_colour_datavis_5_1,
                                    textAlign = TextAlign.Center,
                                    letterSpacing = sz_typo_character_spacing_arctic.sp,
                                )
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
                        textStyle = TextStyle(
                            fontSize = sz_typo_font_size_frigid,
                            fontFamily = getStyle().SZ_Typo_Body_Regular_Large.fontFamily,
                        ),
                        trailingIcon = {
                            Icon(imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                modifier = Modifier.clickable { onMenuExpandedChange(!isMenuExpanded) })
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = if (isDisabled) sz_color_state_disabled_surface else sz_color_neutral_1,
                            focusedIndicatorColor =
                            if (iconButtonClicked)
                                sz_color_icon_action_tertiary
                            else sz_color_icon_action_tertiary,
                            unfocusedIndicatorColor = if (isError) Color.Red else Color.Gray
                        )
                    )
                }
                // Dropdown menu positioned below the selected item box
                if (isMenuExpanded && !isDisabled) {
                    Box(
                        Modifier
                            .background(Color.Transparent)
                    ) {
                        DropdownMenu(
                            expanded = isMenuExpanded,
                            modifier = Modifier
                                .widthIn(min = 280.dp)
                                .clip(RoundedCornerShape(10.dp))
                            // .background(Color.Gray)
                            , // Add padding here
                            onDismissRequest = { onMenuExpandedChange(false) },
                            properties = PopupProperties(
                                focusable = true,
                                dismissOnBackPress = true,
                                dismissOnClickOutside = true
                            )
                        ) {
                            items.subList(1, items.size).forEach { item ->
                                DropdownMenuItem(onClick = {
                                    onSelectedValueChange(item)
                                    selectedValueRemembered = item
                                    onMenuExpandedChange(false)
                                    Toast.makeText(context, "Selected $item", Toast.LENGTH_SHORT).show()
                                }) {
                                    Text(
                                        text = item,
                                        fontSize = sz_typo_font_size_frigid,
                                        fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily
                                    )
                                }
                            }
                        }
                    }
                }

                if (isHelperEnabled == false) {
                    IconText(
                        isError = isError, // Set to true to show the error icon and text in red
                        isSuccess = isSuccess,
                        text = title,
                        defaultHelperText,
                        errorText,
                        successText,
                        colorError,
                        colorSuccess,
                        colorHelper
                    )
                }
            }
        }


            Spacer(modifier = Modifier.height(sz_spacing_quickFreeze))
}
@OptIn(ExperimentalResourceApi::class)
@Composable
fun IconText(
    isError: Boolean,
    isSuccess: Boolean,
    text: String,
    defaultHelperText: String,
    errorText: String,
    successText: String,
    colorError: Color,
    colorSuccess: Color,
    colorHelper: Color,
) {
    Row(
        modifier = Modifier
            .padding(
                top = sz_spacing_glacial
            )
    ) {
        val icon: Painter? = if (isError) {
            painterResource("drawable/error_icon.xml")
        } else if (isSuccess) {
            painterResource("drawable/success_icon.xml")
        } else null

        icon?.let {
            Icon(
                painter = it,
                contentDescription = null, // Provide an appropriate content description
                tint = if (isError) colorError  else colorSuccess,
                modifier = Modifier
                    .size(sz_spacing_bitterCold)
            )
        }
        Text(
            text = if (text == defaultHelperText ) {
                " "
            } else if (isSuccess) {
                successText
            } else if (isError) {
                errorText
            } else text,
            style = TextStyle(
                fontSize = sz_typo_font_size_frostbite,
                lineHeight = sz_typo_line_height_iceAge,
                fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily,
                textAlign = TextAlign.Center,
                color = if (isError) colorError else if (isSuccess) colorSuccess else colorHelper,
                letterSpacing = sz_typo_character_spacing_arctic.sp,
            )
        )
    }
}
