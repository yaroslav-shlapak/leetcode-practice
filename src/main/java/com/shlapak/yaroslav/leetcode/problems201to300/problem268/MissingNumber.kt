package com.shlapak.yaroslav.leetcode.problems201to300.problem268

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
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