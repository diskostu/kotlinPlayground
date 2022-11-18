package de.diskostu.demo.scope

import kotlin.random.Random


data class Person(var name: String, var age: Int, var city: String) {
    fun moveTo(newCity: String) {
        city = newCity
    }

    fun incrementAge() {
        age++
    }
}

fun main() {
    // https://kotlinlang.org/docs/scope-functions.html#function-selection
    println("let")
    Person("Alice", 20, "Amsterdam").let {
        println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }
    println()

    println("run")
    Person("Alice", 20, "Amsterdam").run {
        println(this)
        this.moveTo("London")
        this.incrementAge()
        println(this)
    }
    println()

    println("with")
    with(Person("Alice", 20, "Amsterdam")) {
        println(this)
        this.moveTo("London")
        this.incrementAge()
        println(this)
    }
    println()

    println("apply")
    val apply = Person("Alice", 20, "Amsterdam").apply {
        println(this)
        this.moveTo("London")
        this.incrementAge()
        println(this)
    }
    println()

    println("also")
    val also = Person("Alice", 20, "Amsterdam").also {
        println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }


    val numberList = mutableListOf<Double>()
    numberList.also { println("Populating the list") }
        .apply {
            add(2.71)
            add(3.14)
            add(1.0)
        }
        .also { println("Sorting the list") }
        .sort()
    println("numberList = $numberList")


    val number = Random.nextInt(100)

    val evenOrNull = number.takeIf { it % 2 == 0 }
    val oddOrNull = number.takeUnless { it % 2 == 0 }
    println("even: $evenOrNull, odd: $oddOrNull")
}
