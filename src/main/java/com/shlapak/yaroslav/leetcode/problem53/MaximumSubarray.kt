package com.shlapak.yaroslav.leetcode.problem53

/**
 * Created on 2019/11/17.
 */
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        for (i in nums.indices) {
            val maxCandidate = getMax(i, nums)
            if (maxCandidate > max) {
                max = maxCandidate
            }
        }
        return max
    }

    private fun getMax(i: Int, nums: IntArray): Int {
        var max = nums[i]
        var sum = max
        for (j in i + 1 until nums.size) {
            sum += nums[j]
            if (sum > max) {
                max = sum
            }
        }
        return max
    }
}