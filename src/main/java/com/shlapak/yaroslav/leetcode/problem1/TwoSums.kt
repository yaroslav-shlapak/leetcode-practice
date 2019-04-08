package com.shlapak.yaroslav.leetcode.problem1

/**
 * Created on 2019/04/08.
 */
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