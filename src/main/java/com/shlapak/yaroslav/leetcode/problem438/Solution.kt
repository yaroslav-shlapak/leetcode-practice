package com.shlapak.yaroslav.leetcode.problem438

/**
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
class Solution {
    fun findAnagrams2(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()

        for (i in 0 .. s.length - p.length) {
            if (isAnagram(s.substring(i, i + p.length), p)) {
                result.add(i)
            }
        }

        return result
    }

    fun findAnagrams(s: String, p: String): List<Int> {

        if (p.length > s.length) return listOf()

        val result = mutableListOf<Int>()

        val numberOfLetters = 26
        val sFreq = IntArray(numberOfLetters)
        val pFreq = IntArray(numberOfLetters)

        for (i in p.indices) {
            sFreq[s[i] - 'a']++
            pFreq[p[i] - 'a']++
        }

        if (sFreq.contentEquals(pFreq)) result.add(0)

        for (i in 0 until s.length - p.length) {

            //Sliding window (size p.length)
            sFreq[s[i] - 'a']--
            sFreq[s[i + p.length] - 'a']++

            if (sFreq.contentEquals(pFreq)) result.add(i + 1)
        }

        return result
    }

    fun isAnagram(s: String, t: String): Boolean {
        val numberOfLetters = 26
        val c = IntArray(numberOfLetters)
        for (l in s) {
            c[l - 'a']++;
        }
        for (l in t) {
            c[l - 'a']--;
        }
        for (i in c) {
            if (i != 0) return false
        }
        return true
    }
}