package day01

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01_part2Test {

    @Test
    fun test1() {
        val input = listOf(
            "L55"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(1, result)
    }

    @Test
    fun test2() {
        val input = listOf(
            "L155"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(2, result)
    }

    @Test
    fun test3() {
        val input = listOf(
            "L150"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(2, result)
    }

    @Test
    fun test4() {
        val input = listOf(
            "R55"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(1, result)
    }

    @Test
    fun test5() {
        val input = listOf(
            "R155"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(2, result)
    }

    @Test
    fun test6() {
        val input = listOf(
            "R150"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(2, result)
    }

    @Test
    fun test7() {
        val input = listOf(
            "R155",
            "L155",
            "R50"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(5, result)
    }

    @Test
    fun test8() {
        val input = listOf(
            "R50",
            "R100"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(2, result)
    }

    @Test
    fun test9() {
        val input = listOf(
            "L50",
            "L100"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(2, result)
    }

    @Test
    fun test10() {
        val input = listOf(
            "L50",
            "L100",
            "L1000"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(13, result)
    }

    @Test
    fun test11() {
        val input = listOf(
            "R50",
            "R100",
            "R1000"
        )
        val result = solvePuzzlePart2(input)

        assertEquals(13, result)
    }

}