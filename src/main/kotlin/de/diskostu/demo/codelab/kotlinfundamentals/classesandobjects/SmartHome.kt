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

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
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


    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}