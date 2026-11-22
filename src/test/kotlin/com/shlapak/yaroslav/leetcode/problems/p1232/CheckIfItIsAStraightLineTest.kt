package com.shlapak.yaroslav.leetcode.problems.p1232

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [CheckIfItIsAStraightLine.CrossProduct] against examples and geometric edge cases.
 */
class CheckIfItIsAStraightLineTest : FreeSpec({
    data class Case(val name: String, val points: List<Pair<Int, Int>>, val expected: Boolean)

    val cases = listOf(
        Case("straight line example", listOf(1 to 2, 2 to 3, 3 to 4, 4 to 5, 5 to 6, 6 to 7), true),
        Case("nonstraight example", listOf(1 to 1, 2 to 2, 3 to 4, 4 to 5, 5 to 6, 7 to 7), false),
        Case("two points always define a line", listOf(-4 to 7, 8 to -2), true),
        Case("vertical line in mixed order", listOf(3 to 0, 3 to 4, 3 to -2), true),
        Case("horizontal line in mixed order", listOf(0 to 3, 4 to 3, -2 to 3), true),
        Case("point outside vertical line", listOf(3 to 0, 3 to 4, 2 to -2), false),
        Case("point outside horizontal line", listOf(0 to 3, 4 to 3, -2 to 2), false),
        Case("fractional negative slope", listOf(0 to 1, 3 to -1, -3 to 3, 6 to -3), true),
        Case("parallel line with different intercept", listOf(0 to 0, 1 to 1, 2 to 3, 3 to 4), false),
        Case("last point deviates", listOf(0 to 0, 2 to 3, 4 to 6, 6 to 10), false),
        Case("coordinate bounds", listOf(-10000 to -10000, 10000 to 10000, 0 to 0), true),
        Case("nearby point at coordinate bounds", listOf(-10000 to -10000, 10000 to 9999, 9999 to 9998), false),
        Case("maximum point count", (0 until 1000).map { it to (2 * it - 1000) }, true)
    )

    cases.forEach { case ->
        case.name {
            val coordinates = case.points.map { (x, y) -> intArrayOf(x, y) }.toTypedArray()
            val original = coordinates.map { it.toList() }

            CheckIfItIsAStraightLine.CrossProduct().checkStraightLine(coordinates) shouldBe case.expected
            coordinates.map { it.toList() } shouldBe original
        }
    }
})
