package day02

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day02_part1Test {

    @ParameterizedTest
    @CsvSource(
        "11-22,33",
        "95-115,99",
        "998-1012,1010",
        "1188511880-1188511890,1188511885",
        "222220-222224,222222",
        "446443-446449,446446",
        "38593856-38593862,38593859",
        "1698522-1698528,0"
    )
    fun test1(input: String, expectedOutput: Long) {
        val inputList = listOf(input)

        val result = solvePuzzlePart1(inputList)

        assertEquals(expectedOutput, result)
    }

}