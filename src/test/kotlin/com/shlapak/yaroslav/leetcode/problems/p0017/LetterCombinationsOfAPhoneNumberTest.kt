package com.shlapak.yaroslav.leetcode.problems.p0017

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/04/23.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problems.p0017.LetterCombinationsOfAPhoneNumber
 **/
class LetterCombinationsOfAPhoneNumberTest : FreeSpec({
    val inputs = mapOf(
            "23" to listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
    )

    "letterCombinations" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: $input, expected: $expected" {
                val actual = LetterCombinationsOfAPhoneNumber().letterCombinations(input)
                println(actual)
                actual shouldContainAll expected
            }
        }
    }
})