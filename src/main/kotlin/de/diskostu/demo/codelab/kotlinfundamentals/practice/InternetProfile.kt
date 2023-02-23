package de.diskostu.demo.codelab.kotlinfundamentals.practice

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}


class Person(private val name: String, private val age: Int, private val hobby: String?, private val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        print("Likes to $hobby. ")
        println(
            if (referrer == null) "Doesn't have a referrer."
            else "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}."
        )
    }
}