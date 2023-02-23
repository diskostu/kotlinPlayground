package de.diskostu.demo.codelab.kotlinfundamentals.practice

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}


class FoldablePhone(private var isFolded: Boolean = true) : Phone() {

    override fun switchOn() {
        if (!isFolded) super.switchOn()
    }

    fun foldPhone() {
        println("Folding the phone.")
        isFolded = true
        switchOff()
    }


    fun unfoldPhone() {
        println("Unfolding the phone.")
        isFolded = false
    }
}


fun main() {
    val myPhone = Phone()
    myPhone.checkPhoneScreenLight()
    myPhone.switchOn()
    myPhone.checkPhoneScreenLight()

    val myFoldablePhone = FoldablePhone()
    myFoldablePhone.checkPhoneScreenLight()
    myFoldablePhone.switchOn()
    myFoldablePhone.checkPhoneScreenLight()
    myFoldablePhone.unfoldPhone()
    myFoldablePhone.switchOn()
    myFoldablePhone.checkPhoneScreenLight()
    myFoldablePhone.foldPhone()
    myFoldablePhone.checkPhoneScreenLight()
}