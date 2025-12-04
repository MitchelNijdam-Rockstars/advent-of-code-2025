package day03

import printOutput
import printTestOutput
import readInput
import readTestInput
import kotlin.text.indexOf

fun main() {
    val day = 3
    val part = 1

    println("\nExecuting part $part of day $day\n\n")

    val testInput = readTestInput(day)
    val testSolution = solvePuzzlePart1(testInput)

    printTestOutput(testSolution)

    val input = readInput(day)
    val solution = solvePuzzlePart1(input)

    printOutput(solution)
}


fun solvePuzzlePart1(input: List<String>): Long {
    return input.sumOf { bank ->
//        println("---- ${bank.take(5)}... -----")
        val batteriesMinusLast = bank.dropLast(1).toCharArray().toList().sortedDescending()
        val highestMostLeftIndex = bank.indexOf(batteriesMinusLast.first())
        val firstHighestBattery = bank[highestMostLeftIndex]

        val highestAfterOtherHighest = bank.drop(highestMostLeftIndex + 1).toCharArray().toList().maxOf { it }

        val result = "$firstHighestBattery$highestAfterOtherHighest"
//        println("Found $result for bank: $bank")
        result.toLong()
    }
}