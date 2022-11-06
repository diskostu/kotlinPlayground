package de.diskostu.demo.filtering

fun main() {
    val numbers = listOf(6, 42, 10, 4)
    println("numbers = $numbers")

    println("Count: ${numbers.count()}")
    println("Max: ${numbers.maxOrNull()}")
    println("Min: ${numbers.minOrNull()}")
    println("Average: ${numbers.average()}")
    println("Sum: ${numbers.sum()}")


    val min3Remainder = numbers.minByOrNull { it % 3 }
    println("min3Remainder = $min3Remainder")

    val strings = listOf("one", "two", "three", "four")
    val longestString = strings.maxWithOrNull(compareBy { it.length })
    println("longestString = $longestString")
}

