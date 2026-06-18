package com.shlapak.yaroslav.leetcode.problems101to200.problem137


/**
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * 137. Single Number II
 *
 * **/

class SingleNumber2 {
    class BitMask {
        /**
         * Finds the single number in an array where every other number appears exactly three times.
         *
         * This implementation uses bit manipulation.
         *
         * For each bit position from 0 to 31, it counts how many numbers have a `1`
         * at that position. Since all duplicated numbers appear three times, their
         * bits contribute counts divisible by 3. After applying modulo 3, only the bits
         * of the unique number remain.
         *
         * Example:
         *
         * ```
         * nums = [2, 2, 3, 2]
         *
         * Binary:
         * 2 = 10
         * 2 = 10
         * 2 = 10
         * 3 = 11
         *
         * The bits belonging to `2` appear three times and are removed by `% 3`.
         * The remaining bits form `3`.
         * ```
         *
         * Bit operations used:
         *
         * - `shr`: shifts bits to the right, used to move the target bit to the last position.
         * - `and 1`: extracts the last bit, giving either `0` or `1`.
         * - `shl`: shifts the recovered bit back to its original position.
         * - `or`: adds the recovered bit to the final result.
         *
         * Time complexity: `O(n)`, because the algorithm checks 32 bits for each number.
         * Space complexity: `O(1)`, because it only uses a few integer variables.
         *
         * This also works for negative numbers because all 32 bits are processed,
         * including the sign bit.
         *
         * @param nums an array of integers where every number appears three times except one
         * @return the number that appears exactly once
         */
        fun singleNumber(nums: IntArray): Int {
            var result = 0


            // Process each bit position (0 to 31) for 32-bit integers
            for (bitPosition in 0..31) {
                var bitCount = 0


                // Count how many numbers have a 1 at the current bit position
                for (number in nums) {
                    // Extract the bit at the current position and add to count
                    bitCount += (number shr bitPosition) and 1
                }


                // If bit count is not divisible by 3, the single number has a 1 at this position
                // (All numbers appearing 3 times will contribute 0 or 3 to the count)
                bitCount %= 3


                // Set the bit at the current position in the result if count is 1
                result = result or (bitCount shl bitPosition)
            }

            return result
        }
    }

    class HashMap {
        fun singleNumber(nums: IntArray): Int {
            val map = mutableMapOf<Int, Int>()
            for (i in 0 until nums.size) {
                map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
            }
            return map.filter { it.value == 1 }.keys.first()
        }
    }
}