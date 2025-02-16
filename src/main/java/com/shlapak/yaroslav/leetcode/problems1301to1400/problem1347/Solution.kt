package com.shlapak.yaroslav.leetcode.problems1301to1400.problem1347

import kotlin.math.absoluteValue
import kotlin.math.max

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 *
 * You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 *
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 *
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s.length == t.length
 * s and t consist of lowercase English letters only.
 */
class Solution {
    fun minSteps(s: String, t: String): Int {
        val numberOfLetters = 26
        val c = IntArray(numberOfLetters)
        for (l in s) {
            c[l - 'a']++;
        }
        for (l in t) {
            c[l - 'a']--;
        }
//        println("c: ${c.toList().mapIndexed { index, i -> (index + 'a'.code).toChar() }}")
//        println("c: ${c.toList()}")
        val negatives = c.asSequence().filter { it < 0 }.sumOf { it }.absoluteValue
        val positives = c.asSequence().filter { it > 0 }.sumOf { it }
        return max(negatives, positives)
    }

    private fun isAnagram(s: String, t: String): Boolean {
        val sortedS = s.toList().sorted()
        val sortedT = t.toList().sorted()

        return sortedS == sortedT
    }

    private fun isAnagram2(s: String, t: String): Boolean {
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