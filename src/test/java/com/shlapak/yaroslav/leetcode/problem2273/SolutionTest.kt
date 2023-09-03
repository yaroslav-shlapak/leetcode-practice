package com.shlapak.yaroslav.leetcode.problem2273

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem2273.Solution
 **/
class SolutionTest : FreeSpec({
    "Solution" - {
        val testCases = listOf<TestCase>(
                TestCase(
                        input = arrayOf(
                                "abba", "baba", "bbaa", "cd", "cd"
                        ),
                        expected = listOf(
                                "abba", "cd"
                        )
                ),
                TestCase(
                        input = arrayOf(
                                "a", "b", "c", "d", "e"
                        ),
                        expected = listOf(
                                "a", "b", "c", "d", "e"
                        )
                ),
        )

        val solution = Solution()
        for (testCase in testCases) {
            "testCase: $testCase" {
                solution.removeAnagrams(testCase.input) shouldBe testCase.expected
            }
        }
    }


}) {
    data class TestCase(
            val input: Array<String>,
            val expected: List<String>
    )
}