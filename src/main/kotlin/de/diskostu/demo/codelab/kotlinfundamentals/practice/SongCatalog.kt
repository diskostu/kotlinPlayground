package de.diskostu.demo.codelab.kotlinfundamentals.practice

data class SongCatalog(val title: String, val artist: String, val year: Int) {

    var playCount = 0

    val isPopular: Boolean
        get() {
            return playCount > 1000
        }

    fun printSongDescription() {
        println("$title, performed by $artist, was released in $year.")
        println("It is " + (if (!isPopular) "not " else "") + "very popular.")
    }
}


fun main() {
    val mySong = SongCatalog("In the summertime", "Mungo Jerry", 1965)

    mySong.printSongDescription()
}