package com.shlapak.yaroslav.leetcode.problem15

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
}