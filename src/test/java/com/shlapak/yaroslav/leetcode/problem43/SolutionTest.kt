package com.shlapak.yaroslav.leetcode.problem43

import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem43.Solution
 **/
class SolutionTest : FreeSpec() {

    init {
        "trap" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = Solution().multiply(input.first, input.second)
                    actual shouldBe expected
                }
            }
        }
    }

    private fun getInputs(): Map<Pair<String, String>, String> {
        return mapOf(
                Pair("2", "3") to "6",
                Pair("123", "456") to "56088"
        )
    }
}