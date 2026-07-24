Link:
https://kotlinlang.org/docs/multiplatform/compose-multiplatform-create-first-app.html#examine-the-project-structure

Where the main class is located:
shared/commonMain/kotlin/com/example/myapplication/App.kt

Link:
https://kotlinlang.org/docs/multiplatform/compose-multiplatform-explore-composables.html#implementing-composable-functions

The App() function is a regular Kotlin function annotated with @Composable. Such functions are referred to as composable functions or simply composables. They are the building blocks of a UI based on Jetpack Compose or Compose Multiplatform.

Gemini:
In Kotlin and Jetpack Compose (which Kotlin Multiplatform uses for UI), MaterialTheme {} is a trailing lambda expression.

// How you write it:
MaterialTheme {
// your UI components go here
}

// What Kotlin is actually doing:
MaterialTheme.apply(content = {
// your UI components go here
})

Link:
https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-text-composables#2


