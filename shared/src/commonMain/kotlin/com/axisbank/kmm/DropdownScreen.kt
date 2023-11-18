package com.axisbank.kmm

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axisbank.dbat.arctic.ui.components.appBar.AppBar
import com.axisbank.dbat.arctic.ui.components.appBar.AppbarTheme
import com.axisbank.dbat.arctic.ui.theme.AppTheme
import com.axisbank.dbat.arctic.ui.theme.ThemeViewModel
import com.axisbank.kmm.resources.Resources

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DropdownScreen(dropDownClick: () -> Unit, isDarkMode1: ThemeViewModel) {
    val dropdownSampleData = DropdownSampleData()
    var isDarkMode by remember { mutableStateOf(isDarkMode1) }

    AppTheme (false,isDarkMode.isDarkMode){
        val items = remember { dropdownSampleData.getSampleItems() }
        var selectedValueEnabled by remember { mutableStateOf(items[0]) }
        var selectedValueDisabled by remember { mutableStateOf(items[0]) }
        var selectedValueError by remember { mutableStateOf(items[0]) }
        var selectedValueSucess by remember { mutableStateOf(items[0]) }
        var selectedValueWithPlaceholder by remember { mutableStateOf(items[0]) }
        var selectedValueWithoutPlaceholder by remember { mutableStateOf(items[0]) }

        var isMenuExpandedEnabled by remember { mutableStateOf(false) }
        var isMenuExpandedDisabled by remember { mutableStateOf(false) }
        var isMenuExpandedError by remember { mutableStateOf(false) }
        var isMenuExpandedSuccess by remember { mutableStateOf(false) }
        var isMenuExpandedWithPlaceholder by remember { mutableStateOf(false) }
        var isMenuExpandedWithoutPlaceholder by remember { mutableStateOf(false) }

        Scaffold(
            topBar = {
                AppBar(
                Resources.strings.dropdownString,
                pressOnBack = { dropDownClick.invoke() },
                Icons.Filled.ArrowBack,
                    AppbarTheme.BURGUNDY,isDarkMode
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(20.dp)
                ) {
                    // Enabled dropdown section
                    DropdownSection(
                        title = Resources.strings.enabledString,
                        selectedValue = selectedValueEnabled,
                        onSelectedValueChange = { selectedValueEnabled = it },
                        isMenuExpanded = isMenuExpandedEnabled,
                        onMenuExpandedChange = { isMenuExpandedEnabled = it },
                        false,
                        false,
                        false,
                        false,
                        items
                    )

                    // Disabled dropdown section
                    DropdownSection(
                        title = Resources.strings.disabledString,
                        selectedValue = selectedValueDisabled,
                        onSelectedValueChange = { selectedValueDisabled = it },
                        isMenuExpanded = isMenuExpandedDisabled,
                        onMenuExpandedChange = { isMenuExpandedDisabled = it },
                        true,
                        false,
                        false,
                        false,
                        items
                    )

                    // Error dropdown section
                    DropdownSection(
                        title = Resources.strings.errorString,
                        selectedValue = selectedValueError,
                        onSelectedValueChange = { selectedValueError = it },
                        isMenuExpanded = isMenuExpandedError,
                        onMenuExpandedChange = { isMenuExpandedError = it },
                        false,
                        true,
                        false,
                        false,
                        items
                    )

                    // With Placeholder dropdown section
                    DropdownSection(
                        title = Resources.strings.selectedString,
                        selectedValue = selectedValueSucess,
                        onSelectedValueChange = { selectedValueSucess = it },
                        isMenuExpanded = isMenuExpandedSuccess,
                        onMenuExpandedChange = { isMenuExpandedSuccess = it },
                        false,
                        false,
                        true,
                        false,
                        items
                    )
                    // With Placeholder dropdown section
                    DropdownSection(
                        title = Resources.strings.withPlaceholder,
                        selectedValue = selectedValueWithPlaceholder,
                        onSelectedValueChange = { selectedValueWithPlaceholder = it },
                        isMenuExpanded = isMenuExpandedWithPlaceholder,
                        onMenuExpandedChange = { isMenuExpandedWithPlaceholder = it },
                        false,
                        false,
                        false,
                        false,
                        items
                    )

                    // Without Placeholder dropdown section
                    DropdownSection(
                        title = Resources.strings.withOutHelperString,
                        selectedValue = selectedValueWithoutPlaceholder,
                        onSelectedValueChange = { selectedValueWithoutPlaceholder = it },
                        isMenuExpanded = isMenuExpandedWithoutPlaceholder,
                        onMenuExpandedChange = { isMenuExpandedWithoutPlaceholder = it },
                        false,
                        false,
                        false,
                        true,
                        items
                    )
                }
            }
        )
    }
}