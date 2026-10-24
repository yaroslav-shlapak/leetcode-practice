package com.shlapak.yaroslav.leetcode.problems.p0053

/**
 * LeetCode 53: Maximum Subarray.
 *
 * Finds the largest sum of a nonempty contiguous subarray.
 *
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">Problem statement</a>
 */
class MaximumSubarray {
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

class MaximumSubarrayAlternative2{
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

class MaximumSubarrayAlternative3 {
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
