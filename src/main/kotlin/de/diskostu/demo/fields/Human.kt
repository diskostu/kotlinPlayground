package de.diskostu.demo.fields

class Human {
    // this is a property - not a field!
    // a property is a combination of a field and its accessors, all generated under the hood
    private var _age: Int = 0
    val age: Int
        get() = _age

    var name = ""
        private set


    private val _myList: MutableList<String> = mutableListOf()
    val myList: List<String> get() = _myList

    var myList2: List<String> = mutableListOf()
        get() = myList2.toList()
        private set

    private val myList3: MutableList<String> = mutableListOf()

    public fun getList3(): List<String> {
        myList3.add("lala")

        return myList3.toList()
    }
}


fun main() {
    val myHuman = Human()
    println("myHuman.age = ${myHuman.age}")
    // myHuman.age = 20

    println("myHuman.name = ${myHuman.name}")
    // myHuman.name = lala
}
