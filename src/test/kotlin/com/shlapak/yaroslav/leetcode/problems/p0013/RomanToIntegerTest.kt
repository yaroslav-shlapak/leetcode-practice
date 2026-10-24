package com.shlapak.yaroslav.leetcode.problems.p0013

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [RomanToIntegerLegacy].
 */
class RomanToIntegerTest : FreeSpec({
    val inputs = mapOf(
            1 to "I",
            3 to "III",
            4 to "IV",
            6 to "VI",
            9 to "IX",
            58 to "LVIII",
            1994 to "MCMXCIV",
            3999 to "MMMCMXCIX",
            3009 to "MMMIX",
            44 to "XLIV",
            404 to "CDIV",
            55 to "LV",
            77 to "LXXVII",
            88 to "LXXXVIII",
            888 to "DCCCLXXXVIII",
            3333 to "MMMCCCXXXIII"

    )

    "romanToInt" - {
        inputs.asSequence().forEach { (expected, input) ->
            "input: $input expected: $expected" {
                RomanToIntegerLegacy().romanToInt(input) shouldBe expected
            }
        }
    }
})
