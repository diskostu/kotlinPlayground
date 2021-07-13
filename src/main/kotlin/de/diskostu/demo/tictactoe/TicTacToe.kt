package de.diskostu.demo.tictactoe

import kotlin.math.abs

fun main() {
    print("Enter cells: ")
    val ticTacToe = TicTacToe(readLine()!!)

    ticTacToe.validateInput()
    println(ticTacToe.generateBoardString())
    println(ticTacToe.validateGameState())
}

class TicTacToe(private val input: String) {

    // 01236
    private val validThreeInARow = listOf("012", "345", "678", "036", "147", "258", "048", "246")

    fun validateInput() {
        if (!input.matches(Regex("[XO_ ]{9}")))
            throw IllegalArgumentException("invalid input: $input")
    }


    fun generateBoardString(): String {
        var boardString = "---------\n"

        for (i in 0..2) {
            boardString += "| ${input[i * 3]} ${input[i * 3 + 1]} ${input[i * 3 + 2]} |\n"
        }

        return "$boardString---------"
    }


    fun validateGameState(): String {
        // impossible 1: far more X than O or vice versa
        val impossible1 = abs(input.count { it == 'X' } - input.count { it == 'O' }) > 1
        val impossible2 = getThreeInARowCount('X') == 1 && getThreeInARowCount('O') == 1
        if (impossible1 || impossible2) {
            return "Impossible"
        }

        if (getThreeInARowCount('X') == 0 && getThreeInARowCount('O') == 0) {
            return if (hasEmptyCells()) "Game not finished" else "Draw"
        }

        if (getThreeInARowCount('X') == 1) return "X wins"
        if (getThreeInARowCount('O') == 1) return "O wins"

        TODO("missed at least 1 condition: $input")
    }


    fun getThreeInARowCount(playerSign: Char): Int {

        val charArray = input.toCharArray()
        var indexString = ""
        for (i in 0..charArray.lastIndex) {
            if (charArray[i] == playerSign) {
                indexString += i
            }
        }

        var threeInARowCount = 0
        for (s in validThreeInARow) {
            val validRowAsArray = s.toCharArray()

            val matchCount = validRowAsArray.filter { it in indexString }.count()

            if (matchCount == 3) {
                threeInARowCount++
            }
        }

        return threeInARowCount
    }


    fun hasEmptyCells(): Boolean {
        // regex does not work - why?
        //return input.matches(Regex("[_ ]"))

        return input.contains("_") || input.contains(' ')
    }
}
