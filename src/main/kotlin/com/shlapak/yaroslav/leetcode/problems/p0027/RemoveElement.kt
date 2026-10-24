package com.shlapak.yaroslav.leetcode.problems.p0027

/**
 * Created on 2019/05/14.
 * https://leetcode.com/problems/remove-element/
 */
class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var i = 0
        for (j in 0 until nums.size) {
            if (nums[j] != `val`) {
                nums[i] = nums[j]
                i++
            }
        }

        return i
    }
}