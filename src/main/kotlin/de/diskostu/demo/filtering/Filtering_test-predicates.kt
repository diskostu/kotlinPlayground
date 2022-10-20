package de.diskostu.demo.filtering

fun main() {
    val numbers = listOf("one", "two", "three", "four")

    println("1: " + numbers.any { it.endsWith("e") })
    println("2: " + numbers.none { it.endsWith("a") })
    println("3: " + numbers.all { it.endsWith("e") })
    println("4: " + emptyList<Int>().all { it > 5 })   // vacuous truth


    val empty = emptyList<String>()

    println("5: " + numbers.any())
    println("6: " + empty.any())

    println("7: " + numbers.none())
    println("8: " + empty.none())
}
