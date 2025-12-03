package day03

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03_part2Test {

    @Test
    fun test1() {
        val input = listOf(
            "987654321111111"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(987654321111L, result)
    }

    @ParameterizedTest
    @CsvSource(
        "987654321111111,987654321111",
        "811111111111119,811111111119",
        "234234234234278,434234234278",
        "818181911112111,888911112111",
        "111111111111111,111111111111",
        "000000000000000,0",
        "000000000000099,99",
        "00000000000009009,9009",
        "00001000000009009,100000009009",
    )
    fun test2(input: String, expectedOutput: Long) {
        val inputList = listOf(input)

        val result = solvePuzzlePart2(inputList)

        assertEquals(expectedOutput, result)
    }

}