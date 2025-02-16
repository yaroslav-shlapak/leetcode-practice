package com.shlapak.yaroslav.leetcode.problems1to100.problem8

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
        run loop@{
            str.asSequence().forEach { char ->
                when {
                    char.isDigit() -> {
                        s.append(char)
                    }
                    s.isEmpty() && (char == '-' || char == '+') -> {
                        s.append(char)
                    }
                    char != ' ' && s.isEmpty() -> {
                        return 0
                    }
                    !char.isDigit() && s.isNotEmpty() -> {
                        return@loop
                    }
                }
            }
        }

        return try {
            s.toString().toInt()
        } catch (e: Throwable) {
            when {
                s.length > 4 && s[0] == '-' -> {
                    Int.MIN_VALUE
                }
                s.length > 4 -> {
                    Int.MAX_VALUE
                }
                else -> {
                    0
                }
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
    assertEquals(3, Solution().myAtoi("3.14"))
    assertEquals(1, Solution().myAtoi("+1"))
    assertEquals(123, Solution().myAtoi("   +123"))
    assertEquals(-12, Solution().myAtoi("  -0012a42"))
    assertEquals(Int.MAX_VALUE, Solution().myAtoi("20000000000000000000"))
    assertEquals(-5, Solution().myAtoi("-5-"))
}