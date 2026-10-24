package com.shlapak.yaroslav.leetcode.problems.p0409

/**
 * LeetCode 409: Longest Palindrome.
 *
 * Finds the greatest palindrome length obtainable from available characters.
 *
 * @see <a href="https://leetcode.com/problems/longest-palindrome/">Problem statement</a>
 */
class LongestPalindrome {

    class Optimal {
        fun longestPalindrome(s: String): Int {
            if (s.length == 1) return 1
            val arr = IntArray(128)
            var count = 0

            for (ch in s) {
                val idx = ch.code
                arr[idx]++
                if (arr[idx] % 2 == 0) {
                    count += 2
                }
            }

            if (count < s.length) {
                count++
            }

            return count
        }
    }

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

    fun longestPalindrome2(s: String) : Int {
        val map = mutableSetOf<Char>()
        var count = 0;
        if (s.length == 1) return 1

        for (i in s.indices) {
            val key = s[i]
            if (map.contains(key)) {
                count += 2
                map.remove(key)
            } else {
                map.add(key)
            }
        }
        if (count < s.length) {
            count++
        }
        return count
    }
}
