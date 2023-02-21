package de.diskostu.demo.codelab.kotlinfundamentals.classesandobjects

private const val VOL_MIN = 1
private const val VOL_MAX = 100
private const val CHANNEL_MIN = 1
private const val CHANNEL_MAX = 200

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(2, 0, 100)
    private var channelNumber by RangeRegulator(1, 1, 200)


    override fun turnOn() {
        super.turnOn()

        channelNumber = 1
        speakerVolume = 10
        println("Channel is $channelNumber and volume level is at $speakerVolume.")
    }


    fun increaseSpeakerVolume() {
        if (deviceStatus == DEVICE_STATUS_OFF) {
            println("Cannot increase volume because $name is turned off. Turn it on first.")
            return
        }

        if (speakerVolume == VOL_MAX) {
            println("Speaker volume is already max ($VOL_MAX).")
            return
        }

        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }


    fun nextChannel() {
        if (deviceStatus == DEVICE_STATUS_OFF) {
            println("Cannot switch to the next channel because $name is turned off. Turn it on first.")
            return
        }

        if (channelNumber == CHANNEL_MAX) {
            channelNumber = CHANNEL_MIN
            println("Was at last channel, switched to channel $CHANNEL_MIN.")
            return
        }

        channelNumber++
        println("Current channel is now $channelNumber.")
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
