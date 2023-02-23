package de.diskostu.demo.codelab.kotlinfundamentals.practice

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MovieTicketPriceKtTest {

    @ParameterizedTest
    @CsvSource(
        "0, true, 15", "12, false, 15",
        "13, false, 30", "13, true, 25", "60, false, 30", "60, true, 25",
        "61, true, 20", "61, false, 20", "100, true, 20", "100, false, 20"
    )
    fun `test movie prices`(age: Int, isMonday: Boolean, expectedTicketPrice: Int) {
        // arrange

        // act
        val ticketPrice = ticketPrice(age, isMonday)

        // assert
        assertThat(ticketPrice).isEqualTo(expectedTicketPrice)
    }
}