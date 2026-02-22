package com.shlapak.yaroslav.leetcode.problems1901to2000.problem1913

/**
 * 1913. Maximum Product Difference Between Two Pairs
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 */
class MaximumProductDifferenceBetweenTwoPairs {
    class Optimal {
        fun maxProductDifference(nums: IntArray): Int {
            var min1 = Int.MAX_VALUE
            var min2 = Int.MAX_VALUE
            var max1 = Int.MIN_VALUE
            var max2 = Int.MIN_VALUE

            for (n in nums) {
                if (n < min1) {
                    min2 = min1
                    min1 = n
                } else if (n < min2) {
                    min2 = n
                }

                if (n > max1) {
                    max2 = max1
                    max1 = n
                } else if (n > max2) {
                    max2 = n
                }
            }

            return max1 * max2 - min1 * min2
        }
    }

    class Sorting {
        fun maxProductDifference(nums: IntArray): Int {
            nums.sort()
            val n = nums.size
            return nums[n - 1] * nums[n - 2] - nums[0] * nums[1]
        }
    }
}