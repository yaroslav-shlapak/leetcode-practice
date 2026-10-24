package com.shlapak.yaroslav.leetcode.problems.p0029

/**
 * LeetCode 29: Divide Two Integers.
 *
 * Divides integers without multiplication, division, or remainder operators.
 *
 * @see <a href="https://leetcode.com/problems/divide-two-integers/">Problem statement</a>
 */
class DivideTwoIntegers {
    fun divideNaive(dividend: Int, divisor: Int): Int {
        return if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE
        } else {
            dividend / divisor
        }
    }
}
