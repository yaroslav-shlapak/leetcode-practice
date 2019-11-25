package com.shlapak.yaroslav.leetcode.problem54

import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

class SolutionTest : FreeSpec() {

    init {
        "spiralOrder" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.toList()}, expected: ${expected}" {
                    val actual = Solution().spiralOrder(input)
                    println("actual: ${actual}")
                    println("expected: ${expected}")
                    actual shouldBe expected
                }
            }
        }
    }

    private fun getInputs(): Map<Array<IntArray>, List<Int>> {
        return mapOf(
                arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(3, 4)
                ) to listOf(1, 2, 4, 3),
                arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6),
                        intArrayOf(7, 8, 9)
                ) to listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),
                arrayOf(
                        intArrayOf(1, 2, 3, 4),
                        intArrayOf(5, 6, 7, 8),
                        intArrayOf(9, 10, 11, 12)
                ) to listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                arrayOf(
                        intArrayOf(1, 2, 3, 4),
                        intArrayOf(5, 6, 7, 8),
                        intArrayOf(9, 10, 11, 12),
                        intArrayOf(13, 14, 15, 16)
                ) to listOf(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10)
        )
    }
}