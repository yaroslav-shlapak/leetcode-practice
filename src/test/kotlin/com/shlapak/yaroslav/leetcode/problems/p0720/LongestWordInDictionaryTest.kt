package com.shlapak.yaroslav.leetcode.problems.p0720

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests [LongestWordInDictionary.Trie] and [LongestWordInDictionary.SortingAndHashSet]. */
class LongestWordInDictionaryTest : FreeSpec({
    val approaches = listOf(
        "trie" to LongestWordInDictionary.Trie()::longestWord,
        "sorting and hash set" to LongestWordInDictionary.SortingAndHashSet()::longestWord
    )
    for ((name, longestWord) in approaches) {
        name - {
            "builds the word in the first example" {
                longestWord(arrayOf("w", "wo", "wor", "worl", "world")) shouldBe "world"
            }

            "chooses the lexicographically smallest longest word" {
                longestWord(arrayOf("a", "banana", "app", "appl", "ap", "apply", "apple")) shouldBe "apple"
            }

            "rejects words with missing intermediate or initial prefixes" {
                longestWord(arrayOf("a", "abc", "abce", "bc", "bcd")) shouldBe "a"
                longestWord(arrayOf("abc", "ab")) shouldBe ""
            }

            "handles unordered words, duplicates, and single-character ties without mutation" {
                val words = arrayOf("bat", "b", "ba", "a", "bat", "at")
                val original = words.toList()
                longestWord(words) shouldBe "bat"
                words.toList() shouldBe original
                longestWord(arrayOf("z", "a", "b")) shouldBe "a"
            }
        }
    }
})

// TODO review
