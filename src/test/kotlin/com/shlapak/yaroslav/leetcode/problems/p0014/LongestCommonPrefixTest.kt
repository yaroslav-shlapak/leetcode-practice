package com.shlapak.yaroslav.leetcode.problems.p0014

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [LongestCommonPrefixLegacy].
 */
class LongestCommonPrefixTest : FreeSpec({
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
                LongestCommonPrefixLegacy().longestCommonPrefix(input) shouldBe expected
            }
        }
    }
})
