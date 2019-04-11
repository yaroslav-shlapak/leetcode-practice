package com.shlapak.yaroslav.leetcode.problem10

/**
 * Created on 2019/04/10.
 */
class Solution {
    fun isMatch2(s: String, p: String): Boolean {
        return s.matches(p.toRegex())
    }
    fun isMatch(s: String, p: String): Boolean {
        var result = false
        when {
            p.isEmpty() -> result = false
            s == p -> result = true
        }

        return result

    }
}
