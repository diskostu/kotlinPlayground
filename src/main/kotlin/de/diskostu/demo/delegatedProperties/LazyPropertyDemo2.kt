package de.diskostu.demo.delegatedProperties

class LazyProperty(val initializer: (String) -> Int) {
    val lazyValue1: Int by lazy {
        initializer("hey")
    }

    val lazyValue2: Int by lazy {
        initializer("that's cool")
    }
}


fun main() {
    val instance1 = LazyProperty {
        it.length
    }

    val instance2 = LazyProperty {
        it.length * it.length
    }



    println("lazyProperty1.lazyValue1 = ${instance1.lazyValue1}")
    println("lazyProperty1.lazyValue2 = ${instance1.lazyValue2}")

    println()

    println("lazyProperty2.lazyValue1 = ${instance2.lazyValue1}")
    println("lazyProperty2.lazyValue2 = ${instance2.lazyValue2}")
}
