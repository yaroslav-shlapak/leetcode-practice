package com.shlapak.yaroslav.leetcode.problems1701to1800.problem1768

/*
 * 1855. Maximum Distance Between a Pair of Values
 * https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/
 */
class MaximumDistanceBetweenAPairOfValues {

    class TwoPointers {
        fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
            // [55 ,30, 5, 4,2]
            //       |
            // [100,20,10,10,5]
            //       |

            var i = 0
            var j = 0
            val n = max(nums1.size, nums2.size)
            var max = 0
            while (i < nums1.size && j < nums2.size) {
                when {
                    i <= j && nums1[i] <= nums2[j] -> {
                        max = maxOf(max, j - i)
                        j++
                    }

                    else -> {
                        i++
                        if (i > j) {
                            j = i
                        }
                    }
                }
            }

            return max
        }
    }

    class TwoPointers2 {
        fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
            var res = 0
            var i = 0
            var j = 0
            while (i < nums1.size && j < nums2.size) {
                if (nums1[i] > nums2[j]) {
                    i++
                } else {
                    res = maxOf(res, j - i)
                    j++
                }
            }
            return res
        }
    }
}