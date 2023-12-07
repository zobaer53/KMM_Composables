package com.axisbank.kmm



import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.axisbank.dbat.arctic.ui.theme.sz_color_icon_negative
import com.axisbank.dbat.arctic.ui.theme.sz_color_icon_positive
import com.axisbank.dbat.arctic.ui.theme.sz_color_neutral_1
import com.axisbank.dbat.arctic.ui.theme.sz_color_state_disabled_surface
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_action_tertiary
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
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.axisbank.dbat.arctic.ui.theme.*
import getStyle
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
    val colorError = sz_color_icon_negative
    val colorSuccess = sz_color_icon_positive
    val colorHelper = Color.Gray
    val isHelperEnabled = noPlaceHolder
    var searchText by remember { mutableStateOf(TextFieldValue(selectedValue)) }
    var filteredSuggestions: String = ""
    var iconButtonClick by remember { mutableStateOf(false) }

    Column {
        Text(
            text = title,
            style = TextStyle(
                fontSize = sz_typo_font_size_frostbite,
                lineHeight = sz_typo_line_height_iceAge,
                fontFamily = getStyle().SZ_Typo_Display_Bold_Large.fontFamily,
                textAlign = TextAlign.Center,
                letterSpacing = sz_typo_character_spacing_arctic.sp,
                color =  colorHelper
            ),
            modifier = Modifier.padding(
                sz_spacing_glacial,
                sz_spacing_glacial,
                sz_spacing_glacial,
                sz_spacing_quickFreeze
            )
        )
     /*   Spacer(
            modifier = Modifier
                .height(sz_spacing_frostbite)
        )*/

        Column(
            modifier = Modifier
                .padding(
                    start = sz_spacing_cool,
                    top = sz_spacing_frostbite
                )
        ) {
            Text(
                text = defaultLabel,
                style = TextStyle(
                    fontSize = sz_typo_font_size_frigid,
                    lineHeight = sz_typo_line_height_iceAge,
                    fontFamily = getStyle().SZ_Typo_Body_Regular_Large.fontFamily,
                    color = if(isError) colorError else if (isSuccess) colorSuccess else colorHelper,
                    textAlign = TextAlign.Center,
                    letterSpacing = sz_typo_character_spacing_arctic.sp,
                ),
                modifier = Modifier.padding(
                    sz_spacing_glacial,
                    sz_spacing_glacial,
                    sz_spacing_quickFreeze
                )
            )
            Spacer(
                modifier = Modifier
                    .height(sz_spacing_frostbite)
            )
            Box(
                modifier = Modifier
                    .padding(end = sz_spacing_glacial)
                    .clickable {
                        // Toggle the menu expansion when the box is clicked
                        onMenuExpandedChange(!isMenuExpanded)
                        iconButtonClick = true
                    }
            ) {

                TextField(
                    enabled = !isDisabled,
                    modifier = Modifier
                        .padding(end = sz_spacing_glacial)
                        .border(
                            width = 1.dp,
                            color = if (isError) {
                                colorError
                            } else if (isSuccess) colorSuccess else colorHelper,
                            shape = RoundedCornerShape(sz_spacing_quickFreeze)
                        )
                        .onFocusChanged {
                            if (it.isFocused) {
                                // TextField gained focus, expand the menu
                                onMenuExpandedChange(!isMenuExpanded)
                                iconButtonClick = true
                            }
                        },
                  /*  keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = imeAction
                    ),*/
                    keyboardActions = KeyboardActions(
                        onDone = {
                            onMenuExpandedChange(false)
                            keyboardController?.hide()
                        }
                    ),
                    isError = isError,
                    placeholder = { Text("Placeholder text") },
                            value = searchText,
                    onValueChange = {
                        searchText = it
                        // You can filter suggestions based on the entered text here
                        // For example, you can filter items that start with the entered text
                        if(it.text.isNotEmpty()) {
                            filteredSuggestions =
                                items.subList(1, items.size).firstOrNull { suggestion ->
                                    suggestion.startsWith(it.text, ignoreCase = true)
                                }.toString()
                        }
                        else{
                            onMenuExpandedChange(!isMenuExpanded)
                        }
                        // Update the suggestions based on the filtered list
                        // and expand the menu
                        Log.i("dropdown","filter $filteredSuggestions filter null? = ${filteredSuggestions.isBlank()}")
                                if(filteredSuggestions.length >4 && !iconButtonClicked &&
                                    !searchText.text.equals(items[1]) &&
                                    !searchText.text.equals(items[2]) &&
                                    !searchText.text.equals(items[3]) &&
                                    !searchText.text.equals(items[4])){
                                    onMenuExpandedChange(!isMenuExpanded)
                                }
                    },
                    textStyle = TextStyle(
                        fontSize = sz_typo_font_size_frigid,
                        fontFamily = getStyle().SZ_Typo_Body_Regular_Large.fontFamily,
                    ),
                    trailingIcon = {
                        Icon(imageVector = if(!isMenuExpanded || isDisabled) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                iconButtonClick = true
                                onMenuExpandedChange(!isMenuExpanded) },
                            tint = colorHelper)
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
                        onDismissRequest = {
                            iconButtonClick = false
                            filteredSuggestions = ""
                            onMenuExpandedChange(false)
                                           },
                        properties = PopupProperties(
                            focusable = false,
                            dismissOnBackPress = true,
                            dismissOnClickOutside = true
                        )
                    ) {
                        if(!iconButtonClick &&
                            !searchText.text.equals(items[1]) &&
                            !searchText.text.equals(items[2]) &&
                            !searchText.text.equals(items[3]) &&
                            !searchText.text.equals(items[4])) {
                            filteredSuggestions = items.subList(1, items.size).firstOrNull {
                                it.startsWith(searchText.text, ignoreCase = true)
                            }.toString()
                        }

                        Log.i("dropdown","filter $filteredSuggestions filter null? = ${filteredSuggestions.length}")
                        if(filteredSuggestions.length >4 && !iconButtonClick){

                            Toast.makeText(context, " $filteredSuggestions", Toast.LENGTH_SHORT).show()
                            DropdownMenuItem(onClick = {

                                    onSelectedValueChange(filteredSuggestions)

                                searchText = TextFieldValue( filteredSuggestions )
                                onMenuExpandedChange(false)
                                Toast.makeText(context, "Selected $filteredSuggestions", Toast.LENGTH_SHORT).show()
                            }) {
                                    Text(
                                        text = filteredSuggestions,
                                        fontSize = sz_typo_font_size_frigid,
                                        fontFamily = getStyle().SZ_Typo_Body_Regular_Medium.fontFamily
                                    )

                            }
                        }else{
                            //iconButtonClick = false
                            items.subList(1, items.size).forEach { item ->
                                DropdownMenuItem(onClick = {
                                    onSelectedValueChange(item)
                                    searchText = TextFieldValue(item)
                                    onMenuExpandedChange(false)
                                    iconButtonClick = false
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
                tint = if (isError) colorError else colorSuccess,
                modifier = Modifier
                    .size(sz_spacing_bitterCold)
            )
        }
        Spacer(Modifier.width(6.dp))

        Text(
            text = if (text == defaultHelperText) {
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
