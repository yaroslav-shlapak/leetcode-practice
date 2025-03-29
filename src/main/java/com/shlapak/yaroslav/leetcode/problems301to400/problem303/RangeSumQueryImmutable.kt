package com.shlapak.yaroslav.leetcode.problems301to400.problem303

/*
303. Range Sum Query - Immutable
https://leetcode.com/problems/range-sum-query-immutable/description/
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