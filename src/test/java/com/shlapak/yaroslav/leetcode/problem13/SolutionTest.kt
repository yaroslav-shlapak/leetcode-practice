package com.shlapak.yaroslav.leetcode.problem13

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/04/12.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem13.Solution
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

    "romanToInt" - {
        inputs.asSequence().forEach { (expected, input) ->
            "input: $input expected: $expected" {
                Solution().romanToInt(input) shouldBe expected
            }
        }
    }
})