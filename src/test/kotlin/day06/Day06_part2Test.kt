package day06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import readTestInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day06_part2Test {

    @Test
    fun `from test input`() {
        val day = 6
        val testPuzzleInput = readTestInput(day)

        val result = solvePuzzlePart2(testPuzzleInput)

        assertThat(result).isEqualTo(3263827L)
    }

    @Test
    fun getSeparatorIndexesTest() {
        val input = """
            123 33  45
            1   1   1
            12   2  12
            333 333 123
        """.trimIndent().split('\n')

        assertThat(getSeparatorIndexes(input)).isEqualTo(listOf(3, 7))
    }

    @Test
    fun test1() {
        val input = listOf(
            ""
        )
        val result = solvePuzzlePart2(input)

        assertEquals(1L, result)
    }

    @ParameterizedTest
    @CsvSource(
        "11,2",
        "32,4"
    )
    fun test2(input: String, expectedOutput: Long) {
        val inputList = listOf(input)

        val result = solvePuzzlePart2(inputList)

        assertEquals(expectedOutput, result)
    }

}