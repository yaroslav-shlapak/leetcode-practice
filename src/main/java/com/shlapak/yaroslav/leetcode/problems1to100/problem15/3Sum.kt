package com.shlapak.yaroslav.leetcode.problems1to100.problem15

/**
 * Created on 2019/04/13.
 * https://leetcode.com/problems/3sum/
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

        val map = nums.asSequence().mapIndexed { index: Int, i: Int ->
            i to index
        }.toMap()
        val res = mutableSetOf<List<Int>>()

        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                val comp = 0 - (nums[i] + nums[j])
                if (map.contains(comp) && map[comp] != i && map[comp] != j) {
                    res.add(listOf(comp, nums[i], nums[j]).sorted())
                }
            }
        }

        return res.toList()
    }

}