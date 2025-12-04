package day01

import printOutput
import printTestOutput
import readInput
import readTestInput

fun main() {
    val day = 1
    val part = 2
    println("\nExecuting part $part of day $day\n\n")

    val testInput = readTestInput(day)
    val testSolution = solvePuzzlePart2(testInput)

    printTestOutput(testSolution)

    val input = readInput(day)
    val solution = solvePuzzlePart2(input)

    printOutput(solution)
}

fun solvePuzzlePart2(input: List<String>): Int {
    val dialNumbers = (0..99).toList().toIntArray()
    val startPoint = 50
    var currentPoint = startPoint
    var visitedZero = 0
    for (directions in input) {
        val direction = directions.first()
        val distance = directions.drop(1).toInt()

        println("\ncurrentPoint: $currentPoint")
        println(directions)

        if (direction == 'R') {
            currentPoint = if (currentPoint + distance > dialNumbers.size - 1) {
                val rest = (currentPoint + distance) % dialNumbers.size
                if (currentPoint > rest && rest != 0) {
                    println("extra 0 R!")
                    visitedZero++
                }
                rest
            } else {
                (currentPoint + distance)
            }
        }
        if (direction == 'L') {
            currentPoint = if (currentPoint - distance < 0) {
                val rest = (currentPoint - distance) % dialNumbers.size
                if (currentPoint != 0 && rest < 0) {
                    println("extra 0 L!")
                    visitedZero++
                }
                val temp = (dialNumbers.size + rest)
                if (temp == dialNumbers.size) 0 else temp
            } else {
                currentPoint - distance
            }
        }

        println(currentPoint)

        var div = (distance.toLong()).div(dialNumbers.size)
        if (currentPoint == 0 && div > 1) div--
        println("extra 0: ${div.toInt()}")
        visitedZero += div.toInt()

        if (currentPoint == 0) {
            println("zero for 0 position")
            visitedZero++
        }

        println("visitedZero: $visitedZero")
    }

    return visitedZero
}