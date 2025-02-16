package com.shlapak.yaroslav.leetcode.problems1to100.problem18

import com.shlapak.yaroslav.leetcode.utils.asString
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/04/24.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem18.Solution
 **/
class SolutionTest : FreeSpec({
    val inputs = mapOf(
            Prameter(
                    intArrayOf(1, 0, -1, 0, -2, 2),
                    0
            ) to listOf(
                    listOf(-1, 0, 0, 1),
                    listOf(-2, -1, 1, 2),
                    listOf(-2, 0, 0, 2)
            ),
            Prameter(
                    intArrayOf(0, 0, 0, 0),
                    0
            ) to listOf(
                    listOf(0, 0, 0, 0)
            ),
            Prameter(
                    intArrayOf(-4, -3, -2, -1, 0, 0, 1, 2, 3, 4),
                    0
            ) to listOf(
                    listOf(-4, -3, 3, 4),
                    listOf(-4, -2, 2, 4),
                    listOf(-4, -1, 1, 4),
                    listOf(-4, -1, 2, 3),
                    listOf(-4, 0, 0, 4),
                    listOf(-4, 0, 1, 3),
                    listOf(-3, -2, 1, 4),
                    listOf(-3, -2, 2, 3),
                    listOf(-3, -1, 0, 4),
                    listOf(-3, -1, 1, 3),
                    listOf(-3, 0, 0, 3),
                    listOf(-3, 0, 1, 2),
                    listOf(-2, -1, 0, 3),
                    listOf(-2, -1, 1, 2),
                    listOf(-2, 0, 0, 2),
                    listOf(-1, 0, 0, 1)
            ),
            Prameter(
                    intArrayOf(-3, -1, 0, 2, 4, 5),
                    1
            ) to listOf(
                    listOf(-3, -1, 0, 5)
            ),
            Prameter(
                    intArrayOf(0, 4, -5, 2, -2, 4, 2, -1, 4),
                    12
            ) to listOf(
                    listOf(0, 4, 4, 4),
                    listOf(2, 2, 4, 4)
            )
    )

    "fourSum" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input.nums: ${input.nums.asString()}, input.target: ${input.target}, expected: ${expected.asString()}" {
                val actual = Solution().fourSum(input.nums, input.target)
                println("actual.size: ${actual.size}")
                println("actual:   $actual")
                println("expected: $expected")
                println("expected.size: ${expected.size}")
                actual shouldContainAll expected
                expected shouldContainAll actual
            }
        }
    }
})

data class Prameter(
        val nums: IntArray,
        val target: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Prameter) return false

        if (!nums.contentEquals(other.nums)) return false
        if (target != other.target) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nums.contentHashCode()
        result = 31 * result + target
        return result
    }
}