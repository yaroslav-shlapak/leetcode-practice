package com.shlapak.yaroslav.leetcode.problems1to100.problem89

/**
 * 89. Gray Code
 * https://leetcode.com/problems/gray-code/description/
 */
class GreyCode {
    class Solution {
        fun grayCode(n: Int): List<Int> {
            // 4
            // [0, 16] 010000
            // 00 01 11 10 110 100
            // 0  1  3  2  6   4
            // 5
            // 00 01 11 10 110 100 101
            // 0  1  3  2  6   4   5
            // 8
            // 00 01 11 10 110 100 101 111 1111 1110 1100 1000
            // 00 01 11 10 110 111 101 100 1100 1101 1111 1110
            // 0  1  3  2  6   4   5
            // 101 - 5, 110 - 6,
            // 0 1 3 2 -> reverse -> + high bit
            //  x ^ (x shr 1)
            var i = 0
            val end = (1 shl n) - 1
            val res = mutableListOf<Int>()
            var cur = 0
            // 0 - 00 - 0
            // 1 - 01 - 01
            // 2 - 11 - 11
            // 3 - 10 - 10
            // 4 - 110 - 100 xor 010


            while (i <= end) {
                cur = i xor (i shr 1)
                res.add(cur)
                i++
            }
            return res
        }
    }
}