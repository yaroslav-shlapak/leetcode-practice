package com.shlapak.yaroslav.leetcode.problem16


/**
 * Created on 2019/04/18.
 * https://leetcode.com/problems/3sum-closest/
 */
class Solution {
    fun threeSumClosestNaive(nums: IntArray, target: Int): Int {
        var minDiff = Int.MAX_VALUE
        var closest = 0
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    val threeSum = nums[i] + nums[j] + nums[k]
                    val diff = Math.abs(target - threeSum)
                    if (diff < minDiff) {
                        minDiff = diff
                        closest = threeSum
                    }
                }
            }
        }
        return closest
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closest = 0
        var minDiff = Integer.MAX_VALUE
        for (i in 0 until nums.size - 2) {
            var head = i + 1
            var tail = nums.size - 1
            while (head < tail) {
                val threeSum = nums[i] + nums[head] + nums[tail]
                val diff = Math.abs(target - threeSum)
                if (diff < minDiff) {
                    minDiff = diff
                    closest = threeSum
                }
                when {
                    target - threeSum > 0 -> head++
                    target - threeSum < 0 -> tail--
                    else -> return target
                }
            }
        }
        return closest
    }
}
