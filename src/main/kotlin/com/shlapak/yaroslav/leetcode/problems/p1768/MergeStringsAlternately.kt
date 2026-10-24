package com.shlapak.yaroslav.leetcode.problems.p1768

/**
 * LeetCode 1768: Merge Strings Alternately.
 *
 * Merges two strings by alternating their characters.
 *
 * @see <a href="https://leetcode.com/problems/merge-strings-alternately/">Problem statement</a>
 */
class MergeStringsAlternately {
    fun mergeAlternately(word1: String, word2: String): String {
        val max = maxOf(word1.length, word2.length)
        val b = StringBuilder()
        for (i in 0 until max) {
            if (i < word1.length) {
                b.append(word1[i])
            }
            if (i < word2.length) {
                b.append(word2[i])
            }
        }
        return b.toString()
    }
}
