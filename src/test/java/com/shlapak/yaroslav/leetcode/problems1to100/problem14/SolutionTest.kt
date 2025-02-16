package com.shlapak.yaroslav.leetcode.problems1to100.problem14

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Created on 2019/04/13.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem14.Solution
 **/
class SolutionTest : FreeSpec({
    val inputs = mapOf(
            arrayOf("flower", "flow", "flight") to "fl",
            arrayOf("dog", "racecar", "car") to "",
            arrayOf("dog", "dog", "dog") to "dog",
            arrayOf("dog", "", "dog") to "",
            arrayOf("dogee", "doger", "dogest", "doge") to "doge",
            arrayOf("", "", "") to "",
            arrayOf("aaaa", "aaa", "") to "",
            arrayOf("aaaa", "", "aaa") to "",
            arrayOf("aaa", "aaaa", "") to "",
            emptyArray<String>() to "",
            arrayOf("") to "",
            arrayOf("abababababab") to "abababababab",
            arrayOf("abababababab", "ababab") to "ababab",
            arrayOf("abababababab", "ababab", "abab") to "abab",
            arrayOf("abababababab", "abab", "ababab") to "abab"
    )

    "longestCommonPrefix" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input.asList()} expected: $expected" {
                Solution().longestCommonPrefix(input) shouldBe expected
            }
        }
    }
})