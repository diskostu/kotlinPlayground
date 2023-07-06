package de.diskostu.demo.codelab.basic_android_kotlin_compose

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: DayPart,
    val durationInMinutes: Int
)

enum class DayPart {
    MORNING, AFTERNOON, EVENING
}

fun main() {
    val myEvent = Event(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        DayPart.EVENING,
        15
    )

    println("myEvent = $myEvent")

    val event1 =
        Event(title = "Wake up", description = "Time to get up", daypart = DayPart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = DayPart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = DayPart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = DayPart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = DayPart.AFTERNOON, durationInMinutes = 10)
    val event6 =
        Event(title = "Check out latest Android Jetpack library", daypart = DayPart.EVENING, durationInMinutes = 45)

    val events = mutableListOf(event1, event2, event3, event4, event5, event6)

    val shortEvents = events.filter {
        it.durationInMinutes < 60
    }
    println("shortEvents = $shortEvents")

    // task 5
    events.groupBy {
        it.daypart
    }.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }

    // task 6
    println("Last event of the day: ${events.last().title}")
}