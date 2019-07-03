package com.shlapak.yaroslav.leetcode.problem41

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
                "input: ${input}, expected: ${expected}" {
                    val actual = Solution().firstMissingPositive(input)
                    actual shouldBe expected
                }
            }
        }

    }

    private fun getInputs(): Map<IntArray, Int> {
        return mapOf(
                intArrayOf(1, 2, 0) to 3,
                intArrayOf(3, 4, -1, 1) to 2,
                intArrayOf(7, 8, 9, 11, 12) to 1
        )
    }

}