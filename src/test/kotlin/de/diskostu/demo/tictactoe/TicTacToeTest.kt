package de.diskostu.demo.tictactoe

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TicTacToeTest {

    @Nested
    inner class ValidateInput {
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
            assertThat(gameState).isEqualTo("")
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

    @Nested
    inner class GetCharForCoordinates {
        @ParameterizedTest
        @CsvSource("1,1,0", "1,2,1", "1,3,2", "2,1,3", "2,2,4", "2,3,5", "3,1,6", "3,2,7", "3,3,8")
        fun `should get correct char for coordinates`(vertical: Int, horizontal: Int, expectedIndex: Int) {
            // arrange

            // act
            val indexForCoordinates = TicTacToe("_________").getInputIndexForCoordinates(vertical, horizontal)

            // assert
            assertThat((indexForCoordinates == expectedIndex))
        }
    }


    @Nested
    inner class ValidateNextMove {

        @ParameterizedTest
        @CsvSource("one,one one")
        fun `should show that coordinates are not numeric`(input: String) {
            // arrange

            // act
            val validateNextMove = TicTacToe("XXXOOO___").validateNextMove(input)

            // assert
            assertThat(validateNextMove).isEqualTo("You should enter numbers!")
        }


        @ParameterizedTest
        @CsvSource("2 5,4 1,6 6")
        fun `should show the coordinates have the wrong values`(input: String) {
            // arrange

            // act
            val validateNextMove = TicTacToe("XXXOOO___").validateNextMove(input)

            // assert
            assertThat(validateNextMove).isEqualTo("Coordinates should be from 1 to 3!")
        }


        @ParameterizedTest
        @CsvSource("XXXOOO___,1 1", "XXXOOO___,2 1", "XXXOOO___,2 3", "XXXOOO__X,3 3")
        fun `should show that cell is occupied`(gameState: String, input: String) {
            // arrange

            // act
            val validateNextMove = TicTacToe(gameState).validateNextMove(input)

            // assert
            assertThat(validateNextMove).isEqualTo("This cell is occupied! Choose another one!")
        }
    }


    @Nested
    inner class UpdateGameState {

        @ParameterizedTest
        @CsvSource("XX_OO____,1 3,XXXOO____", "XX_OO____,2 3,XX_OOX___", "XX_OO____,3 3,XX_OO___X")
        fun `should `(gameState: String, nextMove: String, expectedGameState: String) {
            // arrange

            // act
            val ticTacToe = TicTacToe(gameState)
            ticTacToe.updateGameState(nextMove)

            // assert
            assertThat(ticTacToe.getGameState()).isEqualTo(expectedGameState)
        }
    }
}
