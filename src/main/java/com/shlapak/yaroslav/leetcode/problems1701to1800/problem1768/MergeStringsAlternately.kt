package com.shlapak.yaroslav.leetcode.problems1701to1800.problem1768

/*
 * 1768. Merge Strings Alternately
 * https://leetcode.com/problems/merge-strings-alternately/
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