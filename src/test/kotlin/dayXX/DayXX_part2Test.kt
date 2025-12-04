package dayXX

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import readTestInput
import kotlin.test.Test
import kotlin.test.assertEquals

class DayXX_part2Test {

    @Test
    fun `from test input`() {
        val day = 0
        val testPuzzleInput = readTestInput(day)

        val result = solvePuzzlePart2(testPuzzleInput)

        assertThat(result).isEqualTo(43L)
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