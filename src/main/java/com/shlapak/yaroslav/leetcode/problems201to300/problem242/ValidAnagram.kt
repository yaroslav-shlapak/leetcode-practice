package com.shlapak.yaroslav.leetcode.problems201to300.problem242

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
class ValidAnagram2 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val numberOfLowercaseLetters = 26
        val arr = IntArray(numberOfLowercaseLetters) { 0 }
        for (i in s.indices) {
            arr[s[i] - 'a']++
            arr[t[i] - 'a']--
        }
        for (i in arr) {
            if (i != 0) return false
        }
        return true
    }
}


class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sortedS = s.toList().sorted()
        val sortedT = t.toList().sorted()

        return sortedS == sortedT
    }

    fun isAnagram2(s: String, t: String): Boolean {
        val c = IntArray(26)
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

class ValidAnagram {
    // Given two strings s and t, return true if t is an
    // anagram
    // of s, and false otherwise.
    // Anagram --
    // a word, phrase, or name formed by rearranging the letters of another,
    // such as spar, formed from rasp.
    fun isAnagram(s: String, t: String): Boolean {
        return s.toList().sorted() == t.toList().sorted()
    }
}