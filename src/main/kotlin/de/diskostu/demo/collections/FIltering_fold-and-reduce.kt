package de.diskostu.demo.filtering

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
}

