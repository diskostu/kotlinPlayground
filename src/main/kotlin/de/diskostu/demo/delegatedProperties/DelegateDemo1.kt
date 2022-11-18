package de.diskostu.demo.delegatedProperties

import kotlin.reflect.KProperty

fun main() {
    val instance = DelegateDemo1()

    instance.p = "Some text"
    println("instance.p = ${instance.p}")
}


class DelegateDemo1 {
    var p: String by Delegate()
}


class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}
