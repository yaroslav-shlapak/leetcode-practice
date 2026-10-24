package com.shlapak.yaroslav.leetcode.problems.p0268

/**
 * LeetCode 268: Missing Number.
 *
 * Finds the missing value from an array representing the range 0 through n.
 *
 * @see <a href="https://leetcode.com/problems/missing-number/">Problem statement</a>
 */
class MissingNumber {
    class HashSet {
        fun missingNumber(nums: IntArray): Int {
            val set = nums.toSet()
            for (i in 0 .. nums.size) {
                if (!set.contains(i)) {
                    return i
                }
            }
            return -1
        }
    }
}
