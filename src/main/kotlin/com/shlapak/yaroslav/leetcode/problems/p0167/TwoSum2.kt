package com.shlapak.yaroslav.leetcode.problems.p0167

import kotlin.time.Duration.Companion.seconds

/**
 * LeetCode 167: Two Sum II Input Array is Sorted.
 *
 * Finds one-based indices of two sorted-array values with a target sum.
 *
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Problem statement</a>
 */
class TwoSum2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val numbersToIndexes: Map<Int, Int> =
            numbers
                .mapIndexed { index, i -> i to index }
                .associate { it.first to it.second }
        for (i in numbers.indices) {
            val index = numbersToIndexes[target - numbers[i]]
            if (index != null) {
                return intArrayOf(i + 1, index + 1)
            }
        }

        return intArrayOf()
    }

    fun twoSum2(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            if (sum == target) {
                return intArrayOf(left + 1, right + 1)
            }
            if (sum > target) {
                right--
            } else {
                left++
            }
        }

        return intArrayOf()
    }
}
