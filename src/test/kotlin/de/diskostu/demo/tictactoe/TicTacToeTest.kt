package de.diskostu.demo.tictactoe

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class TicTacToeTest {

    @ParameterizedTest
    @CsvSource("XXXOOOXXC", "XXXOOOXX")
    fun `should show invalid input`(input: String) {
        // arrange

        // act
        val ticTacToe = TicTacToe(input)

        // assert
        assertThrows<IllegalArgumentException> { ticTacToe.validateInput() }
        Assertions.assertThatThrownBy { ticTacToe.validateInput() }
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
        Assertions.assertThatThrownBy { ticTacToe.validateInput() }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContainingAll("invalid", "input", input)
    }


    @Test
    fun `should draw correct board`() {
        // arrange
        val input = "XXXOOO___"

        // act
        val boardString = TicTacToe(input).generateBoardString()

        // assert
        val expectedString = "---------\n| X X X |\n| O O O |\n| _ _ _ |\n---------"
        Assertions.assertThat(boardString).isEqualTo(expectedString)
    }
}
