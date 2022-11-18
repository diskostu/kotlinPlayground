package de.diskostu.demo.delegatedProperties

import java.util.*

val lazyValue: String by lazy {
    // the following lines are only executed ONCE, at first access to "lazyValue".
    // It's kind of an initialization block of "lazyValue".
    val temp = GregorianCalendar.getInstance()
    println("computed!")
    println("another line!")

    // the last line is responsible for creating and storing the previously initialized value in
    // "lazyValue"
    temp.toString()
}




fun main() {
    println(lazyValue)
    println(lazyValue)
}
