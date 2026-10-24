package com.shlapak.yaroslav.leetcode.problems.p0136

/**
 * LeetCode 136: Single Number.
 *
 * Finds the value appearing once when every other value appears twice.
 *
 * @see <a href="https://leetcode.com/problems/single-number/">Problem statement</a>
 */
class SingleNumber {
    class BitMask {
        fun singleNumber(nums: IntArray): Int {
            var res: Int = 0
            for (i in 0 until nums.size) {
                res = nums[i] xor res
            }
            return res
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
