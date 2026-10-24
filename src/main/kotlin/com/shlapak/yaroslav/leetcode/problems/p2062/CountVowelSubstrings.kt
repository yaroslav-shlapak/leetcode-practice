package com.shlapak.yaroslav.leetcode.problems.p2062

/**
 * LeetCode 2062: Count Vowel Substrings of a String.
 *
 * Counts substrings containing every vowel and no consonants.
 *
 * @see <a href="https://leetcode.com/problems/count-vowel-substrings-of-a-string/">Problem statement</a>
 */
class CountVowelSubstrings {
    class BruteForce {
        fun countVowelSubstrings(word: String): Int {
            val set = setOf('a', 'e', 'i', 'o', 'u')
            var count = 0
            for (i in 0 until word.length) {
                val map = mutableSetOf<Char>()
                var j = i
                while (j < word.length && set.contains(word[j])) {
                    map.add(word[j])
                    if (map.size >= set.size) {
                        count++
                    }
                    j++
                }
            }
            return count
        }
    }
}
