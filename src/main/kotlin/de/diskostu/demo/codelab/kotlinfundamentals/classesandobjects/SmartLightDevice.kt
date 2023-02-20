package de.diskostu.demo.codelab.kotlinfundamentals.classesandobjects

const val brightnessMin = 0
const val brightnessMax = 100

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel = brightnessMin
        set(value) {
            if (value in brightnessMin..brightnessMax) {
                field = value
            }
        }


    override fun turnOn() {
        super.turnOn()

        brightnessLevel = 2
        println("Brightness level is at $brightnessLevel.")
    }


    override fun turnOff() {
        super.turnOff()

        brightnessLevel = 0
    }

    fun increaseBrightness() {
        if (brightnessLevel == brightnessMax) {
            println("Brightness level is already max ($brightnessMax).")
            return
        }

        brightnessLevel++
        println("Brightness level increased to $brightnessLevel.")
    }


    fun setMaxBrightness() {
        brightnessLevel = brightnessMax

        println("Brightness level is set to max value ($brightnessMax).")
    }
}


fun main() {
    val myLight = SmartLightDevice("My super bulb", "Lighting device")

    myLight.increaseBrightness()
    myLight.setMaxBrightness()
    myLight.increaseBrightness()
}