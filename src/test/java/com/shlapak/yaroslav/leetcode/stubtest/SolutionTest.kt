package com.shlapak.yaroslav.leetcode.stubtest

import io.kotest.core.spec.style.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode
 **/
class SolutionTest : FreeSpec({
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