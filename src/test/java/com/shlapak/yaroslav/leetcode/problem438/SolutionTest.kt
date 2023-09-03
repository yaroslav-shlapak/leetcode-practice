package com.shlapak.yaroslav.leetcode.problem438

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem438.Solution
 *
 *  * Example 1:
 *  *
 *  * Input: s = "cbaebabacd", p = "abc"
 *  * Output: [0,6]
 *  * Explanation:
 *  * The substring with start index = 0 is "cba", which is an anagram of "abc".
 *  * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *  *
 *  * Example 2:
 *  *
 *  * Input: s = "abab", p = "ab"
 *  * Output: [0,1,2]
 *  * Explanation:
 *  * The substring with start index = 0 is "ab", which is an anagram of "ab".
 *  * The substring with start index = 1 is "ba", which is an anagram of "ab".
 *  * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 **/
class SolutionTest : FreeSpec({
    "Solution" - {
        val testCases = listOf<TestCase>(
                TestCase(s = "cbaebabacd", p = "abc", expected = listOf(0, 6)),
                TestCase(s = "abab", p = "ab", expected = listOf(0, 1, 2)),
                TestCase(s = "a", p = "ab", expected = listOf())
        )

        val solution = Solution()
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