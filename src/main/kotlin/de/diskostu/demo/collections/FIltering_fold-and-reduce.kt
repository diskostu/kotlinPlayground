package de.diskostu.demo.collections

fun main() {
    val numbers = listOf(5, 2, 10, 4)

    val reduceSum = numbers.reduce { sum, element -> sum + element }
    println("simpleSum = $reduceSum")
    val reduceProduct = numbers.reduce { one, two -> one * two }
    println("simpleProduct = $reduceProduct")

    val foldSumBy2 = numbers.fold(0) { sum, element -> sum + element * 2 }
    println("sumDoubled = $foldSumBy2")
    val foldSumWithInitialValue = numbers.fold(10) { one, two -> one * two }
    println("foldSumWithInitialValue = $foldSumWithInitialValue")

    //incorrect: the first element isn't doubled in the result
//    val sumDoubledReduce = numbers.reduce { sum, element -> sum + element * 2 }
//    println(sumDoubledReduce)


    println()
    println()
    println()


    val items = 1..5

    // Lambdas are code blocks enclosed in curly braces.
    items.fold(0) {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    }

    // Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:") { acc, i -> "$acc $i" }

    // Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)

    println("joinedToString = $joinedToString")
    println("product = $product")
}

