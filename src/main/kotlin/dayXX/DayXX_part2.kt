package dayXX

import printTestOutput
import readTestInput

fun main() {
    val day = 0
    val part = 2

    println("\nExecuting part $part of day $day\n\n")

    val testInput = readTestInput(day)
    val testSolution = solvePuzzlePart2(testInput)

    printTestOutput(testSolution)

//    val input = readInput(day)
//    val solution = solvePuzzlePart2(input)
//
//    printOutput(solution)
}

fun solvePuzzlePart2(input: List<String>): Long {
    return input.size.toLong()
}