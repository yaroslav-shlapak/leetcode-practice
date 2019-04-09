package com.shlapak.yaroslav.leetcode.problem7

import kotlin.test.assertEquals

/**
 * Created on 2019/04/09.
 * https://leetcode.com/problems/reverse-integer/
 */
class Solution {
    fun reverse(x: Int): Int {
        if (x / 10 == 0) return x

        val s = x.toString()
        val res = StringBuilder()
        if (s[0] == '-') res.append("-")
        s.reversed().asSequence().filter { it.isDigit() }.forEach { char ->
            res.append(char)
        }
        return try {
            res.toString().toInt()
        } catch (e: Throwable) {
            0
        }
    }
}

fun main() {
    assertEquals(Solution().reverse(0), 0)
    assertEquals(Solution().reverse(123), 321)
    assertEquals(Solution().reverse(-123), -321)
    assertEquals(Solution().reverse(120), 21)
    assertEquals(Solution().reverse(Int.MAX_VALUE + 1), 0)
    assertEquals(Solution().reverse(Int.MIN_VALUE - 1), 0)
}