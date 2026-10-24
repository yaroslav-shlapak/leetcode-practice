package com.shlapak.yaroslav.leetcode.problems.p0217

import java.util.*

/**
 * LeetCode 217: Contains Duplicate.
 *
 * Checks whether an array contains a repeated value.
 *
 * @see <a href="https://leetcode.com/problems/contains-duplicate/">Problem statement</a>
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
