package com.shlapak.yaroslav.leetcode.problem42


/**
 * Created on 2019/07/04.
 * https://leetcode.com/problems/trapping-rain-water/
 */
class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var ans = 0
        var leftMax = 0
        var rightMax = 0
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]
                } else {
                    ans += leftMax - height[left]
                }
                ++left
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]
                } else {
                    ans += rightMax - height[right]
                }
                --right
            }
        }
        return ans
    }
}