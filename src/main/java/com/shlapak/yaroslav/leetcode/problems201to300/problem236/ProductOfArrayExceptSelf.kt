package com.shlapak.yaroslav.leetcode.problems201to300.problem236

/**
 * https://leetcode.com/problems/product-of-array-except-self
 *
 * 238. Product of Array Except Self
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity?
 * (The output array does not count as extra space for space complexity analysis.)
 */


class ProductOfArrayExceptSelf {
    /**
     * Given an integer array nums,
     * return an array answer such that answer[i] is equal
     * to the product of all the elements of nums except nums[i].
     *
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     */
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixes = IntArray(nums.size)
        val suffixes = IntArray(nums.size)
        val res = IntArray(nums.size)
        for (i in nums.indices) {
            when (i) {
                0 -> prefixes[i] = 1
                1 -> {
                    prefixes[i] = nums[i - 1]
                }

                else -> {
                    prefixes[i] = prefixes[i - 1] * nums[i - 1]
                }
            }


        }
        for (i in nums.size - 1 downTo 0) {
            when (i) {
                nums.size - 1 -> suffixes[i] = 1
                nums.size - 2 -> {
                    suffixes[i] = nums[i + 1]
                }

                else -> {
                    suffixes[i] = suffixes[i + 1] * nums[i + 1]
                }
            }
            // res[i] = prefixes[i] * suffixes[i] not sure why but moving this one here makes it slower
        }

        for (i in nums.indices) {
            res[i] = prefixes[i] * suffixes[i]
        }
        return res
    }
}