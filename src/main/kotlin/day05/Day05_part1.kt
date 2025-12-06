package day05

import printOutput
import readInput

fun main() {
    val day = 5
    val part = 1

    println("\nExecuting part $part of day $day\n\n")

    val input = readInput(day)
    val solution = solvePuzzlePart1(input)

    printOutput(solution)
}


fun solvePuzzlePart1(input: List<String>): Long {
    val freshIngredientRanges = input.takeWhile { it != "" }.map { it.split("-") }
        .map { it[0].toLong() to it[1].toLong() }

    val ingredientIds = input.takeLastWhile { it != "" }.map { it.toLong() }

    return ingredientIds.count { ingredientId ->
        freshIngredientRanges.any { range ->
            ingredientId >= range.first && ingredientId <= range.second
        }
    }.toLong()
}