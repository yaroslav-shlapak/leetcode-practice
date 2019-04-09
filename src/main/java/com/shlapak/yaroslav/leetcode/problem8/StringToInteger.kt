package com.shlapak.yaroslav.leetcode.problem8

import kotlin.test.assertEquals

/**
 * Created on 2019/04/09.
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
class Solution {
    fun myAtoi(str: String): Int {
        if (str.isBlank() || str.isEmpty()) {
            return 0
        }
        val s = StringBuilder()
        str.asSequence().forEach { char ->
            if (char.isDigit() || char == '-') {
                s.append(char)
            } else if (char != ' ' && s.isEmpty()) {
                return 0
            }
        }

        val res = try {
            s.toString().toLong()
        } catch (e: Throwable) {
            0L
        }
        return when {
            (res >= Int.MAX_VALUE) -> {
                Int.MAX_VALUE
            }
            (res <= Int.MIN_VALUE) -> {
                Int.MIN_VALUE
            }
            else -> {
                res.toInt()
            }
        }
    }
}

fun main() {
    assertEquals(0, Solution().myAtoi("0"))
    assertEquals(123, Solution().myAtoi("123"))
    assertEquals(-123, Solution().myAtoi("-123"))
    assertEquals(-123, Solution().myAtoi("         -123dsads"))
    assertEquals(120, Solution().myAtoi("120"))
    assertEquals(Int.MAX_VALUE, Solution().myAtoi((Int.MAX_VALUE.toLong() + 1).toString()))
    assertEquals(Int.MIN_VALUE, Solution().myAtoi((Int.MIN_VALUE.toLong() - 1).toString()))
    assertEquals(42, Solution().myAtoi("42"))
    assertEquals(-42, Solution().myAtoi("   -42"))
    assertEquals(4193, Solution().myAtoi("4193 with words"))
    assertEquals(0, Solution().myAtoi("words and 987"))
    assertEquals(-2147483648, Solution().myAtoi("-9128347233"))
    assertEquals(0, Solution().myAtoi(""))
    assertEquals(0, Solution().myAtoi(" "))
    assertEquals(0, Solution().myAtoi("-"))
}