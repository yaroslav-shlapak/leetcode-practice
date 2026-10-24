package com.shlapak.yaroslav.leetcode.problems.p0303

/**
 * LeetCode 303: Range Sum Query Immutable.
 *
 * Answers sum queries over an immutable array.
 *
 * @see <a href="https://leetcode.com/problems/range-sum-query-immutable/">Problem statement</a>
 */
class NumArray(val nums: IntArray) {

    private val prefixSum = IntArray(nums.size + 1)
    init {
        prefixSum[0] = 0
        for (i in 1 until prefixSum.size) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return prefixSum[right + 1] - prefixSum[left]
    }

}
