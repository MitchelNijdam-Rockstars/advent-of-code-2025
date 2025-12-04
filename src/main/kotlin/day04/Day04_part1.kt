package day04

import cartesianProduct
import printOutput
import printTestOutput
import readInput
import readTestInput

fun main() {
    val day = 4
    val part = 1

    println("\nExecuting part $part of day $day\n\n")

    val testInput = readTestInput(day)
    val testSolution = solvePuzzlePart1(testInput)

    printTestOutput(testSolution)

    val input = readInput(day)
    val solution = solvePuzzlePart1(input)

    printOutput(solution)
}


fun solvePuzzlePart1(input: List<String>): Long {
    val map = input.map { it.toCharArray() }

    val positionWithSurroundings: List<List<Position>> = map.flatMapIndexed { y, charArray ->
        charArray.mapIndexed { x, _ ->
            getSurroundingPositions(x, y, map)
        }
    }
    val onlyPaperRollPositions = positionWithSurroundings.filter { area ->
        area.first { it.isCenterPosition() }.isPaperRoll()
    }
    val onlyWithLessThanFourAdjacentPaperRolls = onlyPaperRollPositions.count { area ->
        area.filter { !it.isCenterPosition() }.count { it.isPaperRoll() } < 4
    }

    return onlyWithLessThanFourAdjacentPaperRolls.toLong()
}

fun getSurroundingPositions(
    x: Int,
    y: Int,
    map: List<CharArray>
): List<Position> {
    val allX = listOf(x, x - 1, x + 1).filter { it >= 0 && it < map.first().size }
    val allY = listOf(y, y - 1, y + 1).filter { it >= 0 && it < map.size }

    return allX.cartesianProduct(allY).map { (xx, yy) ->
        Position(xx - x, yy - y, x, y, map[yy][xx])
    }
}


data class Position(
    val deltaX: Int,
    val deltaY: Int,
    val originalX: Int,
    val originalY: Int,
    val value: Char
) {
    fun isCenterPosition() = deltaX == 0 && deltaY == 0
    fun isPaperRoll() = value == '@'
}