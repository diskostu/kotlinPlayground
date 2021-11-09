package de.diskostu.demo.abstractDemos

fun main() {

    val myCabin = SquareCabin(10)

    with(myCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
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

class SquareCabin(var residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun toString(): String {
        return "SquareCabin(residents=$residents, buildingMaterial='$buildingMaterial', capacity=$capacity)"
    }


}
