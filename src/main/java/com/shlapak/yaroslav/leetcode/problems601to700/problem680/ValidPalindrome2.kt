package com.shlapak.yaroslav.leetcode.problems601to700.problem680

/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
class ValidPalindrome2 {
    fun validPalindrome(s: String): Boolean {
        var r = s.length - 1
        var l = 0
        while (r > l) {
            if (s[r] != s[l]) {
                return validPalindrome(s, r - 1, l) || validPalindrome(s, r, l + 1)
            }
            r--
            l++
        }

        return true
    }

    private fun validPalindrome(s: String, right: Int, left: Int): Boolean {
        var r = right
        var l = left
        while (r > l) {
            if (s[r] != s[l]) {
                return false
            }
            r--
            l++
        }

        return true
    }
}