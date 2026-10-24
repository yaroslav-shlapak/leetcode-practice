package com.shlapak.yaroslav.leetcode.problems.p0153

/**
 * LeetCode 153: Find Minimum in Rotated Sorted Array.
 *
 * Finds the minimum value in a rotated sorted array of distinct values.
 *
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Problem statement</a>
 */
class FindMinimumInRotatedArray {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        while (r > l) {
            val mid = l + (r - l) / 2
            if (nums[mid] < nums[r]) {
                // if middle element is smaller than the right element,
                // then the minimum element is located in the left half of the array,
                // including the middle element (we set the right element to be the middle element)
                r = mid
            } else {
                // if the middle element is greater than the right element,
                // then the minimum element is located in the right half of the array,
                // excluding the middle element.
                l = mid + 1
            }
        }
        // After the pointers converge, the minimum element should be the element pointed to by the left pointer
        return nums[l]
    }
}
