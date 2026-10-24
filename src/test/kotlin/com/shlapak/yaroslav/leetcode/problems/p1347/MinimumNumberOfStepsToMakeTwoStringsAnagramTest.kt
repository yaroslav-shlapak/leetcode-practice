package com.shlapak.yaroslav.leetcode.problems.p1347

import com.shlapak.yaroslav.leetcode.problems.p1347.MinimumNumberOfStepsToMakeTwoStringsAnagram
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [MinimumNumberOfStepsToMakeTwoStringsAnagram].
 */
class MinimumNumberOfStepsToMakeTwoStringsAnagramTest : FreeSpec({
    "MinimumNumberOfStepsToMakeTwoStringsAnagram" - {
        val testCases = listOf<TestCase>(
                TestCase(
                        s = "bab", t = "aba", expected = 1
                ),
                TestCase(
                        s = "leetcode", t = "practice", expected = 5
                ),
                TestCase(
                        s = "anagram", t = "mangaar", expected = 0
                )
        )

        val solution = MinimumNumberOfStepsToMakeTwoStringsAnagram()
        for (testCase in testCases) {
            "testCase: $testCase" {
                solution.minSteps(s = testCase.s, t = testCase.t) shouldBe testCase.expected
            }
        }
    }


}) {
    data class TestCase(
            val s: String,
            val t: String,
            val expected: Int
    )
}
