package com.shlapak.yaroslav.leetcode.problems.p0041

/**
 * LeetCode 41: First Missing Positive.
 *
 * Finds the smallest positive integer absent from an array.
 *
 * @see <a href="https://leetcode.com/problems/first-missing-positive/">Problem statement</a>
 */
class FirstMissingPositive {
    class HashSetScan {
        /**
         * Scans for the first missing value among 1 through the size of [nums].
         * If all are present, the answer is one greater than the size. Leaves [nums] unchanged.
         *
         * Expected time: O(n).
         * Space: O(n).
         */
        fun firstMissingPositive(nums: IntArray): Int {
            val values = nums.toSet()
            for (candidate in 1..nums.size) {
                if (candidate !in values) {
                    return candidate
                }
            }
            return nums.size + 1
        }
    }

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

class FirstMissingPositiveAlternative2 {
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
