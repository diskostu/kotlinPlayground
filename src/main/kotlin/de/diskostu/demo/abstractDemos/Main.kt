package de.diskostu.demo.abstractDemos

import kotlin.math.PI
import kotlin.math.sqrt

/**
 * sample code for codelab https://developer.android.com/codelabs/basic-android-kotlin-training-classes-and-inheritance
 *
 */

fun main() {

    val myCabin = SquareCabin(10, 50.0)

    with(myCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
    }

    val roundHut = RoundHut(3, 10.0)

    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
        println("Has room? ${hasRoom()}")
        getNewRoom()
        println("Has room? ${hasRoom()}")
        getNewRoom()
    }

    val roundTower = RoundTower(4, 2, 20.0)
    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: $buildingMaterial")
        println("Floors: $floors")
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
    }
}

abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return capacity > residents
    }

    abstract fun floorArea(): Double

    fun getNewRoom() {
        if (hasRoom()) {
            residents++
            println("New resident: now $residents residents.")
        } else {
            println("Unfortunately, there is no room left.")
        }
    }
}

class SquareCabin(private var residents: Int, private val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6
    override fun floorArea(): Double {
        return length * length
    }

    override fun toString(): String {
        return "SquareCabin(residents=$residents, buildingMaterial='$buildingMaterial', capacity=$capacity)"
    }
}

open class RoundHut(residents: Int, private val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetSize(): Double {
        val diameter = radius * 2
        return sqrt(diameter * diameter / 2)
    }
}

class RoundTower(residents: Int, val floors: Int = 2, radius: Double) : RoundHut(residents, radius) {
    override val capacity = super.capacity * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}
