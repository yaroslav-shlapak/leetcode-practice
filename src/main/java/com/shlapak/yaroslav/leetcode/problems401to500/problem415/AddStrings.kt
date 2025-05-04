package com.shlapak.yaroslav.leetcode.problems401to500.problem415

/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/
 */
class AddStrings {
    fun addStrings(num1: String, num2: String): String {
        var i1 = num1.lastIndex
        var i2 = num2.lastIndex
        var carry = 0
        val sum = StringBuilder()
        while (i1 >= 0 || i2 >= 0 || carry > 0) {
            val digit1 = if (i1 >= 0) num1[i1].asInt() else 0
            val digit2 = if (i2 >= 0) num2[i2].asInt() else 0

            val interimCalcResult = digit1 + digit2 + carry
            sum.append(interimCalcResult % 10)
            carry = interimCalcResult / 10

            i1--
            i2--
        }

        return sum.reverse().toString()
    }

    private fun Char.asInt(): Int = this - '0'
}