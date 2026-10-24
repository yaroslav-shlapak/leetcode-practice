package com.shlapak.yaroslav.leetcode.problems.p0020

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/05/03.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problems.p0020.ValidParenthesesLegacy
 **/
class ValidParenthesesTest : FreeSpec({
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
                val actual = ValidParenthesesLegacy().isValid(input)
                println(actual)
                actual shouldBe expected
            }
        }
    }
})