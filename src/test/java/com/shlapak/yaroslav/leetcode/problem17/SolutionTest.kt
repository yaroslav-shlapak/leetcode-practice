package com.shlapak.yaroslav.leetcode.problem17

import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.specs.FreeSpec

/**
 * Created on 2019/04/23.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem17.Solution
 **/
class SolutionTest : FreeSpec({
    val inputs = mapOf(
            "23" to listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
    )

    "letterCombinations" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: $input, expected: $expected" {
                val actual = Solution().letterCombinations(input)
                println(actual)
                actual shouldContainAll expected
            }
        }
    }
})