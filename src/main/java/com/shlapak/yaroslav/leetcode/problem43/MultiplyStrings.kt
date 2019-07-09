package com.shlapak.yaroslav.leetcode.problem43

/**
 * Created on 2019/07/09.
 * https://leetcode.com/problems/multiply-strings/
 */
class Solution {
    fun multiply(num1: String, num2: String): String {
        val res = try {
            num1.toBigInteger().multiply(num2.toBigInteger()).toString()
        } catch (e: Exception) {
            ""
        }
        return res
    }
}

class SolutionNaive {
    fun multiply(num1: String, num2: String): String {
        val m = num1.length
        val n = num2.length
        val pos = IntArray(m + n)

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                val mul = (num1[i] - '0') * (num2[j] - '0')
                val p1 = i + j
                val p2 = i + j + 1
                val sum = mul + pos[p2]

                pos[p1] += sum / 10
                pos[p2] = sum % 10
            }
        }

        val sb = StringBuilder()
        for (p in pos) if (!(sb.length == 0 && p == 0)) sb.append(p)
        return if (sb.length == 0) "0" else sb.toString()
    }

}