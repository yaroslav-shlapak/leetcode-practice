package com.shlapak.yaroslav.leetcode.problem12

/**
 * Created on 2019/04/12.
 * https://leetcode.com/problems/integer-to-roman/
 */
class Solution {
    /*
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Input is guaranteed to be within the range from 1 to 3999.
     */

    fun intToRoman(num: Int): String {
        val map = mapOf(
                0 to "",
                1 to "I",
                2 to "II",
                3 to "III",
                4 to "IV",
                5 to "V",
                6 to "VI",
                7 to "VII",
                8 to "VIII",
                9 to "IX",
                10 to "X",
                20 to "XX",
                30 to "XXX",
                40 to "XL",
                50 to "L",
                60 to "LX",
                70 to "LXX",
                80 to "LXXX",
                90 to "XC",
                100 to "C",
                200 to "CC",
                300 to "CCC",
                400 to "CD",
                500 to "D",
                600 to "DC",
                700 to "DCC",
                800 to "DCCC",
                900 to "CM",
                1000 to "M",
                2000 to "MM",
                3000 to "MMM"
        )

        val list = mutableListOf<String?>()
        var n = num
        if (num in 1..3999) {
            var count = 0
            while (n > 0) {
                val rem = n % 10
                val s = when (count) {
                    0 -> {
                        map[rem]
                    }
                    1 -> {
                        map[rem * 10]
                    }
                    2 -> {
                        map[rem * 100]
                    }
                    3 -> {
                        map[rem * 1000]
                    }
                    else -> {
                        ""
                    }
                }
                list.add(s)
                count++
                n /= 10
            }
        }
        list.reverse()
        val result = StringBuilder()
        list.asSequence().forEach {
            result.append(it)
        }

        return result.toString()
    }
}