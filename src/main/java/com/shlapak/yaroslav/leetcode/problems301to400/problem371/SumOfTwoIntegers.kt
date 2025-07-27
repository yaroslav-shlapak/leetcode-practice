package com.shlapak.yaroslav.leetcode.problems301to400.problem371

/**
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 * This problem can be solved using bit manipulation.
 * The idea is to use bitwise operations to calculate the sum without using the '+' operator.
 */
class SumOfTwoIntegers {
    class Naive {
        fun getSum(a: Int, b: Int): Int {
            var x = a
            var y = b

            // Keep iterating until there is no carry left
            while (y != 0) {
                // 'carry' contains the common set bits of x and y.
                val carry = x and y

                // 'x' becomes the sum of bits without considering the carry (XOR).
                x = x xor y

                // 'y' becomes the carry to be added in the next iteration.
                // Left-shifting by 1 moves the carry to the next significant bit.
                y = carry shl 1
            }

            return x
        }
    }
}