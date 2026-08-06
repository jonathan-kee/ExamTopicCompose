# Resources to learn Kotlin UI
Download theme free
- https://material-foundation.github.io/material-theme-builder/

My first introduction Link:
- https://kotlinlang.org/docs/multiplatform/compose-multiplatform-explore-composables.html#implementing-composable-functions

The App() function is a regular Kotlin function annotated with @Composable. Such functions are referred to as composable functions or simply composables. They are the building blocks of a UI based on Jetpack Compose or Compose Multiplatform.

Straight to the point video on jetpack compose
https://www.youtube.com/@CodeWithFK/playlists

# My Notes
Where the main class is located:
shared/commonMain/kotlin/com/example/myapplication/App.kt

(Gemini on Lambda syntax):

In Kotlin and Jetpack Compose (which Kotlin Multiplatform uses for UI), MaterialTheme {} is a trailing lambda expression.

```kotlin 
// How you write it:
MaterialTheme {
// your UI components go here
}
```

```kotlin 
// What Kotlin is actually doing:
MaterialTheme.apply(content = {
// your UI components go here
})
```

Video on Lambda syntax:
- https://www.youtube.com/watch?v=wnyN8umZIRM

In Java:
```java
list.filter((it)-> it % 2 == 0)
```

In Kotlin:
```kotlin
list.filter{ it % 2 == 0 }
```

*** Kotlin offers a special syntax for passing functions as parameters to functions, when the last parameter is a function. ***

^
Used heavily in Jetpack Compose

```kotlin
QuickNotesAppTheme
```
 is a composable, the last parameter named "content" is a function. The type of "content" is @Composable() () -> Unit

```kotlin
Column
```
is a composable, the last parameter is a function. The type of "content" is @Composable ColumnScope.() -> Unit

I think why they can contain child is because of the last parameter

Question: What is the below keywords?
```kotlin
var progress by mutableStateOf(1)
        private set

val question get() = questions[progress - 1]

var isNextEnabled by mutableStateOf(false)
        private set
```
by keyword explanation:
https://www.youtube.com/watch?v=qo-CrVZ8OwQ&t=59s

remember, by, and mutableStateOf explained:
https://www.youtube.com/watch?v=O-OSo4Z49po

More explanation of By:
https://stackoverflow.com/questions/38250022/what-does-by-keyword-do-in-kotlin

Question: What is the difference of by and = ?

# Google official tutorial
Composable introduction (Important):
- https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-text-composables#2

Jetpack Compose includes a wide range of built-in annotations, you have already seen @Composable and @Preview annotations so far in the course. You will learn more annotations and their usages in the latter part of the course.

Font size (Important)
- https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-text-composables&utm_source=android-studio-app&utm_medium=app#5

Arrange the text elements in a row and column (Important)
- https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-text-composables&utm_source=android-studio-app&utm_medium=app#7

The UI hierarchy is based on containment, meaning one component can contain one or more components, and the terms parent and child are sometimes used. The context here is that the parent UI elements contain children UI elements, which in turn can contain children UI elements. I

The three basic, standard layout elements in Compose are Column, Row, and Box composables. You learn more about the Box composable in the next codelab.

verticalArrangement, modifier, textAlign (Important)
- https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-text-composables&utm_source=android-studio-app&utm_medium=app#8

verticalArrangement = Arrangement.Center
modifier = modifier.padding(8.dp)
modifier = Modifier.padding(16.dp).align(alignment = Alignment.End)
textAlign = TextAlign.Center

Link (Important):
- https://developer.android.com/courses/pathways/jetpack-compose-for-android-developers-1

Link (Important)
- https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#6

To add internal state to a composable, you can use the mutableStateOf function, which makes Compose recompose functions that read that State.

Note: State and MutableState are interfaces that hold some value and trigger UI updates (recompositions) whenever that value changes.

```kotlin
import androidx.compose.runtime.mutableStateOf
// ...

// Don't copy over
@Composable
fun Greeting() {
    val expanded = mutableStateOf(false) // Don't do this!
}
```

However you can't just assign mutableStateOf to a variable inside a composable. As explained before, recomposition can happen at any time which would call the composable again, resetting the state to a new mutable state with a value of false.

To preserve state across recompositions, remember the mutable state using remember.

```kotlin
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
// ...

@Composable
fun Greeting(...) {
    val expanded = remember { mutableStateOf(false) }
    // ...
}
```

remember is used to guard against recomposition, so the state is not reset.

Note that if you call the same composable from different parts of the screen you will create different UI elements, each with its own version of the state. You can think of internal state as a private variable in a class.

The composable function will automatically be "subscribed" to the state. If the state changes, composables that read these fields will be recomposed to display the updates.

You can define the action to take on click by assigning a lambda expression to it. For example, let's toggle the value of the expanded state, and show a different text depending on the value.

```kotlin
ElevatedButton(
    onClick = { expanded.value = !expanded.value },
) {
   Text(if (expanded.value) "Show less" else "Show more")
}
```

When the button is clicked, expanded is toggled triggering a recomposition of the text inside the button. Each Greeting maintains its own expanded state, because they belong to different UI elements.

```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
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
```

Link (Important)
https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#7

In Composable functions, state that is read or modified by multiple functions should live in a common ancestor—this process is called state hoisting. To hoist means to lift or elevate.

Making state hoistable avoids duplicating state and introducing bugs, helps reuse composables, and makes composables substantially easier to test. Contrarily, state that doesn't need to be controlled by a composable's parent should not be hoisted. The source of truth belongs to whoever creates and controls that state.

*** This part is about putting the mutableStateOf() one level up from the compasable it is at ***


# Productivity Hack
Ask AI how to translate html tags to compose multiplatform code