/*
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.axisbank.kmm.TabSampleData


@Composable
fun Tabs(
    selectedTab: List<String>,
    onTabSelected: (TabSampleData) -> Unit
) {
    TabRow(
        selectedTabIndex = when (selectedTab) {
            is TabSampleData.Tab1 -> 0
            is TabSampleData.Tab2 -> 1
            is TabSampleData.Tab3 -> 2
            else -> {}
        },
    ) {
        Tab(
            selected = selectedTab is TabSampleData.Tab1,
            onClick = { onTabSelected(TabSampleData.Tab1) }
        ) {
            Text("Tab 1")
        }
        Tab(
            selected = selectedTab is TabSampleData.Tab2,
            onClick = { onTabSelected(TabSampleData.Tab2) }
        ) {
            Text("Tab 2")
        }
        Tab(
            selected = selectedTab is TabSampleData.Tab3,
            onClick = { onTabSelected(TabSampleData.Tab3) }
        ) {
            Text("Tab 3")
        }
    }
}*/
