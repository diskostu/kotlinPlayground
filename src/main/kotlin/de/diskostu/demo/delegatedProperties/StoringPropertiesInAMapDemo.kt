package de.diskostu.demo.delegatedProperties

data class User2(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
    val hometown: String by map
}


fun main() {
    val user = User2(
        // we could as many key-value pairs as we want, but it only makes sense to use keys that
        // correspond with the declared properties in User2.
        mapOf(
            "name" to "John Doe",
            "age" to 25,
            "fdf" to "dsfsdf",
            "fsdfs" to 13
        )
    )

    println("user = $user")
    println("user.name = ${user.name}")
    println("user.age = ${user.age}")

    // won't work, because "hometown" was not added in the above "mapOf" statement
    //println("user.hometown = ${user.hometown}")
}
