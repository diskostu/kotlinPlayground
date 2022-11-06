package de.diskostu.demo.filtering

fun main() {

    // predefined predicate
    val numbers = listOf(-1, 0, 2)
    val isZero: (Int) -> Boolean = { it == 0 }

    // use the predefined predicate. notice the function calls with "()" (parameter) instead of
    // "{}" (lambda)
    val lala1 = numbers.any(isZero)
    val lala2 = !numbers.all(isZero)
    val lala3 = numbers.count(isZero) == 1
    val lala4 = numbers.find { it > 0 } == 2

    // inline predicate
    val lala5 = numbers.any { it == 0 }

    // another example with strings
    val strings = listOf("hey", "you", "sucker")

    // predefined predicate
    val isLengthZero: (String) -> Boolean = { it.isEmpty() }
    val stringBoolean1 = strings.any(isLengthZero)

    // inline predicate
    val stringBoolean2 = strings.any { it.isEmpty() }
}
