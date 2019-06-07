package com.shlapak.yaroslav.leetcode.problem35

/**
 * Created on 2019/06/07.
 * https://leetcode.com/problems/search-insert-position/
 */
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var hi = nums.size - 1
        var lo = 0
        var mid: Int = calcMid(hi, lo)
        var found = false

        loop@ while (hi >= lo) {
            mid = calcMid(hi, lo)
            when {
                target == nums[mid] -> {
                    found = true
                    break@loop
                }
                target > nums[mid] -> {
                    lo = mid + 1
                }
                target < nums[mid] -> {
                    hi = mid - 1
                }
            }
        }

        if (!found) {
            mid = when {
                hi >= 0 && nums[hi] < target -> {
                    hi + 1
                }
                nums[lo] < target -> {
                    lo + 1
                }
                else -> {
                    if (lo - 1 >= 0) {
                        lo - 1
                    } else {
                        0
                    }
                }
            }
        }

        return mid
    }

    private fun calcMid(hi: Int, lo: Int): Int {
        return lo + (hi - lo) / 2
    }
}