package day06

import printOutput
import readInput

fun main() {
    val day = 6
    val part = 2

    println("\nExecuting part $part of day $day\n\n")

    val input = readInput(day)
    val solution = solvePuzzlePart2(input)

    printOutput(solution)
}

fun solvePuzzlePart2(input: List<String>): Long {
    val rotated = mutableListOf(mutableListOf(mutableListOf<Char>()))
    val separatorIndexes = getSeparatorIndexes(input)

    input.forEachIndexed { lineIndex, line ->
        var currentColumn = 0
        (line.toCharArray() + charArrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')).forEachIndexed { index, char ->
            if (separatorIndexes.contains(index)) {
                currentColumn++
            } else {
                val rotatedRow = rotated.getOrNull(currentColumn)
                if (rotatedRow != null) {
                    val rotatedValue = rotatedRow.getOrNull(lineIndex)
                    if (rotatedValue != null) {
                        rotatedValue.add(char)
                    } else {
                        rotatedRow.add(mutableListOf(char))
                    }
                } else {
                    rotated.add(mutableListOf(mutableListOf(char)))
                }
            }
        }
    }

    println(rotated)

    return rotated.map { row ->
        val values = row.first().mapIndexed { index, _ ->
            row.dropLast(1).map { value -> value[index] }.joinToString("").trim().toLong()
        }
        val operation = row.last().joinToString("").trim()
        operation to values
    }.sumOf { (operation, values) ->
        val afterOperation = when (operation) {
            "*" -> values.reduce { acc, lng -> acc * lng }
            "+" -> values.reduce { acc, lng -> acc + lng }
            else -> throw IllegalArgumentException("I don't support operator $operation")
        }
        println("after operation: $afterOperation for $values, $operation")
        afterOperation
    }
}

fun getSeparatorIndexes(input: List<String>): List<Int> = input.first().mapIndexedNotNull { index, _ ->
    if (input.all { it[index] == ' ' }) index else null
}