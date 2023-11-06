package com.axisbank.kmm

class DropdownSampleData {
    fun getSampleItems(): List<String> {
        return listOf("","Monday", "Tuesday", "Wednesday", "Thursday")
    }
}

// Shared code
class TabSampleData() {
    fun getSampleItems(): List<String> {
        return listOf("Tab 1","Tab 2", "Tab 3")
    }
}
class TabSampleScrollableData() {
    fun getSampleItems(): List<String> {
        return listOf(" Tab First ","Tab Second ", " Tab Third "," Tab Fourth "," Tab Fifth ", " Tab Sixth ")
    }
}
