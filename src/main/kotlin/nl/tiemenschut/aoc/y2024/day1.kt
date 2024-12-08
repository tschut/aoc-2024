package nl.tiemenschut.aoc.y2024

import nl.tiemenschut.aoc.lib.dsl.aoc
import nl.tiemenschut.aoc.lib.dsl.day
import nl.tiemenschut.aoc.lib.dsl.parser.InputParser
import kotlin.math.absoluteValue

val inputParser = InputParser { input ->
    val numberPairs = input
        .split("\n")
        .map { it.split("   ") }
        .map { it[0].toInt() to it[1].toInt() }
    val left = numberPairs.map { it.first }.sorted()
    val right = numberPairs.map { it.second }.sorted()
    left to right
}

fun main() {
    aoc(inputParser) {
        puzzle { 2024 day 1 }

        part1 { input ->
            input.first
                .mapIndexed { index, i -> (i - input.second[index]).absoluteValue }
                .sum()
        }

        part2 { input ->
            input.first.sumOf { i -> input.second.count { it == i } * i }
        }
    }
}