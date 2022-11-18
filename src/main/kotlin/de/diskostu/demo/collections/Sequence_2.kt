package de.diskostu.demo.collections

// https://kotlinlang.org/docs/sequences.html

fun main() {
    val demoWithIterable = demoWithIterable()
    println("Lengths of first 4 words longer than 3 chars:")
    println(demoWithIterable)

    println()

    val demoWithSequence = demoWithSequence()
    println("Lengths of first 4 words longer than 3 chars")
    // terminal operation: obtaining the result as a List
    println(demoWithSequence.toList())
}

/**
 * The output shows that processing starts immediately. Every element of the list is processed
 * with "filter" and "map", and finally "take" takes 4 elements.
 */
fun demoWithIterable(): List<Int> {
    val words = "The quick brown fox jumps over the lazy dog".split(" ")

    return words
        .filter { println("filter: $it"); it.length > 3 }
        .map { println("map length: ${it.length}"); it.length }
        .take(4)
}

/**
 * The output shows that processing does NOT start while creating the sequence. It starts when
 * the final result is requested (in the "de.diskostu.demo.delegatedProperties.main"-method). It is also visible that each element of
 * the sequence is processed with the functions "filter", "map" and "take", and only then the
 * next element is processed. Processing stops when 4 elements were taken, the rest of the
 * sequence will be ignored.
 *
 * See the above official documentation for good diagrams on processing.
 *
 * So: a Sequence can bring better performance with huge lists, an Iterable can bring better
 * performance on small lists.
 */
fun demoWithSequence(): Sequence<Int> {
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    //convert the List to a Sequence
    val wordsSequence = words.asSequence()

    return wordsSequence
        .filter { println("filter: $it"); it.length > 3 }
        .map { println("map length: ${it.length}"); it.length }
        .take(4)
}
