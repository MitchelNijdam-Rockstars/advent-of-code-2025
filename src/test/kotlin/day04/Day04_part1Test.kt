package day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
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

    @Nested
    inner class GetSurroundingPositions {

        @Test
        fun test1() {
            val map = listOf(
                "...@....".toCharArray(),
                "....@...".toCharArray(),
                ".....@..".toCharArray()
            )

            val result = getSurroundingPositions(0, 0, map)

            assertThat(result).containsExactly(
                Position(0, 0, 0, 0, '.'),
                Position(0, 1, 0, 1, '.'),
                Position(1, 0, 1, 0, '.'),
                Position(1, 1, 1, 1, '.'),
            )
        }

        @Test
        fun test2() {
            val map = listOf(
                "...@....".toCharArray(),
                "....@...".toCharArray(),
                ".....@..".toCharArray()
            )

            val result = getSurroundingPositions(3, 1, map)

            assertThat(result).containsExactlyInAnyOrder(
                Position(3, 0, 3, 0, '@'),
                Position(3, 1, 3, 1, '.'),
                Position(3, 2, 3, 2, '.'),
                Position(2, 0, 2, 0, '.'),
                Position(2, 1, 2, 1, '.'),
                Position(2, 2, 2, 2, '.'),
                Position(4, 0, 4, 0, '.'),
                Position(4, 1, 4, 1, '@'),
                Position(4, 2, 4, 2, '.'),
            )
        }
    }

}