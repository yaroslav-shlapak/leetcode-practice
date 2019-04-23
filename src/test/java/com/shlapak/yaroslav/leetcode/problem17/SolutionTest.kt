package com.shlapak.yaroslav.leetcode.problem17

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/04/23.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem17.Solution
 **/
object SolutionTest : Spek({
    val inputs = mapOf(
            "23" to listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
    )

    group("letterCombinations") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: $input, expected: $expected") {
                val actual = Solution().letterCombinations(input)

                actual shouldBe expected
            }
        }
    }
})