package com.shlapak.yaroslav.leetcode.problems.p2273

import com.shlapak.yaroslav.leetcode.problems.p2273.FindResultantArrayAfterRemovingAnagrams
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [FindResultantArrayAfterRemovingAnagrams].
 */
class FindResultantArrayAfterRemovingAnagramsTest : FreeSpec({
    "FindResultantArrayAfterRemovingAnagrams" - {
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

        val solution = FindResultantArrayAfterRemovingAnagrams()
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
