package com.shlapak.yaroslav.leetcode.problems.p0010

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [RegularExpressionMatching].
 */
class RegularExpressionMatchingTest : FreeSpec({

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
                RegularExpressionMatching().isMatch(input.s, input.p) shouldBe expected
            }
        }
    }
}) {
    data class RegInput(val s: String, val p: String)
}
