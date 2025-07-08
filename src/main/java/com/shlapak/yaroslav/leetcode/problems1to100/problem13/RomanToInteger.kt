package com.shlapak.yaroslav.leetcode.problems1to100.problem13

/**
 * Created on 2019/04/12.
 * https://leetcode.com/problems/roman-to-integer/
 */

class RomanToInteger {

    class BruteForce {
        fun romanToInt(s: String): Int {
            val map = mapOf(
                'I' to 1,
                'V' to 5,
                'X' to 10,
                'L' to 50,
                'C' to 100,
                'D' to 500,
                'M' to 1000
            )
            var total = 0
            var prevValue = 0

            for (char in s) {
                val currentValue = map[char] ?: 0
                total += if (currentValue > prevValue) {
                    currentValue - 2 * prevValue // subtract the previous value twice if it's less than the current
                } else {
                    currentValue
                }
                prevValue = currentValue
            }

            return total
        }
    }

    class Clever {
        fun romanToInt(s: String): Int {
            val map = mutableMapOf<Char, Int>(
                'I' to 1,
                'V' to 5,
                'X' to 10,
                'L' to 50,
                'C' to 100,
                'D' to 500,
                'M' to 1000
            )
            var res = 0
            var prev = res
            for (i in s.length - 1 downTo 0) {
                val value = map[s[i]]!!
                if (value < prev) {
                    res -= value
                } else {
                    res += value
                }
                prev = value
            }
            return res
        }
    }

    inline val Char.romanValue: Int
        get() = when (this) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }


    fun romanToInt(s: String): Int {
        var total = 0
        val n = s.length

        for (i in 0 until n) {
            val currentValue = s[i].romanValue
            val nextValue = if (i + 1 < n) s[i + 1].romanValue else 0

            // If the current value is less than the next value, subtract it; otherwise, add it
            if (currentValue < nextValue) {
                total -= currentValue
            } else {
                total += currentValue
            }
        }

        return total
    }

}

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