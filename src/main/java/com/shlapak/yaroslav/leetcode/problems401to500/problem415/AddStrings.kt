package com.shlapak.yaroslav.leetcode.problems401to500.problem415

/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/
 */
class AddStrings {
    fun addStrings(num1: String, num2: String): String {
        var i = num1.lastIndex
        var j = num2.lastIndex
        var rem = 0
        val sum = StringBuilder()
        while (i >= 0 || j >= 0 || rem > 0) {
            val temp = when {
                i >= 0 && j >= 0 -> {
                    num1[i].asInt() + num2[j].asInt()
                }

                i >= 0 -> {
                    num1[i].asInt()
                }

                j >= 0 -> {
                    num2[j].asInt()
                }

                else -> 0
            }
            sum.append((temp + rem) % 10)
            rem = (temp + rem) / 10
            i--
            j--
        }

        return sum.reverse().toString()
    }

    private fun Char.asInt(): Int = this - '0'
}