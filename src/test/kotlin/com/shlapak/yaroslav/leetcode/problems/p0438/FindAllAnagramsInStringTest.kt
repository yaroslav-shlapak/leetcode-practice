package com.shlapak.yaroslav.leetcode.problems.p0438

import com.shlapak.yaroslav.leetcode.problems.p0438.FindAllAnagramsInString.OptimalSlidingWindow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [FindAllAnagramsInString.OptimalSlidingWindow].
 */
class FindAllAnagramsInStringTest : FreeSpec({
    "Solution" - {
        val testCases = listOf<TestCase>(
                TestCase(s = "cbaebabacd", p = "abc", expected = listOf(0, 6)),
                TestCase(s = "abab", p = "ab", expected = listOf(0, 1, 2)),
                TestCase(s = "a", p = "ab", expected = listOf())
        )

        val solution = OptimalSlidingWindow()
        for (testCase in testCases) {
            "testCase: $testCase" {
                solution.findAnagrams(s = testCase.s, p = testCase.p) shouldBe testCase.expected
            }
        }
    }


}) {
    data class TestCase(
            val s: String,
            val p: String,
            val expected: List<Int>
    )
}
