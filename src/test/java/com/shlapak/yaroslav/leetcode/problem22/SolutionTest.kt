package com.shlapak.yaroslav.leetcode.problem22

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/05/09.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem22.Solution
 **/
class SolutionTest : FreeSpec({
    "generateParenthesis" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input: $input, expected: $expected" {
                val actual = Solution().generateParenthesis(input)
                println("actual:   $actual")
                println("expected: $expected")
                actual shouldContainAll expected
            }
        }
    }
})

fun getInputs(): Map<Int, List<String>> {
    return mapOf(
            0 to listOf(),
            1 to listOf("()"),
            2 to listOf("()()", "(())"),
            3 to listOf("()()()", "()(())", "(())()", "((()))", "(()())")
    )
}
