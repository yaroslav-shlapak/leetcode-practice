package com.shlapak.yaroslav.leetcode.problems.p0031

/**
 * LeetCode 31: Next Permutation.
 *
 * Transforms an array into its next lexicographic permutation.
 *
 * @see <a href="https://leetcode.com/problems/next-permutation/">Problem statement</a>
 */
class NextPermutation {
    lateinit var nums: IntArray
    fun nextPermutation(arr: IntArray) {
        nums = arr
        val i = findFirstDescending(arr.size - 2)
        if (i >= 0) {
            swap(i, findNearestLarger(nums.size - 1, i))
        }
        reverse(i + 1)
    }

    private fun findNearestLarger(start: Int, i: Int): Int {
        var j = start
        while (j >= 0 && nums[j] <= nums[i]) {
            j--
        }
        return j
    }

    private fun findFirstDescending(start: Int): Int {
        var i = start
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--
        }
        return i
    }

    private fun reverse(start: Int) {
        var i = start
        var j = nums.size - 1
        while (i < j) {
            swap(i, j)
            i++
            j--
        }
    }

    private fun swap(i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}
