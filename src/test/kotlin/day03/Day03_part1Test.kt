package day03

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03_part1Test {

    @Test
    fun test1() {
        val input = listOf(
            ""
        )
        val result = solvePuzzlePart1(input)

        assertEquals(1L, result)
    }


    @ParameterizedTest
    @CsvSource(
        "987654321111111,98",
        "811111111111119,89",
        "234234234234278,78",
        "818181911112111,92",
        "111111111111111,11",
        "000000000000000,00",
        "000000000000099,99",
    )
    fun test2(input: String, expectedOutput: Long) {
        val inputList = listOf(input)

        val result = solvePuzzlePart1(inputList)

        assertEquals(expectedOutput, result)
    }

}