package com.shlapak.yaroslav.leetcode.problems.p0022

import com.shlapak.yaroslav.leetcode.support.shouldMatchUnordered
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests every parentheses implementation with exact outputs and repeated calls on one instance.
 * The repository defines zero pairs as an empty result.
 */
class GenerateParenthesesTest : FreeSpec({
    val implementations: Map<String, (Int) -> List<String>> = mapOf(
        "stack" to GenerateParentheses()::generateParenthesis,
        "recursive" to GenerateParentheses2()::generateParenthesis,
        "legacy stack" to GenerateParenthesesLegacy()::generateParenthesis,
    )
    for ((name, solve) in implementations) {
        name - {
            for ((n, expected) in getInputs()) {
                "generates exactly the combinations for $n pairs" {
                    solve(n).shouldMatchUnordered(expected)
                }
            }
            "resets state and preserves earlier results across calls" {
                val first = solve(1)
                solve(2).shouldMatchUnordered(getInputs().getValue(2))
                solve(1).shouldMatchUnordered(getInputs().getValue(1))
                first shouldBe listOf("()")
            }
        }
    }
})

private fun getInputs(): Map<Int, List<String>> {
    return mapOf(
            0 to listOf(),
            1 to listOf("()"),
            2 to listOf("()()", "(())"),
            3 to listOf("()()()", "()(())", "(())()", "((()))", "(()())")
    )
}
