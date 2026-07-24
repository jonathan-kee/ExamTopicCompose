package com.example.myapplication.composable

import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ClickMe(name: String) {
    Text(text = "This composable in inside Composables.kt")
}

@Composable
fun AfterClickMe(name: String, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

// Items has a default list if argument was not provided
@Composable
fun ResponsiveLayout(items: List<String> = listOf("Item 1", "Item 2", "Item 3", "Item 4")) {
    // No need to keep track of index in Kotlin
    for(i in items.indices){
        FlowRow {
            Text(text = items[i])
        }
    }
}

@Composable
fun ModifierExample() {
    Text(
        text = "Hello with padding",
        modifier = Modifier.padding(16.dp)
    )
}