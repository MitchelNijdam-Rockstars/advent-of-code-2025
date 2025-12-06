package day06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import readTestInput
import kotlin.test.Test

class Day06_part1Test {

    @Test
    fun `from test input`() {
        val day = 6
        val testPuzzleInput = readTestInput(day)

        val result = solvePuzzlePart1(testPuzzleInput)

        assertThat(result).isEqualTo(4277556L)
    }

    @Test
    fun test1() {
        val input = listOf(
            ""
        )
        val result = solvePuzzlePart1(input)

        assertThat(result).isEqualTo(0L)
    }


    @ParameterizedTest
    @CsvSource(
        "11,2",
        "32,4"
    )
    fun test2(input: String, expectedOutput: Long) {
        val inputList = listOf(input)

        val result = solvePuzzlePart1(inputList)

        assertThat(result).isEqualTo(expectedOutput)
    }

}