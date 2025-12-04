package day04

import SRC_PATH
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class Day04_part2Test {

    @Test
    fun `from test input`() {
        val testContent = File("$SRC_PATH/day04/Day04_values_test.txt").readText()
        val testPuzzleInput = testContent.split('\n')

        val result = solvePuzzlePart2(testPuzzleInput)

        assertThat(result).isEqualTo(43)
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

    @Nested
    inner class GetAndRemoveAccessiblePaperRolls {

        @Test
        fun test1() {
            val testContent = File("$SRC_PATH/day04/Day04_values_test.txt").readText()
            val testPuzzleInput = testContent.split('\n').map { it.toCharArray() }

            val result = getAndRemoveAccessiblePaperRolls(testPuzzleInput)

            val expectedMap = """
                .......@..
                .@@.@.@.@@
                @@@@@...@@
                @.@@@@..@.
                .@.@@@@.@.
                .@@@@@@@.@
                .@.@.@.@@@
                ..@@@.@@@@
                .@@@@@@@@.
                ....@@@...
            """.trimIndent()
            val actual = result.first.joinToString("\n") { it.joinToString("") }
            assertThat(actual).isEqualTo(expectedMap)
        }
    }

}