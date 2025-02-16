package com.shlapak.yaroslav.leetcode.problems1to100.problem9

import kotlin.test.assertEquals

/**
 * Created on 2019/04/10.
 * https://leetcode.com/problems/palindrome-number/
 */
class Solution {
    fun isPalindrome1(x: Int): Boolean {
        if (x < 0) return false
        if (x / 10 < 1) return true
        val s = x.toString()

        return s == s.reversed()
    }

    fun isPalindrome2(x: Int): Boolean {
        if (x < 0) return false
        if (x / 10 < 1) return true
        val s = x.toString()

        for (i in 0..s.length / 2) {
            if (s[i] != s[s.length - i - 1]) {
                return false
            }
        }

        return true
    }

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        if (x / 10 < 1) return true
        var straight = x
        var reversed = straight % 10
        while (straight / 10 > 0) {
            straight /= 10
            reversed = reversed * 10 + straight % 10
        }

        straight = x
        while (straight / 10 > 0) {
            if (straight % 10 != reversed % 10) {
                return false
            }
            straight /= 10
            reversed /= 10
        }

        return true
    }
}

fun main() {
    assertEquals(false, Solution().isPalindrome(123))
    assertEquals(true, Solution().isPalindrome(121))
    assertEquals(false, Solution().isPalindrome(-121))
    assertEquals(false, Solution().isPalindrome(10))
    assertEquals(true, Solution().isPalindrome(101))
    assertEquals(true, Solution().isPalindrome(10101))
    assertEquals(false, Solution().isPalindrome(-10101))
    assertEquals(true, Solution().isPalindrome(12121))
}