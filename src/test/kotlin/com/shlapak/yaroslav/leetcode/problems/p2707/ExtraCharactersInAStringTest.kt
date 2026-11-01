package com.shlapak.yaroslav.leetcode.problems.p2707

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests both approaches to [ExtraCharactersInAString] for optimal non-overlapping matches. */
class ExtraCharactersInAStringTest : FreeSpec({
    val approaches = listOf(
        "dynamic programming" to ExtraCharactersInAString.DynamicProgramming()::minExtraChar,
        "trie" to ExtraCharactersInAString.Trie()::minExtraChar
    )
    for ((name, minExtraChar) in approaches) {
        name - {

            "handles the problem examples" {
                minExtraChar("leetscode", arrayOf("leet", "code", "leetcode")) shouldBe 1
                minExtraChar("sayhelloworld", arrayOf("hello", "world")) shouldBe 3
            }

            "handles no matches, complete coverage, and a single character" {
                minExtraChar("abc", arrayOf("xyz", "abcd")) shouldBe 3
                minExtraChar("a", arrayOf("a")) shouldBe 0
                minExtraChar("a", arrayOf("b")) shouldBe 1
                minExtraChar("applepie", arrayOf("apple", "pie")) shouldBe 0
            }

            "finds the best segmentation instead of choosing the longest match" {
                minExtraChar("abcdef", arrayOf("abcd", "abc", "def")) shouldBe 0
                minExtraChar("abcde", arrayOf("abc", "bcd", "de")) shouldBe 0
            }

            "reuses words and counts extras between matches" {
                minExtraChar("aaxaayaaa", arrayOf("aa", "aaa")) shouldBe 2
                minExtraChar("aaaaa", arrayOf("aa")) shouldBe 1
            }
        }
    }
})

// TODO review
