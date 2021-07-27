package de.diskostu.demo.tictactoe

import java.lang.IllegalStateException
import kotlin.math.abs

fun main() {
    print("Enter cells: ")
    val ticTacToe = TicTacToe(readLine()!!)

    ticTacToe.validateInput()
    println(ticTacToe.generateBoardString())

    val gameState = ticTacToe.validateGameState()
    if (gameState.isNotBlank()) println(gameState)

    var nextMove: String
    do {
        print("Enter the coordinates: ")
        nextMove = readLine()!!
        val validatedMove = ticTacToe.validateNextMove(nextMove)
        if(validatedMove.isNotBlank()) println(validatedMove)
    } while (validatedMove.isNotBlank())

    ticTacToe.updateGameState(nextMove)

    println(ticTacToe.generateBoardString())
}

class TicTacToe(private var gameState: String) {

    private val validThreeInARow = listOf("012", "345", "678", "036", "147", "258", "048", "246")

    fun validateInput() {
        if (!gameState.matches(Regex("[XO_ ]{9}")))
            throw IllegalArgumentException("invalid input: $gameState")
    }


    fun validateGameState(): String {
        // impossible 1: far more X than O or vice versa
        val impossible1 = abs(gameState.count { it == 'X' } - gameState.count { it == 'O' }) > 1
        val impossible2 = getThreeInARowCount('X') == 1 && getThreeInARowCount('O') == 1
        if (impossible1 || impossible2) {
            return "Impossible"
        }

        if (getThreeInARowCount('X') == 0 && getThreeInARowCount('O') == 0) {
            return if (hasEmptyCells()) "" else "Draw"
        }

        if (getThreeInARowCount('X') == 1) return "X wins"
        if (getThreeInARowCount('O') == 1) return "O wins"

        throw IllegalStateException("missed at least 1 condition: $gameState")
    }


    fun generateBoardString(): String {
        var boardString = "---------\n"

        for (i in 0..2) {
            boardString += "| ${gameState[i * 3]} ${gameState[i * 3 + 1]} ${gameState[i * 3 + 2]} |\n"
        }

        return "$boardString---------"
    }


    fun validateNextMove(nextMoveFromUser: String): String {
        val newCoordinates = nextMoveFromUser.split(" ")

        var isOnlyDigits = true
        newCoordinates.forEach {
            if (it.all { !it.isDigit() }) {
                isOnlyDigits = false
            }
        }
        if (!isOnlyDigits) {
            return "You should enter numbers!"
        }

        val (vertical, horizontal) = newCoordinates
        if (vertical !in "123" || horizontal !in "123") {
            return "Coordinates should be from 1 to 3!"
        }

        val indexForCoordinates = getInputIndexForCoordinates(vertical.toInt(), horizontal.toInt())
        if (gameState[indexForCoordinates] !in "_ ") {
            return "This cell is occupied! Choose another one!"
        }

        return ""
    }


    fun updateGameState(nextMoveFromUser: String) {
        val map = nextMoveFromUser.split(" ").map { it.toInt() }
        val toCharArray = gameState.toCharArray()
        toCharArray[getInputIndexForCoordinates(map[0], map[1])] = 'X'
        gameState = toCharArray.concatToString()
    }


    fun getGameState():String {
        return gameState
    }


    fun getThreeInARowCount(playerSign: Char): Int {

        val charArray = gameState.toCharArray()
        var indexString = ""
        for (i in 0..charArray.lastIndex) {
            if (charArray[i] == playerSign) {
                indexString += i
            }
        }

        var threeInARowCount = 0
        for (s in validThreeInARow) {
            val validRowAsArray = s.toCharArray()

            val matchCount = validRowAsArray.count { it in indexString }

            if (matchCount == 3) {
                threeInARowCount++
            }
        }

        return threeInARowCount
    }


    fun hasEmptyCells(): Boolean {
        // regex does not work - why?
        //return input.matches(Regex("[_ ]"))

        return gameState.contains("_") || gameState.contains(' ')
    }

    fun getInputIndexForCoordinates(vertical: Int, horizontal: Int): Int {
        return (vertical - 1) * 3 + horizontal - 1
    }
}
