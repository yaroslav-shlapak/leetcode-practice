package com.shlapak.yaroslav.leetcode.problems.p1347

import kotlin.math.absoluteValue
import kotlin.math.max

/**
 * LeetCode 1347: Minimum Number of Steps to Make Two Strings Anagram.
 *
 * Counts replacements needed to make one string an anagram of another.
 *
 * @see <a href="https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/">Problem statement</a>
 */
class MinimumNumberOfStepsToMakeTwoStringsAnagram {
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
