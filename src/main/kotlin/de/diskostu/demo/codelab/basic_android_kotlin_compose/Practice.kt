package de.diskostu.demo.codelab.basic_android_kotlin_compose

data class Event(
    val title: String,
    val description: String?,
    val daypart: String,
    val duration: Int
)

fun main() {
    val myEvent = Event(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        "Evening",
        15
    )

    println("myEvent = $myEvent")
}