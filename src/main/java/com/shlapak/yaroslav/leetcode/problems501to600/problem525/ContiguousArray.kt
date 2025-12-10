package com.shlapak.yaroslav.leetcode.problems501to600.problem525

/**
 * 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/description/
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Example 3:
 *
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
class ContiguousArray {

    class OptimizedPrefixSum {
        /**
         * Key idea
         * Convert 0 to -1, so the problem reduces to finding the longest subarray with a sum of 0.
         * Maintain a prefix sum while iterating through the array.
         * Use a hash map (sumIndexMap) to store the first occurrence of each prefix sum.
         * If the same prefix sum appears again at a later index, it means the numbers between these indices sum to 0, forming a valid subarray.
         * The maximum length is updated whenever a longer subarray is found.
         * Algorithm
         * Initialize prefixSum = 0 and sumIndexMap = {0: -1} (to handle cases where the subarray starts from index 0).
         * Iterate through nums:
         * Convert 0 to -1.
         * Update prefixSum.
         * If prefixSum is seen before, update the max length.
         * Otherwise, store its index in sumIndexMap.
         */
        fun findMaxLength(nums: IntArray): Int {
            var maxLength = 0
            var prefixSum = 0
            val sumIndexMap = mutableMapOf(0 to -1) // Initialize with 0 difference at position -1
            for (i in nums.indices) {
                // Increment count for 1, decrement for 0
                prefixSum += if (nums[i] == 1) 1 else -1
                val index = sumIndexMap[prefixSum]
                // If we've seen this count before, we have a sub-array with equal 0s and 1s, it is kind of balance
                if (index != null) {
                    maxLength =
                        maxOf(maxLength, i - index) // difference between the firs occurrence and the next occurrence
                } else {
                    // Store the first occurrence of this count
                    sumIndexMap[prefixSum] = i
                }
            }
            return maxLength
        }
    }

    class TwoCountersWithHashMap {
        fun findMaxLength(nums: IntArray): Int {

            val map = mutableMapOf<Int, Int>()
            var res = 0
            var zero = 0
            var one = 0
            for (i in 0 until nums.size) {
                val n = nums[i]
                if (n == 1) {
                    one++
                } else {
                    zero++
                }
                val diff = zero - one

                val idx = map[diff]
                if (idx == null) {
                    map[diff] = i
                }

                res = if (diff == 0) {
                    maxOf(res, zero + one)
                } else {
                    maxOf(res, i - map[diff]!!)
                }
            }

            return res
        }
    }
}