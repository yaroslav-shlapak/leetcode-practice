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

class Solution2{
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        var curMax = nums[0]
        for (i in 1 until nums.size) {
            val cur = nums[i]
            if (curMax + cur > cur) {
                curMax += cur
            } else {
                curMax = cur
            }
            if (curMax > max) {
                max = curMax
            }
        }
        return max
    }
}

class Solution3 {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        var curMax = nums[0]
        for (i in 1 until nums.size) {
            curMax = Math.max(curMax + nums[i], nums[i])
            max = Math.max(curMax, max)
        }
        return max
    }
}