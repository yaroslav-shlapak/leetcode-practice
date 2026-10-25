package com.shlapak.yaroslav.leetcode.examples

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Provides an empty Kotest template for adding problem-specific test cases.
 *
 * Copy this template into the problem package and replace the placeholder case type.
 */
class ProblemTestTemplate : FreeSpec({
    "Solution" - {
        val testCases = listOf<TestCase>(

        )

        //val solution = Solution()
        for (testCase in testCases) {
            "testCase: $testCase" {
                //solution.function(testCase) shouldBe testCase.expected
            }
        }
    }


}) {
    data class TestCase(
            val expected: Boolean
    )
}
