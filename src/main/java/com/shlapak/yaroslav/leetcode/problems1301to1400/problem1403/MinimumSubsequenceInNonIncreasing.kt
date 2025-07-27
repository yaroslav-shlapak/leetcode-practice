package com.shlapak.yaroslav.leetcode.problems1301to1400.problem1403

/**
 * 1403. Minimum Subsequence in Non-Increasing Order
 * https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
 */
class MinimumSubsequenceInNonIncreasing {
    class BruteForce {
        fun minSubsequence(nums: IntArray): List<Int> {
            nums.sortDescending()
            val sum = nums.sum()
            val res = mutableListOf<Int>()
            var newSum = 0
            for (i in 0 until nums.size) {
                res.add(nums[i])
                newSum += nums[i]
                if (sum - newSum < newSum) {
                    break
                }
            }
            return res
        }
    }
}