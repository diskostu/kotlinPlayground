package de.diskostu.demo.filtering

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val (match, rest) = numbers.partition { it.length > 3 }

    // "match" contains the matching entries, "rest" the... rest :)
    println(match)
    println(rest)
}
