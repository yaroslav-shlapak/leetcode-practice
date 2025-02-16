package com.shlapak.yaroslav.leetcode.problems1to100.problem5

import kotlin.test.assertEquals

/**
 * Created on 2019/04/08.
 */
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
        val size = end - start
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