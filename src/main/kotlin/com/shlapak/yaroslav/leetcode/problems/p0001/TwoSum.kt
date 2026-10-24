package com.shlapak.yaroslav.leetcode.problems.p0001

class TwoSumAlternative2 {



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

/**
 * LeetCode 1: Two Sum.
 *
 * Finds the indices of two numbers whose sum equals a target.
 *
 * @see <a href="https://leetcode.com/problems/two-sum/">Problem statement</a>
 */
class TwoSum {

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
    println(TwoSum().twoSum(intArrayOf(2, 7, 11, 15), 9).asList())
}
