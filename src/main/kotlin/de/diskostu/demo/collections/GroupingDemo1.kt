package de.diskostu.demo.association

fun main() {
    // https://kotlinlang.org/docs/collection-grouping.html

    val numbers = listOf("one", "two", "three", "four", "five", "six")

    println("1: " + numbers.groupBy { it.first().uppercase() })
    println(
        "2: " + numbers.groupBy(
            keySelector = { it.first() },
            valueTransform = { it.uppercase() })
    )

    val groupingBy = numbers.groupingBy { it.first() }
    val eachCount = groupingBy.eachCount()
    println("3: $eachCount")
}
