package com.shlapak.yaroslav.leetcode.problem18

/**
 * Created on 2019/04/24.
 * https://leetcode.com/problems/4sum/
 */
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val res = mutableSetOf<List<Int>>()
        if (nums.size < 4) {
            return emptyList()
        }
        val map = mutableMapOf<Int, MutableSet<Int>>()
        val map2 = mutableMapOf<Int, MutableSet<Int>>()

        nums.asSequence().forEachIndexed { index: Int, i: Int ->
            map.put(i, mutableSetOf())
            if (map2.contains(i)) {
                map2[i]?.add(index)
            } else {
                map2.put(i, mutableSetOf())
            }
        }


        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    val comp = target - (nums[i] + nums[j] + nums[k])
                    val notContainsKeys =
                            (map2[comp]?.contains(i) == false)
                                    && (map2[comp]?.contains(j) == false)
                                    && (map2[comp]?.contains(k) == false)
                    if (comp in map2) {
                        if (notContainsKeys) {
                            res.add(listOf(comp, nums[i], nums[j], nums[k]).sorted())
                        }

                        if (map2[comp]?.contains(i) == true) {
                            map[comp]?.add(i)
                        }
                        if (map2[comp]?.contains(j) == true) {
                            map[comp]?.add(j)
                        }
                        if (map2[comp]?.contains(k) == true) {
                            map[comp]?.add(k)
                        }
                    }
                }
            }
        }

        return res.toList()
    }
}