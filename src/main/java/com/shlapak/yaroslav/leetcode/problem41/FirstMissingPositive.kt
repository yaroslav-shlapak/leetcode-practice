package com.shlapak.yaroslav.leetcode.problem41

/**
 * Created on 2019/07/03.
 * https://leetcode.com/problems/first-missing-positive/
 */
class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        nums.sort()
        if (nums.isEmpty() || nums[0] > 1) {
            return 1
        }
        if (nums.size == 1) {
            if (nums[0] > 1) {
                return 1
            } else {
                if (nums[0] > 0) {
                    return nums[0] + 1
                }
            }
        }
        for (i in 0 until nums.size - 1) {
            if (nums[i] > 0) {
                if (nums[i + 1] - nums[i] > 1) {
                    return nums[i] + 1
                }
            } else {
                if (nums[i + 1] > 1) {
                    return 1
                }
            }
        }
        val last = nums.last()
        return if (last > 0) last + 1 else 1
    }
}