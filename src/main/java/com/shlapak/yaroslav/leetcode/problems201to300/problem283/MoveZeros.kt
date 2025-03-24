package com.shlapak.yaroslav.leetcode.problems201to300.problem283

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
class MoveZeros {
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.size == 1) return
        var j = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                j++
            }
        }
    }
}

class MoveZeros_ExtraSpace {
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.size == 1) return
        var r = nums.size - 1
        var l = 0
        val nums2 = IntArray(nums.size)
        var j = 0
        for (num in nums) {
            if (num != 0) {
                nums2[j] = num
                j++
            }
        }
        for (i in nums.indices) {
            if (nums2[i] != 0) {
                nums[i] = nums2[i]
            } else {
                nums[i] = 0
            }
        }
    }

    fun IntArray.swap(first: Int, second: Int) {
        val temp = this[first]
        this[first] = this[second]
        this[second] = temp
    }
}