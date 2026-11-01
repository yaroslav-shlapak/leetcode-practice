package com.shlapak.yaroslav.leetcode.problems.p3043

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [FindTheLengthOfTheLongestCommonPrefix] and [FindTheLengthOfTheLongestCommonPrefix.Trie]
 * for decimal prefixes and input preservation.
 */
class FindTheLengthOfTheLongestCommonPrefixTest : FreeSpec({
    val approaches = listOf(
        "hash set" to FindTheLengthOfTheLongestCommonPrefix()::longestCommonPrefix,
        "trie" to FindTheLengthOfTheLongestCommonPrefix.Trie()::longestCommonPrefix
    )
    for ((name, longestCommonPrefix) in approaches) {
        name - {

            "handles the problem examples" {
                longestCommonPrefix(intArrayOf(1, 10, 100), intArrayOf(1000)) shouldBe 3
                longestCommonPrefix(intArrayOf(1, 2, 3), intArrayOf(4, 4, 4)) shouldBe 0
            }

            "matches prefixes rather than suffixes or internal digits" {
                longestCommonPrefix(intArrayOf(12345), intArrayOf(12399)) shouldBe 3
                longestCommonPrefix(intArrayOf(12345), intArrayOf(234)) shouldBe 0
                longestCommonPrefix(intArrayOf(12345), intArrayOf(92345)) shouldBe 0
            }

            "handles full matches, zeros within numbers, and the maximum value" {
                longestCommonPrefix(intArrayOf(100_000_000), intArrayOf(100_000_000)) shouldBe 9
                longestCommonPrefix(intArrayOf(10002), intArrayOf(10009)) shouldBe 4
                longestCommonPrefix(intArrayOf(7, 7), intArrayOf(7)) shouldBe 1
            }

            "finds the best cross-array pair and preserves both inputs" {
                val arr1 = intArrayOf(91, 56789, 123)
                val arr2 = intArrayOf(124, 56780, 98)
                val original1 = arr1.toList()
                val original2 = arr2.toList()

                longestCommonPrefix(arr1, arr2) shouldBe 4
                longestCommonPrefix(arr2, arr1) shouldBe 4
                arr1.toList() shouldBe original1
                arr2.toList() shouldBe original2
            }
        }
    }
})

// TODO review
