package de.diskostu.demo.codelab.kotlinfundamentals.classesandobjects

const val DEVICE_STATUS_ON = "online"
const val DEVICE_STATUS_OFF = "offline"


fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("My smart TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("My smart Light", "Lighting")
    smartDevice.turnOn()
}

open class SmartDevice protected constructor(val name: String, val category: String) {

    var deviceStatus: String = DEVICE_STATUS_ON
        protected set

    open val deviceType = "unknown"

    // example for a secondary constructor
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> DEVICE_STATUS_OFF
            1 -> DEVICE_STATUS_ON
            else -> "unknown"
        }
    }


    open fun turnOn() {
        deviceStatus = DEVICE_STATUS_ON
        println("$name is turned on.")
    }

    open fun turnOff() {
        deviceStatus = DEVICE_STATUS_OFF
        println("$name is turned off.")
    }

    fun printStatus() {
        println("The device \"$name\" has the status \"$deviceStatus\".")
    }
}
