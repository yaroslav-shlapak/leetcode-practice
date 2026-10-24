package com.shlapak.yaroslav.leetcode.problems.p0680

/**
 * LeetCode 680: Valid Palindrome II.
 *
 * Checks whether a string becomes a palindrome after at most one deletion.
 *
 * @see <a href="https://leetcode.com/problems/valid-palindrome-ii/">Problem statement</a>
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
