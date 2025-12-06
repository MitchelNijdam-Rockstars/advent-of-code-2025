package day06

import printOutput
import readInput

fun main() {
    val day = 6
    val part = 1

    println("\nExecuting part $part of day $day\n\n")

    val input = readInput(day)
    val solution = solvePuzzlePart1(input)

    printOutput(solution)
}


fun solvePuzzlePart1(input: List<String>): Long {
    val rotatedInput = mutableListOf<MutableList<String>>()

    input.forEach { line ->
        line.split(' ').filter { it != "" }.forEachIndexed { valueIndex, value ->
            val newLine = rotatedInput.getOrNull(valueIndex)
            if (newLine == null) {
                rotatedInput.add(mutableListOf(value))
            } else {
                newLine.add(value)
            }
        }
    }

    return rotatedInput.map { it.last() to it.dropLast(1) }.fold(0L) { acc, (operator, values) ->
        val longValues = values.map { it.toLong() }

        val afterOperation = when (operator) {
            "*" -> longValues.reduce { acc, lng -> acc * lng }
            "+" -> longValues.reduce { acc, lng -> acc + lng }
            else -> throw IllegalArgumentException("I don't support operator $operator")
        }

        acc + afterOperation
    }
}