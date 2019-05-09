package com.shlapak.yaroslav.leetcode.problem10

/**
 * Created on 2019/04/10.
 * https://leetcode.com/problems/regular-expression-matching/
 */
class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return s.matches(p.toRegex())
    }
}
