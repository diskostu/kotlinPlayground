package de.diskostu.demo.codelab.kotlinfundamentals.classesandobjects

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }


    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }


    fun turnOnLight() {
        smartLightDevice.turnOn()
    }


    fun turnOffLight() {
        smartLightDevice.turnOff()
    }


    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }


    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}