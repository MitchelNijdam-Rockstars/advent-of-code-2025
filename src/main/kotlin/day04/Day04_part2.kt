package day04

import printOutput
import printTestOutput
import readInput
import readTestInput

fun main() {
    val day = 4
    val part = 2

    println("\nExecuting part $part of day $day\n\n")

    val testInput = readTestInput(day)
    val testSolution = solvePuzzlePart2(testInput)

    printTestOutput(testSolution)

    val input = readInput(day)
    val solution = solvePuzzlePart2(input)

    printOutput(solution)
}


fun solvePuzzlePart2(input: List<String>): Long {
    var map = input.map { it.toCharArray() }
    var totalAccessiblePaperRolls = 0L

    do {
        val (updatedMap, amountOfAccessiblePaperRolls) = getAndRemoveAccessiblePaperRolls(map)
        map = updatedMap
        totalAccessiblePaperRolls += amountOfAccessiblePaperRolls
    } while (amountOfAccessiblePaperRolls != 0L)

    return totalAccessiblePaperRolls
}

fun getAndRemoveAccessiblePaperRolls(map: List<CharArray>): Pair<List<CharArray>, Long> {
    val positionWithSurroundings: List<List<Position>> = map.flatMapIndexed { y, charArray ->
        charArray.mapIndexed { x, _ ->
            getSurroundingPositions(x, y, map)
        }
    }
    val onlyPaperRollPositions = positionWithSurroundings.filter { area ->
        area.first { it.isCenterPosition() }.isPaperRoll()
    }
    val accessiblePaperRolls = onlyPaperRollPositions.filter { area ->
        area.filter { !it.isCenterPosition() }.count { it.isPaperRoll() } < 4
    }

    val mapToUpdate = map.map { it.toMutableList() }.toMutableList()
    accessiblePaperRolls.map { area ->
        area.first { it.isCenterPosition() }
    }.forEach { accessiblePaperRoll ->
        mapToUpdate[accessiblePaperRoll.originalY][accessiblePaperRoll.originalX] = '.'
    }
    val updatedMap = mapToUpdate.map { it.toCharArray() }.toList()

    return updatedMap to accessiblePaperRolls.count().toLong()
}