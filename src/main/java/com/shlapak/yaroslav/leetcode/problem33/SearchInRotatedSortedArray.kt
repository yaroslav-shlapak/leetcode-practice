package com.shlapak.yaroslav.leetcode.problem33

/**
 * Created on 2019/05/29.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var hi = nums.size - 1
        var lo = 0
        var mid: Int
        while (hi >= lo) {
            mid = calcMid(hi, lo)
            when {
                target == nums[mid] -> {
                    return mid
                }
                //if low part is monotonically increasing, or the pivot point is in the high part
                nums[mid] >= nums[lo] -> {
                    //must use ">=" at here since we need to make sure the target is in the low part,
                    //then safely drop the high part
                    if (target >= nums[lo] && target < nums[mid]) {
                        hi = mid - 1
                    } else {
                        lo = mid + 1
                    }
                }
                //if high part is monotonically increasing, or the pivot point is in the low part
                else -> {
                    //must use "<=" at here since we need to make sure the target is in the high part,
                    //then safely drop the low part
                    if (target <= nums[hi] && target > nums[mid]) {
                        lo = mid + 1
                    } else {
                        hi = mid - 1
                    }
                }

            }
        }
        return -1
    }

    private fun calcMid(hi: Int, lo: Int) = lo + (hi - lo) / 2
}