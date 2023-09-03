package com.shlapak.yaroslav.leetcode.problem242

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem242.Solution
 **/
class SolutionTest : FreeSpec({
    "ValidAnagram" - {
        val testCases = listOf(
                Parameter(s = "", t = "", expected = true),
                Parameter(s = "anagram", t = "nagaram", expected = true),
                Parameter(s = "rat", t = "car", expected = false)
        )

        val solution = Solution()
        for (input in testCases) {
            "input: $input" {
                solution.isAnagram(s = input.s, t = input.t) shouldBe input.expected
            }
        }
    }


}) {
    data class Parameter(
            val s: String,
            val t: String,
            val expected: Boolean
    )
}