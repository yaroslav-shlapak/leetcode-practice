package com.shlapak.yaroslav.leetcode.problems201to300.problem217

import java.util.*

/**
 * https://leetcode.com/problems/contains-duplicate/
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 *
 * Output: true
 *
 * Explanation:
 *
 * The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 *
 * Output: false
 *
 * Explanation:
 *
 * All elements are distinct.
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
class ContainsDuplicate() {

    // Given an integer array nums, return true if any value appears
    // at least twice in the array, and return false if every element is distinct.

    fun containsDuplicate(nums: IntArray): Boolean {
        val map: MutableMap<Int, Int> = mutableMapOf()
        nums.forEach { key ->
            val value = map[key] ?: 0
            if (value >= 1) {
                return true
            } else {
                map[key] = value + 1
            }
        }
        return false
    }
}

