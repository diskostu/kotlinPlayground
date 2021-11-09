package de.diskostu.demo.abstractDemos

/**
 * sample code for codelab https://developer.android.com/codelabs/basic-android-kotlin-training-classes-and-inheritance
 *
 */

fun main() {

    val myCabin = SquareCabin(10)

    with(myCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
    }

    val roundHut = RoundHut(3)

    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
    }

    val roundTower = RoundTower(4)
    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: $buildingMaterial")
        println("Floors: $floors")
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
}

class SquareCabin(private var residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun toString(): String {
        return "SquareCabin(residents=$residents, buildingMaterial='$buildingMaterial', capacity=$capacity)"
    }
}

open class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
}

class RoundTower(residents: Int, val floors: Int = 2) : RoundHut(residents) {
    override val capacity = super.capacity * floors
}
