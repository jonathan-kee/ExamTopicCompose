# Resources to learn Kotlin UI
Link:
https://kotlinlang.org/docs/multiplatform/compose-multiplatform-create-first-app.html#examine-the-project-structure

Where the main class is located:
shared/commonMain/kotlin/com/example/myapplication/App.kt

Link:
https://kotlinlang.org/docs/multiplatform/compose-multiplatform-explore-composables.html#implementing-composable-functions

The App() function is a regular Kotlin function annotated with @Composable. Such functions are referred to as composable functions or simply composables. They are the building blocks of a UI based on Jetpack Compose or Compose Multiplatform.

Gemini on Lambda syntax:
In Kotlin and Jetpack Compose (which Kotlin Multiplatform uses for UI), MaterialTheme {} is a trailing lambda expression.

// How you write it:
MaterialTheme {
// your UI components go here
}

// What Kotlin is actually doing:
MaterialTheme.apply(content = {
// your UI components go here
})

Video on Lambda syntax:
https://www.youtube.com/watch?v=wnyN8umZIRM

In Java:
list.filter((it)-> it % 2 == 0)

In Kotlin:
list.filter{ it % 2 == 0 }

Link (Important):
https://developer.android.com/codelabs/basic-android-kotlin-compose-text-composables?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-text-composables#2

Jetpack Compose includes a wide range of built-in annotations, you have already seen @Composable and @Preview annotations so far in the course. You will learn more annotations and their usages in the latter part of the course.

Link (Important):
https://developer.android.com/courses/pathways/jetpack-compose-for-android-developers-1

# Productivity Hack
Ask AI how to translate html tags to compose multiplatform code