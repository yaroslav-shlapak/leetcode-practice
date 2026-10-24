package com.shlapak.yaroslav.leetcode.problems.p0010

/**
 * Created on 2019/04/10.
 * https://leetcode.com/problems/regular-expression-matching/
 */
class RegularExpressionMatching {
    fun isMatch(s: String, p: String): Boolean {
        return s.matches(p.toRegex())
    }
}
