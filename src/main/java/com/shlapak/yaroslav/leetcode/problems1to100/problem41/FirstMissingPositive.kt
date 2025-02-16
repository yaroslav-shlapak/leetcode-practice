package com.shlapak.yaroslav.leetcode.problems1to100.problem41

/**
 * Created on 2019/07/03.
 * https://leetcode.com/problems/first-missing-positive/
 */
class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        nums.sort()
        if (nums.isEmpty() || nums[0] > 1) {
            return 1
        }
        if (nums.size == 1) {
            if (nums[0] > 1) {
                return 1
            } else {
                if (nums[0] > 0) {
                    return nums[0] + 1
                }
            }
        }
        for (i in 0 until nums.size - 1) {
            if (nums[i] > 0) {
                if (nums[i + 1] - nums[i] > 1) {
                    return nums[i] + 1
                }
            } else {
                if (nums[i + 1] > 1) {
                    return 1
                }
            }
        }
        val last = nums.last()
        return if (last > 0) last + 1 else 1
    }
}

class Solution2 {
    fun firstMissingPositive(nums: IntArray): Int {
        var i = 0
        while (i < nums.size) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.size) {
                i++
            } else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1)
            } else {
                i++
            }
        }
        println("nums: ${nums.toList()}")

        i = 0
        while (i < nums.size && nums[i] == i + 1) {
            i++
        }
        return i + 1
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}