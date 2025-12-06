package day05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import readTestInput
import kotlin.test.Test
import kotlin.test.assertEquals

class Day05_part2Test {

    @Test
    fun `from test input`() {
        val day = 5
        val testPuzzleInput = readTestInput(day)

        val result = solvePuzzlePart2(testPuzzleInput)

        assertThat(result).isEqualTo(14L)
    }

    @Test
    fun newRange() {
        assertThat(listOf((0L..10L), (8L..20L)).newRange()).isEqualTo((0L..20L))
        assertThat(listOf((5L..10L), (8L..20L), (0L..100L)).newRange()).isEqualTo((0L..100L))
    }

    @Test
    fun overlaps() {
        assertThat(overlaps((1L..5L), (4L..10L))).isTrue
        assertThat(overlaps((4L..5L), (5L..10L))).isTrue
        assertThat(overlaps((5L..10L), (4L..5L))).isTrue
        assertThat(overlaps((100L..150L), (4L..100L))).isTrue
        assertThat(overlaps((100L..150L), (140L..200L))).isTrue
        assertThat(overlaps((100L..200L), (50L..250L))).isTrue
        assertThat(overlaps((50L..250L), (100L..200L))).isTrue

        assertThat(overlaps((10L..15L), (16L..20L))).isFalse
        assertThat(overlaps((10L..15L), (1L..9L))).isFalse
        assertThat(overlaps((100L..150L), (180..200L))).isFalse
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