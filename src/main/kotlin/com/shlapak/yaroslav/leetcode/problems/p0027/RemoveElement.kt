package com.shlapak.yaroslav.leetcode.problems.p0027

/**
 * LeetCode 27: Remove Element.
 *
 * Removes occurrences of a value from an array in place.
 *
 * @see <a href="https://leetcode.com/problems/remove-element/">Problem statement</a>
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
