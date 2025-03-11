package com.shlapak.yaroslav.leetcode.problems1to100.problem15


/**
 * 15. 3Sum
 *
 * https://leetcode.com/problems/3sum/
 *
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()
        for (i in nums.indices) {
            if (nums[i] > 0) {
                break
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var l = i + 1
            var r = nums.size - 1
            while (r > l) {
                val threeSum = nums[i] + nums[l] + nums[r]
                when {
                    threeSum > 0 -> r--
                    threeSum < 0 -> l--
                    else -> {
                        res.add(listOf(nums[i], nums[l], nums[r]))

                        while (r > l && nums[r] == nums[r + 1]) {
                            r--
                        }
                    }
                }
            }
        }

        return res
    }
}

class ThreeSum2 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            val a = nums[i]
            if (a > 0) break
            if (i > 0 && a == nums[i - 1]) continue

            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val threeSum = a + nums[l] + nums[r]
                when {
                    threeSum > 0 -> r--
                    threeSum < 0 -> l++
                    else -> {
                        res.add(listOf(a, nums[l], nums[r]))
                        l++
                        r--
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++
                        }
                    }
                }
            }
        }

        return res
    }
}
/*
Input
nums =
[2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10]
Output
[[-4,2,2],[-3,-2,5],[-2,0,2],[-5,0,5],[-10,5,5]]
Expected
[[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]
 */



class Solution {
    fun threeSumNaive(nums: IntArray): List<List<Int>> {
        val set = mutableSetOf<String>()
        val res = mutableListOf<List<Int>>()
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        val l = listOf(nums[i], nums[j], nums[k])
                        val sorted = l.sorted()
                        val s = sorted.toString()
                        if (!set.contains(s)) {
                            set.add(s)
                            res.add(sorted)
                        }
                    }
                }
            }
        }
        return res
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return emptyList()
        }

        nums.sort()

        val map = nums.mapIndexed { index: Int, i: Int ->
            i to index
        }.toMap()
        val res = mutableSetOf<List<Int>>()

        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val comp = 0 - (nums[i] + nums[j])
                if (map.contains(comp) && map[comp] != i && map[comp] != j) {
                    res.add(listOf(comp, nums[i], nums[j]))
                }
            }
        }

        return res.toList()
    }

}