package com.shlapak.yaroslav.leetcode.problems3001to3100.problem3026

/*
https://leetcode.com/problems/maximum-good-subarray-sum/description/
 */
class MaximumGoodSubarraySum {

    private var maxSum: Long? = null

    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        val prefixSum = LongArray(nums.size + 1)
        prefixSum[0] = 0
        for (i in 1 until prefixSum.size) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1]
        }

        //println(prefixSum.toList())
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (i in nums.indices) {
            val indices = map[nums[i]]
            if (indices != null) {
                indices.add(i)
            } else {
                map[nums[i]] = mutableListOf(i)
            }
        }

        for (i in nums.indices) {
            // |nums[i] - nums[j]| == k. =>
            // nums[i] - nums[j] == -k. => nums[j] == k + nums[i]
            // nums[i] - nums[j] == k. => nums[j] == -k + nums[i]

            val candidate1 = nums[i] - k
            val candidate2 = nums[i] + k

            updateSumIfConditionsMet(map[candidate1], i, prefixSum)
            updateSumIfConditionsMet(map[candidate2], i, prefixSum)
        }

        return maxSum ?: 0L
    }

    private fun updateSumIfConditionsMet(
        indices: List<Int>?,
        i: Int,
        prefixSum: LongArray
    ) {
        indices?.forEach { index ->
            if (index > i) {
                val candidateSum = prefixSum[index + 1] - prefixSum[i]
                //println(candidateSum)
                val prevSum = maxSum
                maxSum = if (prevSum != null) {
                    maxOf(prevSum, candidateSum)
                } else {
                    candidateSum
                }
            }
        }
    }
}

class Solution {

    private var maxSum: Long? = null

    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        val prefixSum = LongArray(nums.size + 1)
        prefixSum[0] = 0
        for (i in 1 until prefixSum.size) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1]
        }

        //println(prefixSum.toList())
        val map = mutableMapOf<Int, Pair<Long, Int>>()
        for (i in nums.indices) {
            val prefSumToIndex = map[nums[i]]
            if (prefSumToIndex != null) {
                map[nums[i]] = maxOf(prefixSum[i + 1], prefSumToIndex.first) to prefSumToIndex.second
            } else {
                map[nums[i]] = prefixSum[i + 1] to i
            }
        }

        for (i in nums.indices) {
            // |nums[i] - nums[j]| == k. =>
            // nums[i] - nums[j] == -k. => nums[j] == k + nums[i]
            // nums[i] - nums[j] == k. => nums[j] == -k + nums[i]

            val candidate1 = nums[i] - k
            val candidate2 = nums[i] + k

            updateSumIfConditionsMet(map[candidate1], i, prefixSum)
            updateSumIfConditionsMet(map[candidate2], i, prefixSum)
        }

        return maxSum ?: 0L
    }

    private fun updateSumIfConditionsMet(
        prefSumToIndex: Pair<Long, Int>?,
        i: Int,
        prefixSum: LongArray
    ) {
        if (prefSumToIndex != null && prefSumToIndex.second > i) {
            val candidateSum = prefSumToIndex.first - prefixSum[i]
            //println(candidateSum)
            val prevSum = maxSum
            maxSum = if (prevSum != null) {
                maxOf(prevSum, candidateSum)
            } else {
                candidateSum
            }
        }
    }
}