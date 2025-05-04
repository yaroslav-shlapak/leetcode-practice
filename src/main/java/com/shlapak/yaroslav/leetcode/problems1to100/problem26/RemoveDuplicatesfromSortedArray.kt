package com.shlapak.yaroslav.leetcode.problems1to100.problem26

import java.util.TreeSet

/**
 * Created on 2019/05/14.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
class Solution {
    fun removeDuplicates1(nums: IntArray): Int {
        val size = nums.size
        if (size == 0) {
            return 0
        }
        var i = 0
        var n = 1
        while (i < size) {
            val currentIndex = i
            while (i < size && nums[currentIndex] == nums[i]) {
                i++
            }
            if (i < size) {
                nums[n] = nums[i]
                n++
            }
        }
        return n
    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var i = 0
        for (j in 1 until nums.size) {
            if (nums[j] != nums[i]) {
                i++
                nums[i] = nums[j]
            }
        }
        return i + 1
    }

    // [0,0,1,1,1,2,2,3,3,4]
    // [0,1,1,1,1,2,2,3,3,4]
    //      |
    fun removeDuplicates3(nums: IntArray): Int {
        if (nums.size < 2) return nums.size
        var index = 1
        var prev = nums[0]
        for (n in 0 until nums.size) {
            if (prev != nums[n]) {
                nums[index] = nums[n]
                index++
            }
            prev = nums[n]
        }

        return index
    }

    fun removeDuplicates2(nums: IntArray): Int {
        val set = TreeSet<Int>()
        for (n in nums) {
            set.add(n)
        }

        var index = 0
        for (n in set) {
            nums[index] = n
            index++
        }
        return set.size
    }
}