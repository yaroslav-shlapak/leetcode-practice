package com.shlapak.yaroslav.leetcode.problems1to100.problem29

/**
 * Created on 2019/05/22.
 * https://leetcode.com/problems/divide-two-integers/
 */
class Solution {
    fun divideNaive(dividend: Int, divisor: Int): Int {
        return if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE
        } else {
            dividend / divisor
        }
    }
}