package com.shlapak.yaroslav.leetcode.problems1to100.problem18


/**
 * Created on 2019/04/24.
 * https://leetcode.com/problems/4sum/
 */
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        val sums =
                mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                val cur = Pair(j, i)
                val sum = nums[j] + nums[i]
                val pairs = sums.getOrDefault(sum, mutableListOf())
                pairs.add(cur)
                sums[sum] = pairs

                val pp = sums[target - sum]
                if (pp != null) {
                    for (p in pp) {
                        if (p.second < j) {
                            val candidate =
                                    listOf(nums[p.first], nums[p.second], nums[j], nums[i]).sorted()
                            if (!res.contains(candidate)) {
                                res.add(candidate)
                            }
                        }
                    }
                }
            }
        }

        return res
    }
}