package com.shlapak.yaroslav.leetcode.problem41

import com.shlapak.yaroslav.leetcode.utils.asString
import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem41.Solution
 **/
class SolutionTest : FreeSpec() {

    init {
        "combinationSum2" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.asString()}, expected: ${expected}" {
                    val actual = Solution().firstMissingPositive(input)
                    actual shouldBe expected
                }
            }
        }

        "combinationSum2 2" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.asString()}, expected: ${expected}" {
                    val actual = Solution2().firstMissingPositive(input)
                    actual shouldBe expected
                }
            }
        }

    }

    private fun getInputs(): Map<IntArray, Int> {
        return mapOf(
                intArrayOf(1, 2, 0) to 3,
                intArrayOf(3, 4, -1, 1) to 2,
                intArrayOf(7, 8, 9, 11, 12) to 1,
                intArrayOf() to 1,
                intArrayOf(0) to 1,
                intArrayOf(1) to 2,
                intArrayOf(2) to 1,
                intArrayOf(3) to 1,
                intArrayOf(-1, -2) to 1,
                intArrayOf(1, 0) to 2,
                intArrayOf(1000, -1) to 1,
                intArrayOf(-5) to 1,
                intArrayOf(-1, -2, 0, 2, 1, 3, 6, 5, 4) to 7
        )
    }

}