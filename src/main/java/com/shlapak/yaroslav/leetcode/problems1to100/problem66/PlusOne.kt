package com.shlapak.yaroslav.leetcode.problems1to100.problem66

/**
 * https://leetcode.com/problems/plus-one/
 * Problem 66. Plus One
 * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
class PlusOne {
    class Solution1 {
        fun plusOne(digits: IntArray): IntArray {
            val res = mutableListOf<Int>()

            var rem = 1
            for (i in digits.size - 1 downTo 0) {
                val sum = digits[i] + rem
                if (sum == 10) {
                    res.add(0)
                    rem = 1
                } else {
                    res.add(sum)
                    rem = 0
                }
            }
            if (rem == 1) res.add(rem)
            return res.reversed().toIntArray()
        }
    }

    class Solution2 {
        fun plusOne(digits: IntArray): IntArray {
            var carry = 1
            for (i in digits.indices.reversed()) {
                digits[i] += carry
                if (digits[i] == 10) {
                    digits[i] = 0
                    carry = 1
                } else {
                    carry = 0
                    break
                }
            }

            if (carry == 1) return digits
            val res = IntArray(digits.size + 1)
            res[0] = 1
            for (i in digits.indices) {
                res[i + 1] = digits[i]
            }
            return res
        }
    }
}