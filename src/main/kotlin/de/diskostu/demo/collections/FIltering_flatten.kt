package de.diskostu.demo.filtering

fun main() {
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))

    println("numberSets = $numberSets")
    println(numberSets.flatten())


    val containers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println("containers = $containers")
    println(containers.flatMap { it.values })
}

data class StringContainer(val values: List<String>)
