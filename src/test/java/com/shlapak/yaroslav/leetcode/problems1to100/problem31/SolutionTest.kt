package com.shlapak.yaroslav.leetcode.problems1to100.problem31

import com.shlapak.yaroslav.leetcode.utils.asString
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec


/**
 * Created on 2019/05/28.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem31.Solution
 **/
class SolutionTest : FreeSpec({

    "nextPermutation" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "nums: ${input.asString()}, expected: ${expected.asString()}" {
                Solution().nextPermutation(input)
                println("actual:   ${input.asString()}")
                println("expected: ${expected.asString()}")
                input.asString() shouldBe expected.asString()
            }
        }
    }

})

private fun getInputs(): Map<IntArray, IntArray> {
    return mapOf(
            intArrayOf(1, 2, 3) to intArrayOf(1, 3, 2),
            intArrayOf(3, 2, 1) to intArrayOf(1, 2, 3),
            intArrayOf(1, 1, 5) to intArrayOf(1, 5, 1),
            intArrayOf(1, 3, 2) to intArrayOf(2, 1, 3)
    )
}