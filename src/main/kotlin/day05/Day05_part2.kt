package day05

import printOutput
import readInput

fun main() {
    val day = 5
    val part = 2

    println("\nExecuting part $part of day $day\n\n")

    val input = readInput(day)
    val solution = solvePuzzlePart2(input)

    printOutput(solution)
}

fun solvePuzzlePart2(input: List<String>): Long {
    val freshIngredientRanges = input.takeWhile { it != "" }.map { it.split("-") }
        .map { (it[0].toLong()..it[1].toLong()) }

    var unprocessedRanges = freshIngredientRanges.sortedBy { it.first }.toList()
    val allRanges = mutableListOf<LongRange>()

    while (unprocessedRanges.isNotEmpty()) {
        val range = unprocessedRanges.first()
        unprocessedRanges = unprocessedRanges.drop(1)
        var overlappingRanges = findAllOverlapping(range, unprocessedRanges)
        var newRange = range
        while (overlappingRanges.isNotEmpty()) {
            unprocessedRanges = unprocessedRanges.filter { !overlappingRanges.contains(it) }
            newRange = (listOf(range) + overlappingRanges).newRange()
            overlappingRanges = findAllOverlapping(range, unprocessedRanges)
        }
        println("adding new range $newRange")
        allRanges.add(newRange)
    }

    return allRanges.sumOf { it.last - it.first + 1 }
}

fun Collection<LongRange>.newRange(): LongRange {
    val min = this.minOf { it.first }
    val max = this.maxOf { it.last }
    return (min..max)
}

fun findAllOverlapping(range: LongRange, ranges: List<LongRange>): List<LongRange> {
    return ranges.map { rangeToCheck ->
        rangeToCheck to overlaps(range, rangeToCheck)
    }.filter { (_, overlaps) -> overlaps }.toMap().keys.toList()
}

fun overlaps(rangeA: LongRange, rangeB: LongRange): Boolean =
    (rangeA.first >= rangeB.first && rangeA.first <= rangeB.last) ||
            (rangeA.last <= rangeB.last && rangeA.last >= rangeB.first) ||
            (rangeB.first >= rangeA.first && rangeB.first <= rangeA.last) ||
            (rangeB.last <= rangeA.last && rangeB.last >= rangeA.first)


