package com.shlapak.yaroslav.leetcode.problems601to700.problem670

/**
 * 670. Maximum Swap
 * https://leetcode.com/problems/maximum-swap/
 */
class MaxSwapBruteForceMy1 {
    fun maximumSwap(num: Int): Int {
        if (num <= 11) return num
        var cur = num
        val list = num.toString().toCharArray()
        // find max and swap with largest
        for (i in 0 until list.size) {
            var iMax = i
            for (j in list.size - 1 downTo i) {
                if (list[j] > list[iMax]) {
                    iMax = j
                }
            }
            if (list[i] < list[iMax]) {
                val temp = list[iMax]
                list[iMax] = list[i]
                list[i] = temp
                break
            }
        }

        return String(list).toInt()
    }
}

class MaxSwapBruteForceMy2 {
    fun maximumSwap(num: Int): Int {
        if (num <= 11) return num
        var cur = num
        val list = mutableListOf<Int>()
        var i = 0
        while (cur / 10 != 0 || cur % 10 != 0) {
            val value = cur % 10
            list.add(value)
            i++
            cur = cur / 10
        }
        // find max and swap with largest
        for (i in list.size - 1 downTo 0) {
            var iMax = i
            for (j in 0..i) {
                if (list[j] > list[iMax]) {
                    iMax = j
                }
            }
            if (list[i] < list[iMax]) {
                val temp = list[iMax]
                list[iMax] = list[i]
                list[i] = temp
                break
            }
        }

        var res = 0
        var mult = 1
        for (num in list) {
            res = res + num * mult
            mult = mult * 10
        }
        return res
    }
}

class Solution {
    fun maximumSwap1(num: Int): Int {
        val digits = num.toString().toCharArray()
        val last = IntArray(10)
        for (i in digits.indices) {
            last[digits[i] - '0'] = i
        }

        for (i in digits.indices) {
            for (d in 9 downTo (digits[i] - '0' + 1)) {
                if (last[d] > i) {
                    val temp = digits[i]
                    digits[i] = digits[last[d]]
                    digits[last[d]] = temp
                    return String(digits).toInt()
                }
            }
        }

        return num
    }


    fun maximumSwap2(num: Int): Int {
        var maxSwapNum = num
        var power = 1
        var maxDigit = 0
        var maxDigitPower = 0

        while (power <= num) {
            val digit = (num % (power * 10)) / power

            val swapNum = num - (digit * power) - (maxDigit * maxDigitPower) + maxDigit * power + digit * maxDigitPower
            maxSwapNum = max(swapNum, maxSwapNum)

            if (digit > maxDigit) {
                maxDigit = digit
                maxDigitPower = power
            }

            power *= 10
        }

        return maxSwapNum
    }
}
}