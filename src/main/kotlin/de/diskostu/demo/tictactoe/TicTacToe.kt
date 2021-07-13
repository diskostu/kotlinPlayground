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
        if (abs(input.count { it == 'X' } - input.count { it == 'O' }) > 1) {
            return "Impossible"
        }

        if ()



        TODO("check more conditions")
    }

    fun threeInARow(gameString: CharArray, playerSign: Char): Int {

        // XXX______ 012
        // ___XXX___ 345
        // ______XXX 678
        // X__X__X__ 036
        // _X__X__X_ 147
        // __X__X__X 258
        // X___X___X 048
        // __X_X_X__ 246

        // OXXXOOXXO
        // OXX
        // X00
        // XXO

        return 0
    }
}
