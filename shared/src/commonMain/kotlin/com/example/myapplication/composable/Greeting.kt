package com.example.myapplication.composable

import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Greeting {
}

@Composable
fun ClickMe(name: String) {
    Text(text = "This composable in inside Greeting.kt")
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

@Composable
fun ResponsiveLayout() {
    FlowRow {
        Text(text = "Item 1")
    }
    FlowRow{
        Text(text = "Item 2")
    }
    FlowRow{
        Text(text = "Item 3")
    }
}

@Composable
fun ModifierExample() {
    Text(
        text = "Hello with padding",
        modifier = Modifier.padding(16.dp)
    )
}