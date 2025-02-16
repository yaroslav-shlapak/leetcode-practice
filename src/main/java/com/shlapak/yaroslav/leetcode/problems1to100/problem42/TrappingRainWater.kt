package com.shlapak.yaroslav.leetcode.problems1to100.problem42

import kotlin.math.max
import kotlin.math.min


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

class Solution2 {
    fun trap(height: IntArray): Int {
        var ans = 0

        height.asSequence().forEachIndexed { index, element ->
            var leftMax = 0
            var rightMax = 0
            for (i in index downTo 0) {
                leftMax = max(leftMax, height[i])
            }
            for (i in index until height.size) {
                rightMax = max(rightMax, height[i])
            }
            ans += min(leftMax, rightMax) - element
        }

        return ans
    }
}