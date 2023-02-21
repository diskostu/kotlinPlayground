package de.diskostu.demo.codelab.kotlinfundamentals.classesandobjects

class SmartHome(
    private val smartTvDevice: SmartTvDevice,
    private val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        smartTvDevice.turnOn()
        deviceTurnOnCount++
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
        deviceTurnOnCount--
    }


    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }


    fun decreaseTvVolume() {
        smartTvDevice.decreaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }


    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }


    fun turnOnLight() {
        smartLightDevice.turnOn()
        deviceTurnOnCount++
    }


    fun turnOffLight() {
        smartLightDevice.turnOff()
        deviceTurnOnCount--
    }


    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }


    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }


    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

fun main() {
    val mySmartHome = SmartHome(
        SmartTvDevice("My Smart TV", "Entertainment"),
        SmartLightDevice("My Smart Lamp", "Lighting")
    )

    println("Currently, there are ${mySmartHome.deviceTurnOnCount} devices turned on.")

    mySmartHome.turnOnTv()
    mySmartHome.turnOnLight()

    mySmartHome.changeTvChannelToNext()

    println("Currently, there are ${mySmartHome.deviceTurnOnCount} devices turned on.")

}
