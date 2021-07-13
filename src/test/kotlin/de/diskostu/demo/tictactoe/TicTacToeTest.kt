package de.diskostu.demo.tictactoe

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class TicTacToeTest {

    @Nested
    inner class ValidateInput {

        @ParameterizedTest
        @CsvSource("XXXOOOXXC", "XXXOOOXX")
        fun `should show invalid input`(input: String) {
            // arrange

            // act
            val ticTacToe = TicTacToe(input)

            // assert
            assertThrows<IllegalArgumentException> { ticTacToe.validateInput() }
            assertThatThrownBy { ticTacToe.validateInput() }
                .isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContainingAll("invalid", "input", input)
        }

        @Test
        fun `should show invalid input because empty`() {
            // arrange
            val input = " "

            // act
            val ticTacToe = TicTacToe(input)

            // assert
            assertThrows<IllegalArgumentException> { ticTacToe.validateInput() }
            assertThatThrownBy { ticTacToe.validateInput() }
                .isExactlyInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContainingAll("invalid", "input", input)
        }
    }


    @Nested
    inner class GenerateBoardString {

        @Test
        fun `should draw correct board`() {
            // arrange
            val input = "XXXOOO___"

            // act
            val boardString = TicTacToe(input).generateBoardString()

            // assert
            val expectedString = "---------\n| X X X |\n| O O O |\n| _ _ _ |\n---------"
            assertThat(boardString).isEqualTo(expectedString)
        }
    }


    @Nested
    inner class ValidateGameState {

        @ParameterizedTest
        @CsvSource("XXXOOO___", "___OOOXXX", "X_OX_OX_O", "XXXXXXXXO", "OOOOO_XXX")
        fun `should show impossible game state`(input: String) {
            // arrange

            // act
            val gameState = TicTacToe(input).validateGameState()

            // assert
            assertThat(gameState).isEqualTo("Impossible")
        }


        @ParameterizedTest
        @CsvSource("X__O____", "XX_X__OO_")
        fun `should show game not finished`(input: String) {
            // arrange

            // act
            val gameState = TicTacToe(input).validateGameState()

            // assert
            assertThat(gameState).isEqualTo("Game not finished")
        }


        @ParameterizedTest
        @CsvSource("XOXOOXXXO")
        fun `should show draw`(input: String) {
            // arrange

            // act
            val gameState = TicTacToe(input).validateGameState()

            // assert
            assertThat(gameState).isEqualTo("Draw")
        }


        @ParameterizedTest
        @CsvSource("XXXOO____", "X_O_X_O_X")
        fun `should show X wins`(input: String) {
            // arrange

            // act
            val gameState = TicTacToe(input).validateGameState()

            // assert
            assertThat(gameState).isEqualTo("X wins")
        }


        @ParameterizedTest
        @CsvSource("OOOXX____", "O_X_O_X_O")
        fun `should show O wins`(input: String) {
            // arrange

            // act
            val gameState = TicTacToe(input).validateGameState()

            // assert
            assertThat(gameState).isEqualTo("O wins")
        }
    }


    @Nested
    inner class GetThreeInARowCount {

        @ParameterizedTest
        @CsvSource(
            "XX_______",
            "____XX___",
            "_______XX",
            "X__X_____",
            "_X_____X_",
            "__X_____X",
            "____X___X",
            "____X_X__"
        )
        fun `should calculate correct 3 in a row count #0`(input: String) {
            // arrange

            // act
            val threeInARowCount = TicTacToe(input).getThreeInARowCount('X')

            // assert
            assertThat(threeInARowCount).isZero
        }

        @ParameterizedTest
        @CsvSource(
            "XXX______",
            "___XXX___",
            "______XXX",
            "X__X__X__",
            "_X__X__X_",
            "__X__X__X",
            "X___X___X",
            "__X_X_X__"
        )
        fun `should calculate correct 3 in a row count #1`(input: String) {
            // arrange

            // act
            val threeInARowCount = TicTacToe(input).getThreeInARowCount('X')

            // assert
            assertThat(threeInARowCount).isEqualTo(1)
        }

        @ParameterizedTest
        @CsvSource(
            "XXX___XXX",
            "XXXXXX___",
            "XXXX__X__",
            "XXX_X___X",
            "_XX_XX_XX",
            "__X_XXX_X",
        )
        fun `should calculate correct 3 in a row count #2`(input: String) {
            // arrange

            // act
            val threeInARowCount = TicTacToe(input).getThreeInARowCount('X')

            // assert
            assertThat(threeInARowCount).isEqualTo(2)
        }
    }


    @Nested
    inner class HasEmptyCells {

        @ParameterizedTest
        @CsvSource("_________", "XXXX XXXX")
        fun `should report that there are empty cells`(input: String) {
            // arrange

            // act
            val hasEmptyCells: Boolean = TicTacToe(input).hasEmptyCells()

            // assert
            assertThat(hasEmptyCells).isTrue
        }

        @ParameterizedTest
        @CsvSource("OOOXXXOOO", "XXXXXXXXX")
        fun `should report that there are no empty cells`(input: String) {
            // arrange

            // act
            val hasEmptyCells: Boolean = TicTacToe(input).hasEmptyCells()

            // assert
            assertThat(hasEmptyCells).isFalse
        }
    }
}
