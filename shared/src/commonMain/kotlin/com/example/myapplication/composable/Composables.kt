package com.example.myapplication.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun ClickMe(name: String = "Preview") {
    Text(
        text = "This composable in inside Composables.kt",
        fontSize = 20.sp,
        lineHeight = 25.sp
    )
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = message,
            fontSize = 20.sp,
            lineHeight = 25.sp,
        )
        Text(
            text = from,
            fontSize = 20.sp
        )
    }
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
@Preview(showBackground = true)
@Composable
fun ResponsiveLayout(items: List<String> = listOf("Item 1", "Item 2", "Item 3", "Item 4")) {
    // No need to keep track of index in Kotlin
    for(i in items.indices){
        FlowRow {
            Text(text = items[i])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExample() {
    Text(
        text = "Hello with padding",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun StateRecomposition(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello ")
                Text(text = name)
            }
            ElevatedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}