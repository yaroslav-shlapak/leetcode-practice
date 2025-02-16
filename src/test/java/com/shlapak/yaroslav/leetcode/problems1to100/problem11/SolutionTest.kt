package com.shlapak.yaroslav.leetcode.problems1to100.problem11

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/04/11.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem11.Solution
 **/
class SolutionTest : FreeSpec({
    val inputs = mapOf(
            intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7) to 49
    )

    "maxArea" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input.asList()}, expected: $expected" {
                Solution().maxArea(input) shouldBe expected
            }
        }
    }
})