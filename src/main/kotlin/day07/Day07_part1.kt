package day07

import printOutput
import readInput
import kotlin.math.max
import kotlin.math.min

fun main() {
    val day = 7
    val part = 1

    println("\nExecuting part $part of day $day\n\n")

    val input = readInput(day)
    val solution = solvePuzzlePart1(input)

    printOutput(solution)
}


fun solvePuzzlePart1(input: List<String>): Long {
    var beamIndexes = listOf<Int>()
    var amountOfSplits = 0
    input.forEachIndexed { index, line ->
        beamIndexes = if (index == 0) {
            listOf(line.indexOf('S'))
        } else {
            beamIndexes.flatMap { beamIndex ->
                if (line[beamIndex] == '.') listOf(beamIndex)
                else {
                    amountOfSplits++
                    listOf(max(0, beamIndex - 1), min(line.length, beamIndex + 1))
                }
            }.distinct()
        }
    }
    return amountOfSplits.toLong()
}