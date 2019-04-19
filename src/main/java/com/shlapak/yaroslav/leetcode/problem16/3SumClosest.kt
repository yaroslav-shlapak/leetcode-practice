package com.shlapak.yaroslav.leetcode.problem16

/**
 * Created on 2019/04/18.
 * https://leetcode.com/problems/3sum-closest/
 */
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var lastDiff = Int.MAX_VALUE
        var res = 0
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    val threeSum = nums[i] + nums[j] + nums[k]
                    val diff = Math.abs(target - threeSum)
                    if (diff < lastDiff) {
                        lastDiff = diff
                        res = threeSum
                    }
                }
            }
        }
        return res
    }
}
