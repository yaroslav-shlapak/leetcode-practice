package com.shlapak.yaroslav.leetcode.problems.p0010

/**
 * LeetCode 10: Regular Expression Matching.
 *
 * Matches a complete string against a pattern containing dots and asterisks.
 *
 * @see <a href="https://leetcode.com/problems/regular-expression-matching/">Problem statement</a>
 */
class RegularExpressionMatching {
    fun isMatch(s: String, p: String): Boolean {
        return s.matches(p.toRegex())
    }
}
