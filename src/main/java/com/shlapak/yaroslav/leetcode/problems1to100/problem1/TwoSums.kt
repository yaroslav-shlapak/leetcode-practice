package com.shlapak.yaroslav.leetcode.problems1to100.problem1

/**
 * https://leetcode.com/problems/two-sum/submissions/1543335819/
 */
class Solution2 {

    /**
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     *
     * You can return the answer in any order.
     */

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val possiblePair = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            val candidate = possiblePair[i]
            if (candidate != null) {
                return@twoSum intArrayOf(candidate, index)
            } else {
                possiblePair[target - i] = index
            }
        }
        return intArrayOf(0, 0)
    }
}


class Solution {

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf(-1)
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val comp = target - nums[i]
            if (map.containsKey(comp)) {
                return intArrayOf(map[comp]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf(-1)
    }
}

fun main() {
    println(Solution().twoSum(intArrayOf(2, 7, 11, 15), 9).asList())
}