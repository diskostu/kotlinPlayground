package de.diskostu.demo.codelab.kotlinfundamentals.classesandobjects

private const val VOL_MIN = 1
private const val VOL_MAX = 100
private const val CHANNEL_MIN = 1
private const val CHANNEL_MAX = 200

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume: Int = 2
        set(value) {
            if (value in VOL_MIN..VOL_MAX) field =
                value else println("Speaker max volume is $VOL_MAX.")
        }

    private var channelNumber: Int = CHANNEL_MIN
        set(value) {
            if (value in CHANNEL_MIN..CHANNEL_MAX) field =
                value else throw IllegalArgumentException("Channel number has to be between $CHANNEL_MIN and $CHANNEL_MAX (was $value).")
        }


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
    val lala = SmartTvDevice("My Smart TV", "Entertainment")

    lala.increaseSpeakerVolume()
    lala.increaseSpeakerVolume()
    lala.increaseSpeakerVolume()

    lala.nextChannel()
    lala.nextChannel()
    lala.nextChannel()

    lala.turnOff()
    lala.nextChannel()
    lala.increaseSpeakerVolume()
}