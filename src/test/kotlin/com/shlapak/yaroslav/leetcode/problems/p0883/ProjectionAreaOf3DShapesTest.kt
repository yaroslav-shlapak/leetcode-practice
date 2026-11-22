package com.shlapak.yaroslav.leetcode.problems.p0883

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests [ProjectionAreaOf3DShapes.RowAndColumnMaxima] on examples and projection edge cases. */
class ProjectionAreaOf3DShapesTest : FreeSpec({
    data class Case(val name: String, val rows: List<List<Int>>, val expected: Int)

    val cases = listOf(
        Case("four different stacks", listOf(listOf(1, 2), listOf(3, 4)), 17),
        Case("single stack", listOf(listOf(2)), 5),
        Case("diagonal stacks", listOf(listOf(1, 0), listOf(0, 2)), 8),
        Case("empty grid cells", listOf(listOf(0, 0), listOf(0, 0)), 0),
        Case("overlapping shadows", listOf(listOf(5, 5), listOf(5, 5)), 24),
        Case("different row and column maxima", listOf(listOf(0, 1, 0), listOf(2, 0, 3), listOf(0, 4, 0)), 21),
        Case("maximum single stack", listOf(listOf(50)), 101)
    )

    cases.forEach { case ->
        case.name {
            val grid = case.rows.map { it.toIntArray() }.toTypedArray()
            ProjectionAreaOf3DShapes.RowAndColumnMaxima().projectionArea(grid) shouldBe case.expected
            grid.map { it.toList() } shouldBe case.rows
        }
    }
})
