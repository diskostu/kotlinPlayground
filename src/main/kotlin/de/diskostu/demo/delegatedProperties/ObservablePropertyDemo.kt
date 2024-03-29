package de.diskostu.demo.delegatedProperties

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("<no name>") {
        property, oldValue, newValue ->
        println("${property.name}: $oldValue -> $newValue")
    }

}


fun main() {
    val user = User()
    user.name = "first"
    user.name = "second"
}
