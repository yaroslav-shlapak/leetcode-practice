package com.shlapak.yaroslav.leetcode.problems.p0392

/**
 * LeetCode 392: is Subsequence.
 *
 * Checks whether one string is a subsequence of another.
 *
 * @see <a href="https://leetcode.com/problems/is-subsequence/">Problem statement</a>
 */
class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) return false
        var i = 0
        var j = 0
        while (i < s.length && j < t.length) {
            if (s.length - i > t.length - j) break
            if (s[i] == t[j]) {
                i++
                j++
            } else {
                j++
            }
        }
        return i == s.length
    }

    fun isSubsequence2(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        var j = 0
        for (i in t.indices) {
            if (s[j] == t[i]) {
                j++
            }
            if (j >= s.length) {
                return true
            }
        }
        return false
    }

}
