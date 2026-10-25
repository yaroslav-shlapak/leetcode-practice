package com.shlapak.yaroslav.leetcode.problems.p0030

import java.util.*

/**
 * LeetCode 30: Substring with Concatenation of All Words.
 *
 * Finds substrings formed by concatenating every supplied word once.
 *
 * @see <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/">Problem statement</a>
 */
class SubstringWithConcatenationOfAllWords {


    lateinit var counts: MutableMap<String, Int>
    lateinit var res: MutableList<Int>
    var inputStringLength = 0
    var numberOfWords = 0
    var wordLength = 0// same length
    lateinit var searchable: String

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        if (init(words, s)) return res
        for (stringIndex in 0..inputStringLength - numberOfWords * wordLength) {
            search(stringIndex)
        }
        return res
    }

    private fun search(stringIndex: Int) {
        val seen = mutableMapOf<String, Int>()
        var countOfMatchedWords = 0
        while (countOfMatchedWords < numberOfWords) {
            val startIndex = stringIndex + countOfMatchedWords * wordLength
            val endIndex = stringIndex + (countOfMatchedWords + 1) * wordLength
            val word = searchable.substring(startIndex, endIndex)
            if (counts.containsKey(word)) {
                seen.put(word, seen.getOrDefault(word, 0) + 1)
                if (seen.getOrDefault(word, 0) > counts.getOrDefault(word, 0)) {
                    break
                }
            } else {
                break
            }
            countOfMatchedWords++
        }
        if (countOfMatchedWords == numberOfWords) {
            res.add(stringIndex)
        }
    }

    private fun init(words: Array<String>, s: String): Boolean {
        res = mutableListOf()
        numberOfWords = words.size
        if (numberOfWords == 0) {
            return true
        }
        searchable = s
        counts = mutableMapOf()
        for (word in words) {
            counts[word] = counts.getOrDefault(word, 0) + 1
        }
        inputStringLength = s.length
        wordLength = words[0].length // same length
        return false
    }

}

/**
 * Uses word-sized sliding windows instead of enumerating permutations of the supplied words.
 */
class SubstringWithConcatenationOfAllWordsAlternative2 {
    /**
     * Tracks word frequencies for every starting offset modulo the word length.
     * Clears the window on unknown words and shrinks it when a word appears too often.
     * Empty word lists or empty words produce no matches. Neither input is modified.
     *
     * Time: O((n + m) * w) with expected constant-time hash-map operations, where n is the
     * string length, m is the word count, and w is the word length.
     * Space: O(m * w + r), including r returned indices.
     */
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        if (words.isEmpty() || words[0].isEmpty()) return emptyList()
        val wordLength = words[0].length
        if (words.size > s.length / wordLength) return emptyList()
        val expected = words.groupingBy { it }.eachCount()
        val result = mutableListOf<Int>()

        for (offset in 0 until minOf(wordLength, s.length)) {
            val seen = mutableMapOf<String, Int>()
            var left = offset
            var count = 0
            var right = offset
            while (right + wordLength <= s.length) {
                val word = s.substring(right, right + wordLength)
                right += wordLength
                if (word !in expected) {
                    seen.clear()
                    count = 0
                    left = right
                    continue
                }

                seen[word] = seen.getOrDefault(word, 0) + 1
                count++
                while (seen.getValue(word) > expected.getValue(word)) {
                    val outgoing = s.substring(left, left + wordLength)
                    seen[outgoing] = seen.getValue(outgoing) - 1
                    count--
                    left += wordLength
                }
                if (count == words.size) result.add(left)
            }
        }
        return result
    }
}
