package com.shlapak.yaroslav.leetcode.problems1to100.problem10

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/04/11.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem10.Solution
 **/
class SolutionTest : FreeSpec({

    val inputs = mapOf(
            RegInput(" ", "") to false,
            RegInput(" ", "a") to false,
            RegInput("a", "") to false,
            RegInput(" ", " ") to true,
            RegInput("aa", "a*") to true,
            RegInput("aaa", "a*") to true,
            RegInput("a", "a*") to true,
            RegInput("ab", ".*") to true,
            RegInput("ab", "..") to true,
            RegInput("abc", "..c") to true,
            RegInput("aab", "c*a*b") to true,
            RegInput("b", "c*a*b") to true,
            RegInput("ab", "a*b") to true,
            RegInput("mississippi", "mis*is*p*.") to false,
            RegInput("mississippi", "mis*is*ip*.") to true
    )

    "isMatch" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: $input, expected: $expected" {
                Solution().isMatch(input.s, input.p) shouldBe expected
            }
        }
    }
}) {
    data class RegInput(val s: String, val p: String)
}