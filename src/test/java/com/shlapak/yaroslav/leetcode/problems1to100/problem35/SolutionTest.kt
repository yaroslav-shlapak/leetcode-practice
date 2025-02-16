package com.shlapak.yaroslav.leetcode.problems1to100.problem35

import com.shlapak.yaroslav.leetcode.utils.asString
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/06/07.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem35.Solution
 **/
internal class SolutionTest : FreeSpec({

    "searchInsert" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.nums: ${input.nums.asString()}, input.target: ${input.target}, expected: ${expected}" {
                val actual = Solution().searchInsert(input.nums, input.target)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }

    "searchInsert2" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.nums: ${input.nums.asString()}, input.target: ${input.target}, expected: ${expected}" {
                val actual = Solution2().searchInsert(input.nums, input.target)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }
})

data class Parameter(
        val nums: IntArray,
        val target: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Parameter) return false

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

private fun getInputs(): Map<Parameter, Int> {
    return mapOf(
            Parameter(
                    intArrayOf(1, 3, 5, 6),
                    0
            ) to 0,
            Parameter(
                    intArrayOf(1, 3, 5, 6),
                    5
            ) to 2,
            Parameter(
                    intArrayOf(1, 3, 5, 6),
                    2
            ) to 1,
            Parameter(
                    intArrayOf(1, 3, 5, 6),
                    7
            ) to 4,
            Parameter(
                    intArrayOf(1, 3, 5, 6),
                    1
            ) to 0,
            Parameter(
                    intArrayOf(1, 3, 5, 6),
                    3
            ) to 1,
            Parameter(
                    intArrayOf(1, 3, 5, 6),
                    5
            ) to 2,
            Parameter(
                    intArrayOf(1, 3, 5, 6),
                    6
            ) to 3
    )
}