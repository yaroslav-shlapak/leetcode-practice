package com.shlapak.yaroslav.leetcode.problems1to100.problem38

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/06/24.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem38.Solution
 **/
internal class SolutionTest : FreeSpec({
    "countAndSay" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input}, expected: ${expected}" {
                val actual = Solution().countAndSay(input)
                actual shouldBe expected
            }
        }
    }
})

private fun getInputs(): Map<Int, String> {
    return mapOf(
            1 to "1",
            2 to "11",
            3 to "21",
            4 to "1211",
            5 to "111221"
    )
}