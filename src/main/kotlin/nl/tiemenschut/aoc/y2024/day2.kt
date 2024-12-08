package nl.tiemenschut.aoc.y2024

import nl.tiemenschut.aoc.lib.dsl.aoc
import nl.tiemenschut.aoc.lib.dsl.day
import nl.tiemenschut.aoc.lib.dsl.parser.InputParser
import kotlin.math.absoluteValue

var day2parser = InputParser { input ->
    input.split("\n")
        .map { it.split(" ").map(String::toInt) }
}

fun main() {
    fun List<Int>.isSafe(): Boolean {
        val isIncreasing = this[0] < this[1]
        this.windowed(2)
            .forEach { pair ->
                val diff = pair[0] - pair[1]
                if (diff.absoluteValue > 3 || diff == 0) return false
                if (isIncreasing && diff > 0 || !isIncreasing && diff < 0) return false
            }
        return true
    }

    fun List<Int>.isSafeWithDampener(): Boolean {
        if (this.isSafe()) return true
        for (i in indices) {
            if (this.toMutableList().apply { removeAt(i) }.isSafe()) return true
        }
        return false
    }

    aoc(day2parser) {
        puzzle { 2024 day 2 }

        part1 { input ->
            input.count { it.isSafe() }
        }

        part2 { input ->
            input.count { it.isSafeWithDampener() }
        }
    }
}