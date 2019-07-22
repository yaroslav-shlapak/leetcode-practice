package com.shlapak.yaroslav.leetcode.problem50

import kotlin.math.round

/**
 * Created on 2019/07/22.
 * https://leetcode.com/problems/powx-n/
 */
class Solution {
    fun myPow(x: Double, n: Int): Double {
        return when {
            n == 0 -> {
                1.0
            }
            x == 1.0 -> {
                1.0
            }
            x == -1.0 -> {
                if (n % 2 == 0) {
                    1.0
                } else {
                    -1.0
                }
            }
            n == Integer.MIN_VALUE -> {
                0.0
            }
            else -> {
                var count = n
                var mult = x
                if (n < 0) {
                    count = -n
                    mult = 1 / x
                }
                var res = 1.0
                while (count > 0) {
                    if (count and 0x1 != 0) {
                        res *= mult
                    }
                    mult *= mult
                    count /= 2
                }
                roundd(res)
            }
        }
    }

    private fun roundd(d: Double): Double {
        return round(d * 1_000_000) / 1_000_000
    }
}