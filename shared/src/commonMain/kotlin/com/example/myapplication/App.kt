package com.example.myapplication

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.composable.AfterClickMe
import com.example.myapplication.composable.ClickMe
import com.example.myapplication.composable.GreetingText
import com.example.myapplication.composable.ResponsiveLayout
import com.example.myapplication.composable.StateRecomposition
import com.example.myapplication.theme.ui.QuickNotesAppTheme

// QuickNotesAppTheme is a composable, the last parameter named "content" is a function
// The type of "content" is @Composable() () -> Unit

// Column is a composable, the last parameter is a function
// The type of "content" is @Composable ColumnScope.() -> Unit

// I think why they can contain child is because of the last parameter

@Composable
@Preview
fun App() {
    QuickNotesAppTheme {
        var showContent by remember { mutableStateOf(false) }
        Column {
            Button(onClick = { showContent = !showContent }) {
                ClickMe("Testing")
            }

            GreetingText("Greeting", "Jon")

            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column {
                    // The modifier is optional and already has default
                    AfterClickMe("Jonathan", Modifier.padding(16.dp))
                    ResponsiveLayout()
                    StateRecomposition("Test")
                }
            }
        }
    }
}