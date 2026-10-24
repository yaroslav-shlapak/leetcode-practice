package com.shlapak.yaroslav.leetcode.problems.p0704

/**
 * LeetCode 704: Binary Search.
 *
 * Finds a target index in a sorted array.
 *
 * @see <a href="https://leetcode.com/problems/binary-search/">Problem statement</a>
 */
class BinarySearch {
    /**
     * Searches a sorted array by repeatedly halving the candidate interval.
     *
     * Requires [nums] to be sorted in ascending order.
     * Returns -1 when [target] is absent. The input is not modified.
     *
     * Time: O(log n).
     * Space: O(1).
     */
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val mid = l + (r - l) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] > target -> r = mid - 1
                else -> l = mid + 1
            }
        }
        return -1
    }
}
