package dayXX

import printOutput
import printTestOutput
import readInput
import readTestInput

fun main() {
    val day = 0
    val part = 1

    println("\nExecuting part $part of day $day\n\n")

    val input = readInput(day)
    val solution = solvePuzzlePart1(input)

    printOutput(solution)
}


fun solvePuzzlePart1(input: List<String>): Long {
    return input.size.toLong()
}