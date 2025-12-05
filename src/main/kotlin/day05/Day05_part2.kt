package day05

import printOutput
import readInput

fun main() {
    val day = 5
    val part = 2

    println("\nExecuting part $part of day $day\n\n")

    val input = readInput(day)
    val solution = solvePuzzlePart2(input)

    printOutput(solution)
}

fun solvePuzzlePart2(input: List<String>): Long {
    return input.size.toLong()
}