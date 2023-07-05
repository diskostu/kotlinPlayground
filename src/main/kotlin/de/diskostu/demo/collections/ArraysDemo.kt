package de.diskostu.demo.collections

fun main() {
    val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

    val solarSystem = rockPlanets + gasPlanets
    solarSystem.forEach {
        println(it)
    }

    solarSystem[3] = "Little Earth (fka Mars)"
    println(solarSystem[3])

    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
    newSolarSystem.forEach {
        println(it)
    }
}