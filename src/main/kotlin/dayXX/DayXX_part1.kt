package dayXX

import printTestOutput
import readTestInput

fun main() {
    val day = 0
    val part = 1

    println("\nExecuting part $part of day $day\n\n")

    val testInput = readTestInput(day)
    val testSolution = solvePuzzlePart1(testInput)

    printTestOutput(testSolution)

//    val input = readInput(day)
//    val solution = solvePuzzlePart1(input)
//
//    printOutput(solution)
}


fun solvePuzzlePart1(input: List<String>): Long {
    return input.size.toLong()
}