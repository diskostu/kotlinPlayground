package de.diskostu.demo.random

class Dice(val numSides: Int = 6, val color: String) {
    fun roll(): Int {
        return (1..numSides).random()
    }

    override fun toString(): String {
        return "$numSides sided, color is $color"
    }
}

fun main() {
    val myFirstDice = Dice(color = "blue")
    println("Your dice $myFirstDice rolled ${myFirstDice.roll()}!")

    val mySecondDice = Dice(numSides = 20, color = "red")
    println("Your dice $mySecondDice rolled ${mySecondDice.roll()}!")
}
