package de.diskostu.demo.collections

val numbersSequence1 = sequenceOf("four", "three", "two", "one")

val numbers = listOf("one", "two", "three", "four")
val numbersSequence2 = numbers.asSequence()


fun main() {
    val oddNumbersInfinite = generateOddNumbersInfinite()
    println("oddNumbersInfinite first 5 elements = ${oddNumbersInfinite.take(5).toList()}")
//    println(oddNumbersInfinite.count())     // error: the sequence is infinite

    val oddNumbersLessThan10 = generateOddNumbersLessThan10()
    println("oddNumbersLessThan10 = ${oddNumbersLessThan10.toList()}")

    val oddNumbersWithYield = generateOddNumbersWithYield()
    println("lala = ${oddNumbersWithYield.take(10).toList()}")
}


fun generateOddNumbersInfinite(): Sequence<Int> {
    return generateSequence(1) { it + 2 } // `it` is the previous element
}

fun generateOddNumbersLessThan10(): Sequence<Int> {
    return generateSequence(1) { if (it < 8) it + 2 else null }
}

fun generateOddNumbersWithYield(): Sequence<Int> {
    return sequence {
        yield(1)
        yield(3)
        yieldAll(listOf(5, 7))
        yieldAll(generateSequence(9) { it + 2 })
    }
}
