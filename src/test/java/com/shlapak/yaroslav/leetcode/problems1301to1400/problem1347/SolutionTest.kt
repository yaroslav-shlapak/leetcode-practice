package com.shlapak.yaroslav.leetcode.problems1301to1400.problem1347

import com.shlapak.yaroslav.leetcode.problems1301to1400.problem1347.Solution
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem1347.Solution
 *
 *  * Example 1:
 *  *
 *  * Input: s = "bab", t = "aba"
 *  * Output: 1
 *  * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 *  * Example 2:
 *  *
 *  * Input: s = "leetcode", t = "practice"
 *  * Output: 5
 *  * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 *  * Example 3:
 *  *
 *  * Input: s = "anagram", t = "mangaar"
 *  * Output: 0
 *  * Explanation: "anagram" and "mangaar" are anagrams.
 **/
class SolutionTest : FreeSpec({
    "Solution" - {
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

        val solution = Solution()
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