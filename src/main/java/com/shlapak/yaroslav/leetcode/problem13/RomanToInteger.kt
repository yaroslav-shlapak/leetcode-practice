package com.shlapak.yaroslav.leetcode.problem13

/**
 * Created on 2019/04/12.
 * https://leetcode.com/problems/roman-to-integer/
 */
class Solution {
    fun romanToInt(s: String): Int {
        val map = mapOf(
                "" to 0,
                "I" to 1,
                "II" to 2,
                "III" to 3,
                "IV" to 4,
                "V" to 5,
                "VI" to 6,
                "VII" to 7,
                "VIII" to 8,
                "IX" to 9,
                "X" to 10,
                "XX" to 20,
                "XXX" to 30,
                "XL" to 40,
                "L" to 50,
                "LX" to 60,
                "LXX" to 70,
                "LXXX" to 80,
                "XC" to 90,
                "C" to 100,
                "CC" to 200,
                "CCC" to 300,
                "CD" to 400,
                "D" to 500,
                "DC" to 600,
                "DCC" to 700,
                "DCCC" to 800,
                "CM" to 900,
                "M" to 1000,
                "MM" to 2000,
                "MMM" to 3000
        )
        var n = 0
        var j = 0
        while (j < s.length) {
            val end = if (s.length >= j + 4) j + 4 else s.length
            val start = j
            for (i in end downTo start) {
                val nn = map[s.substring(start, i)]
                if (nn != null) {
                    n += nn
                    j = i
                    break
                }
            }
        }

        return n
    }
}