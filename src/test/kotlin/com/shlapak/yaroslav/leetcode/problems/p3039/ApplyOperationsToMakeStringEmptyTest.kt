package com.shlapak.yaroslav.leetcode.problems.p3039

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests [ApplyOperationsToMakeStringEmpty.FrequencyAndLastIndex]. */
class ApplyOperationsToMakeStringEmptyTest : FreeSpec({
    val cases = listOf(
        Triple("example with repeated letters", "aabcbbca", "ba"),
        Triple("example with distinct letters", "abcd", "abcd"),
        Triple("single character", "z", "z"),
        Triple("one most frequent letter", "abaaa", "a"),
        Triple("last occurrence determines order", "abab", "ab"),
        Triple("reverse alphabetical order", "zzyyxx", "zyx"),
        Triple("all letters tied", "zyxwvutsrqponmlkjihgfedcba", "zyxwvutsrqponmlkjihgfedcba"),
        Triple("maximum length", "a".repeat(500_000), "a"),
    )

    cases.forEach { (name, input, expected) ->
        name {
            ApplyOperationsToMakeStringEmpty.FrequencyAndLastIndex().lastNonEmptyString(input) shouldBe expected
        }
    }
})
