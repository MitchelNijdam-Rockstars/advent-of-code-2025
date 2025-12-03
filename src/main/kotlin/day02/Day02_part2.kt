package day02

import printOutput
import printTestOutput
import readInput
import readTestInput

fun main() {
    val day = 2
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
    val numberRanges = input.first().split(',')

    return numberRanges.sumOf { strRange ->
        val (start, end) = strRange.split('-').map { it.toLong() }

        val results = (start..end).sumOf { productId ->
            val productIdStr = productId.toString()
            val len = productIdStr.length
            if (len == 1) return@sumOf 0
            if (len % 2 != 0 && productIdStr.all { it == productIdStr.first() }) {
                productId
            } else if (hasRepeatedSequence(productIdStr)) {
                productId
            } else {
                0
            }
        }
        println("for $start-$end: $results\n")
        results
    }
}

fun hasRepeatedSequence(productId: String): Boolean {
    return (1..productId.length / 2).any { length ->
        if (productId.length % length != 0) return@any false
        val split = productId.windowed(length, length)
        split.all { it == split.first() }
    }
}