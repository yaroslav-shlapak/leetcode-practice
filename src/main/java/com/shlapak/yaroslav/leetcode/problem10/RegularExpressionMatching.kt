package com.shlapak.yaroslav.leetcode.problem10

import kotlin.test.assertEquals

/**
 * Created on 2019/04/10.
 */
class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return s.matches(p.toRegex())
    }
}

fun main() {
    assertEquals(false, Solution().isMatch("aa", "a"))
    assertEquals(true, Solution().isMatch("aa", "a*"))
    assertEquals(true, Solution().isMatch("ab", ".*"))
    assertEquals(true, Solution().isMatch("aab", "c*a*b"))
    assertEquals(false, Solution().isMatch("mississippi", "mis*is*p*."))
}