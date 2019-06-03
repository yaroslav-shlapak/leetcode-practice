package com.shlapak.yaroslav.leetcode.problem20

import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

/**
 * Created on 2019/05/03.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem20.Solution
 **/
class SolutionTest : FreeSpec({
    val inputs = mapOf(
            "()" to true,
            "()[]{}" to true,
            "(]" to false,
            "([)]" to false,
            "{[]}" to true,
            "{{}[][[[]]]}" to true
    )

    "isValid" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: $input, expected: $expected" {
                val actual = Solution().isValid(input)
                println(actual)
                actual shouldBe expected
            }
        }
    }
})