package com.shlapak.yaroslav.leetcode.problem12

import io.kotlintest.shouldBe
import io.kotlintest.specs.FreeSpec

/**
 * Created on 2019/04/12.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem12.Solution
 **/
class SolutionTest : FreeSpec({
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

    "intToRoman" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: $input expected: $expected" {
                Solution().intToRoman(input) shouldBe expected
            }
        }
    }
})