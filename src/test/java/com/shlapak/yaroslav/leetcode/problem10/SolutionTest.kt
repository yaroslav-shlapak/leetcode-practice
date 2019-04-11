package com.shlapak.yaroslav.leetcode.problem10

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/04/11.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem10.Solution
 **/
object SolutionTest : Spek({

    val inputs = mapOf(
            RegInput(" ", "") to false,
            RegInput(" ", "a") to false,
            RegInput("a", "") to false,
            RegInput(" ", " ") to true,
            RegInput("aa", "a*") to true,
            RegInput("aaa", "a*") to true,
            RegInput("a", "a*") to true,
            RegInput("ab", ".*") to true,
            RegInput("aab", "c*a*b") to true,
            RegInput("ab", "a*b") to true,
            RegInput("mississippi", "mis*is*p*.") to false,
            RegInput("mississippi", "mis*is*ip*.") to true
    )

    group("isMatch2") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: $input, expected: $expected") {
                Solution().isMatch2(input.s, input.p) shouldBe expected
            }
        }
    }

    group("isMatch") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: $input, expected: $expected") {
                Solution().isMatch(input.s, input.p) shouldBe expected
            }
        }
    }
}) {
    data class RegInput(val s: String, val p: String)
}