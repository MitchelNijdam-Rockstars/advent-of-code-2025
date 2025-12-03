package day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
import kotlin.test.assertEquals

class Day02_part2Test {

    @ParameterizedTest
    @CsvSource(
        "11,true",
        "1212,true",
        "123123,true",
        "1234512345,true",
        "12121212,true",
        "841841841,true",
        "178178,true",
        "17817899,false",
        "178178998,false",
        "12312,false",
        "19099,false",
        "1,false",
        "0,false",
    )
    fun test2(input: String, expected: Boolean) {
        val result = hasRepeatedSequence(input)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "11-22,33",
        "95-115,210",
        "998-1012,2009",
        "1188511880-1188511890,1188511885",
        "222220-222224,222222",
        "446443-446449,446446",
        "38593856-38593862,38593859",
        "1698522-1698528,0",
        "565653-565659,565656",
        "824824821-824824827,824824824",
        "2121212118-2121212124,2121212121",
        "0-11,11",
        "1-2,0",
        "0-2,0",
        "1111-1122,1111",
    )
    fun test1(input: String, expectedOutput: Long) {
        val inputList = listOf(input)

        val result = solvePuzzlePart2(inputList)

        assertEquals(expectedOutput, result)
    }

    @Test
    fun test3(){
        val result = hasRepeatedSequence("1122")

        assertThat(result).isTrue
    }

}