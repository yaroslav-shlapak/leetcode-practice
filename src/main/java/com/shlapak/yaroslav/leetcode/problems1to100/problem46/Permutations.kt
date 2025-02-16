package com.shlapak.yaroslav.leetcode.problems1to100.problem46


/**
 * Created on 2019/07/17.
 * https://leetcode.com/problems/permutations/
 */
class Solution {
    private lateinit var res: MutableList<List<Int>>
    fun permute(nums: IntArray): List<List<Int>> {
        res = mutableListOf()
        backtrack(mutableListOf(), mutableSetOf(), nums)
        return res
    }

    private fun backtrack(temp: MutableList<Int>, set: MutableSet<Int>, nums: IntArray) {
        if (temp.size == nums.size) {
            res.add(temp.toList())
        } else {
            for (i in nums.indices) {
                if (!set.contains(nums[i])) {
                    temp.add(nums[i])
                    set.add(nums[i])
                    backtrack(temp, set, nums)
                    val element = temp.removeAt(temp.size - 1)
                    set.remove(element)
                }
            }
        }
    }
}