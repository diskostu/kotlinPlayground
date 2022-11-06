package de.diskostu.demo.collections

fun main() {
    val numbers = listOf("one", "two", "three", "four")

    // "associateWith" builds a map: key is the value from the collection, value is made from a
    // given transformation
    println("1: " + numbers.associateWith { it.length })
    // alternative code, does the same
    println("2: " + numbers.associateWith(valueSelector = { it.length }))


    // "associateBy" builds a map: key is made from a given transformation, value can be either
    // the collection value, or also be made from a transformation.
    // in this example, "two" never enters the map, because only the last element of the original
    // collection which matches the given key transformation stays in the map.

    // value taken from the collection
    println("3: " + numbers.associateBy { it.first().uppercaseChar() })
    // alternative code, does the same
    println("4: " +
        numbers.associateBy(
            keySelector = { it.first().uppercaseChar() }
        ))

    // value produced by a transformation
    println("5: " +
        numbers.associateBy(
            keySelector = { it.first().uppercaseChar() },
            valueTransform = { it.length })
    )

    // examples of "associate"

    // example 1
    println("6: " + numbers.associate { it.first().uppercase() to it.length })

    // example 2
    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    val transform: (String) -> Pair<String, String> =
        { name -> parseFullName(name).run { lastName to firstName } }
    println("7: " + names.associate(transform))
}

data class FullName(val firstName: String, val lastName: String)

fun parseFullName(fullName: String): FullName {
    val nameParts = fullName.split(" ")
    if (nameParts.size == 2) {
        return FullName(nameParts[0], nameParts[1])
    } else throw Exception("Wrong name format")
}
