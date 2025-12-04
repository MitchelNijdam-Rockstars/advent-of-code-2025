package day04

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
import kotlin.test.assertEquals

class Day04_part1Test {

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
        "11,2",
        "32,4"
    )
    fun test2(input: String, expectedOutput: Long) {
        val inputList = listOf(input)

        val result = solvePuzzlePart1(inputList)

        assertEquals(expectedOutput, result)
    }

}