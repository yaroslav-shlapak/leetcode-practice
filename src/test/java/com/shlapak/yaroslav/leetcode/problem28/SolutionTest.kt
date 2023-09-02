package com.shlapak.yaroslav.leetcode.problem28

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/05/19.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem28.Solution
 **/
class SolutionTest : FreeSpec({
    "strStr" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "input.haystack: ${input.haystack}, input.needle: ${input.needle} expected: $expected" {
                val actual = Solution().strStr(input.haystack, input.needle)
                println("actual:   $actual")
                println("expected: $expected")
                actual shouldBe expected
            }
        }
    }
}) {
    data class Parameter(
            val haystack: String,
            val needle: String
    )
}

fun getInputs(): Map<SolutionTest.Parameter, Int> {
    return mapOf(
            SolutionTest.Parameter(
                    haystack = "hello",
                    needle = "ll"
            ) to 2,
            SolutionTest.Parameter(
                    haystack = "aaaaa",
                    needle = "bba"
            ) to -1,
            SolutionTest.Parameter(
                    haystack = "llhello",
                    needle = "ll"
            ) to 0,
            SolutionTest.Parameter(
                    haystack = "ashell",
                    needle = "ll"
            ) to 4,
            SolutionTest.Parameter(
                    haystack = "ashel0",
                    needle = "l0"
            ) to 4,
            SolutionTest.Parameter(
                    haystack = "mississippi",
                    needle = "issipi"
            ) to -1,
            SolutionTest.Parameter(
                    haystack = "mississippi",
                    needle = "issip"
            ) to 4
    )
}
