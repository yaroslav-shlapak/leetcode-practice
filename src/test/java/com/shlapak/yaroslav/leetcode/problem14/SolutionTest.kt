package com.shlapak.yaroslav.leetcode.problem14

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

import org.junit.jupiter.api.Assertions.*

/**
 * Created on 2019/04/13.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem14.Solution
 **/
object SolutionTest : Spek({
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

    group("longestCommonPrefix") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: ${input.asList()} expected: $expected") {
                Solution().longestCommonPrefix(input) shouldBe expected
            }
        }
    }
})