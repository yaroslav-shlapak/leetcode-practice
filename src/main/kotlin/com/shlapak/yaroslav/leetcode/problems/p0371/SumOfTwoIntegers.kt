package com.shlapak.yaroslav.leetcode.problems.p0371

/**
 * LeetCode 371: Sum of Two Integers.
 *
 * Adds two integers without using addition or subtraction operators.
 *
 * @see <a href="https://leetcode.com/problems/sum-of-two-integers/">Problem statement</a>
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
