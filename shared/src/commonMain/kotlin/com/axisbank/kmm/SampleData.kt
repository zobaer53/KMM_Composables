package com.axisbank.kmm

class DropdownSampleData {
    fun getSampleItems(): List<String> {
        return listOf("","Monday", "Tuesday", "Wednesday", "Thursday")
    }
}

// Shared code
class TabSampleData() {
    fun getSampleItems(): List<String> {
        return listOf("Tabs 1","Tabs 2", "Tabs 3")
    }
}
class TabSampleScrollableData() {
    fun getSampleItems(): List<String> {
        return listOf("Tabs 1","Tabs 2", "Tabs 3","Tabs 1","Tabs 2", "Tabs 3")
    }
}
