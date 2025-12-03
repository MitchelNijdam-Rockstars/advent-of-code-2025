package day02

import printOutput
import printTestOutput
import readInput
import readTestInput

fun main() {
    val day = 2
    val part = 1
    println("\nExecuting part $part of day $day\n\n")

    val testInput = readTestInput(day)
    val testSolution = solvePuzzlePart1(testInput)

    printTestOutput(testInput, testSolution)

    val input = readInput(day)
    val solution = solvePuzzlePart1(input)

    printOutput(solution)
}


fun solvePuzzlePart1(input: List<String>): Long {
    val numberRanges = input.first().split(',')

    return numberRanges.sumOf { strRange ->
        val (start, end) = strRange.split('-').map { it.toLong() }
        val results = (start..end).sumOf { productId ->
            val productIdStr = productId.toString()
            val len = productIdStr.length
            if (len % 2 == 0 && productIdStr.take(len / 2) == productIdStr.drop(len / 2)) productId else 0
        }
        println("for $start-$end: $results")
        results
    }
}