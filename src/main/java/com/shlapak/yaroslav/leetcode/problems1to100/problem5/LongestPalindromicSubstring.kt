package com.shlapak.yaroslav.leetcode.problems1to100.problem5

import kotlin.test.assertEquals

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
class Solution2 {
    class TwoPointers {
        fun longestPalindrome(s: String): String {
            var max = 0
            var res = "${s[0]}"

            fun expand(lInit: Int, rInit: Int) {
                var l = lInit
                var r = rInit
                while (l >= 0 && r < s.length && s[r] == s[l]) {
                    if (max < r - l + 1) {
                        res = s.substring(l, r + 1)
                        max = r - l + 1
                    }
                    r++
                    l--
                }
            }

            for (i in s.indices) {
                expand(i, i)
                expand(i, i + 1)
            }
            return res
        }
    }
}

class LongestPalindromicSubstring {
    var start = 0
    var end = 0

    fun longestPalindrome(s: String): String {
        if (s.length == 1) return s
        for (i in s.indices) {
            if (i > 0) s.expand(i - 1, i)
            s.expand(i, i)
        }
        return s.substring(start, end)
    }

    private fun String.expand(s: Int, e: Int) {
        var r = e
        var l = s
        while (l >= 0 && r <= this.lastIndex && this[r] == this[l]) {
            r++
            l--
        }
        val candidateLength = r - l
        val lastLargestLength = end - start
        if (candidateLength > lastLargestLength) {
            end = r
            start = l + 1
        }
    }
}

class Solution {
    var longestStart = 0
    var longestEnd = 0
    var size = 0

    fun longestPalindrome(s: String): String {
        size = s.length
        if (size > 0) {
            longestEnd = 1
        }

        for (i in 0..size) {
            expand(s, i, i)
            expand(s, i, i + 1)
        }

        return s.substring(longestStart, longestEnd)
    }

    private fun expand(s: String, start: Int, end: Int) {
        var start = start
        var end = end
        while (start >= 0 && end < size && isPalindrome(s, start, end)) {
            start--
            end++
        }
    }

    private fun updateLongest(start: Int, end: Int) {
        if (end - start > longestEnd - longestStart) {
            longestEnd = end
            longestStart = start
        }
    }

    private fun isPalindrome(str: String, start: Int, end: Int): Boolean {
        val res = str[start] == str[end]

        if (res) {
            updateLongest(start, end + 1)
        }
        return res
    }
}

fun main() {
    assertEquals(Solution().longestPalindrome("abaaa"), "aba")
    assertEquals(Solution().longestPalindrome("babad"), "bab")
    assertEquals(Solution().longestPalindrome("cbbd"), "bb")
    assertEquals(Solution().longestPalindrome("bobbob"), "bobbob")
    assertEquals(Solution().longestPalindrome("obbo"), "obbo")
    assertEquals(Solution().longestPalindrome("oobo"), "obo")
}