package day03

import printOutput
import printTestOutput
import readInput
import readTestInput

fun main() {
    val day = 3
    val part = 2

    println("\nExecuting part $part of day $day\n\n")

    val testInput = readTestInput(day)
    val testSolution = solvePuzzlePart2(testInput)

    printTestOutput(testInput, testSolution)

    val input = readInput(day)
    val solution = solvePuzzlePart2(input)

    printOutput(solution)
}

fun solvePuzzlePart2(input: List<String>): Long {
    return input.sumOf { bank ->
        var digits = ""
        var currentIndex = -1
        (1..12).reversed().forEach { keep ->
            val highestBattery = bank.drop(currentIndex + 1).dropLast(keep - 1).toCharArray().toList().maxOf { it }
            val highestMostLeftIndex = bank.drop(currentIndex + 1).indexOf(highestBattery)
            digits += bank[highestMostLeftIndex + currentIndex + 1].toString()
            currentIndex += highestMostLeftIndex + 1
        }
        println("Found $digits for bank: $bank")
        digits.toLong()
    }
}