package com.shlapak.yaroslav.leetcode.problems401to500.problem409

/**
 * 409. Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome/
 *
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 *
 * A palindrome is a string that reads the same forward and backward.
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */
class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        return when (s.length) {
            0 -> 0
            1 -> 1
            else -> {
                val map = mutableMapOf<Char, Int>()
                var count = 0
                s.forEach { ch ->
                    val value = map[ch]
                    if (value == null) {
                        map[ch] = 1
                    } else {
                        val newValue = value.inc()
                        map[ch] = newValue
                        if (newValue % 2 == 0) {
                            count += 2
                        }
                    }
                }
                if (map.any { it.value % 2 == 1 }) {
                    count++
                }
                count
            }
        }
    }
}