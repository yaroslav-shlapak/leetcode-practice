package com.shlapak.yaroslav.leetcode.problems.p0017

import com.shlapak.yaroslav.leetcode.support.shouldMatchUnordered
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [LetterCombinationsOfAPhoneNumber].
 */
class LetterCombinationsOfAPhoneNumberTest : FreeSpec({
    val inputs = mapOf(
            "23" to listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
    )

    "letterCombinations" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: $input, expected: $expected" {
                val actual = LetterCombinationsOfAPhoneNumber().letterCombinations(input)
                println(actual)
                actual.shouldMatchUnordered(expected)
            }
        }
    }
})
