package de.diskostu.demo.filtering

fun main() {
    val numbers = listOf("one", "two", "three", "four")

    println("01: " + numbers.any { it.endsWith("e") })
    println("02: " + numbers.none { it.endsWith("a") })
    println("03: " + numbers.all { it.endsWith("e") })
    println("04: " + emptyList<Int>().all { it > 5 })   // vacuous truth


    val empty = emptyList<String>()

    println("05: " + numbers.any())
    println("06: " + empty.any())

    println("07: " + numbers.none())
    println("08: " + empty.none())

    println("09: " + numbers.count())

    // "find" returns the first element matching the given predicate. result may be null.
    println("10: " + numbers.find { s -> s.length > 3 })
}
