package de.diskostu.demo.fields

class ListWithBackingProperty {
    private val _myList: MutableList<String> = mutableListOf()
    val myList: List<String> get() = _myList
}

fun main2() {
    val list = ListWithBackingProperty().myList
}

class ListWithGetter {
    private val myList: MutableList<String> = mutableListOf()

    fun getMyList(): List<String> = myList.toList()
}

fun main() {
    val list = ListWithGetter().getMyList()
}
