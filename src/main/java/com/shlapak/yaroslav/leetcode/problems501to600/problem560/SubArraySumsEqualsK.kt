package com.shlapak.yaroslav.leetcode.problems501to600.problem560

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
class SubArraySumsEqualsK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var res = 0
        val sums = mutableMapOf<Int, Int>()
        var sum = 0
        sums[sum] = 1
        for (i in nums) {
            sum += i
            val count = sums[sum - k]
            if (count != null) {
                res += count
            }
            val currentCount = sums[sum]
            if (currentCount != null) {
                sums[sum] = currentCount + 1
            } else {
                sums[sum] = 1
            }
        }

        return res
    }
}
class SubArraySumsEqualsK_BruteForce {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var res = 0
        val sums = IntArray(nums.size)
        sums[0] = nums[0]
        val map = mutableMapOf<Int, Int>()
        for (i in 1 until nums.size) {
            sums[i] = sums[i - 1] + nums[i]
        }

        for (i in nums.indices) {
            if (sums[i] == k) {
                res++
            }
            for (j in i + 1 until nums.size) {
                if (sums[j] - sums[i] == k) {
                    res++
                }
            }
        }

        return res
    }
}