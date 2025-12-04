package day01

import printOutput
import printTestOutput
import readInput
import readTestInput

fun main() {
    val day = 1
    val part = 1
    println("\nExecuting part $part of day $day\n\n")



    val testInput = readTestInput(day)
    val testSolution = solvePuzzlePart1(testInput)

    printTestOutput(testSolution)

    val input = readInput(day)
    val solution = solvePuzzlePart1(input)

    printOutput(solution)
}

fun solvePuzzlePart1(input: List<String>): Int {
    val dialNumbers = (0..99).toList().toIntArray()
    val startPoint = 50
    var currentPoint = startPoint
    var visitedZero = 0
    for (directions in input) {
        val direction = directions.first()
        val distance = directions.drop(1).toInt()

        if (direction == 'R') {
            currentPoint = if (currentPoint + distance > dialNumbers.size - 1) {
                (currentPoint + distance) % dialNumbers.size
            } else {
                (currentPoint + distance)
            }
        }
        if (direction == 'L') {
            currentPoint = if(currentPoint - distance < 0) {
                val temp = (dialNumbers.size + ((currentPoint - distance) % dialNumbers.size))
                if(temp == dialNumbers.size) 0 else temp
            } else {
                currentPoint - distance
            }
        }

        println(currentPoint)

        if (currentPoint == 0) visitedZero++
    }

    return visitedZero
}