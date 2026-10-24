package com.shlapak.yaroslav.leetcode.problems.p0007

import kotlin.test.assertEquals

/**
 * LeetCode 7: Reverse Integer.
 *
 * Reverses a signed integer while respecting 32-bit bounds.
 *
 * @see <a href="https://leetcode.com/problems/reverse-integer/">Problem statement</a>
 */
class ReverseInteger {
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
    assertEquals(0, ReverseInteger().reverse(0))
    assertEquals(321, ReverseInteger().reverse(123))
    assertEquals(-321, ReverseInteger().reverse(-123))
    assertEquals(21, ReverseInteger().reverse(120))
    assertEquals(0, ReverseInteger().reverse(Int.MAX_VALUE + 1))
    assertEquals(0, ReverseInteger().reverse(Int.MIN_VALUE - 1))
}
