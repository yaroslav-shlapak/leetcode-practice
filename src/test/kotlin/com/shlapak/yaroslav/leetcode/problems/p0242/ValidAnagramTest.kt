package com.shlapak.yaroslav.leetcode.problems.p0242

import com.shlapak.yaroslav.leetcode.problems.p0242.ValidAnagramLegacy
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [ValidAnagramLegacy].
 */
class ValidAnagramTest : FreeSpec({
    "ValidAnagram" - {
        val testCases = listOf(
                Parameter(s = "", t = "", expected = true),
                Parameter(s = "anagram", t = "nagaram", expected = true),
                Parameter(s = "rat", t = "car", expected = false)
        )

        val solution = ValidAnagramLegacy()
        for (input in testCases) {
            "input: $input" {
                solution.isAnagram(s = input.s, t = input.t) shouldBe input.expected
            }
        }
    }


}) {
    data class Parameter(
            val s: String,
            val t: String,
            val expected: Boolean
    )
}
