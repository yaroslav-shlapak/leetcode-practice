package com.shlapak.yaroslav.leetcode.problems1to100.problem42

import kotlin.math.max
import kotlin.math.min


/**
 *  42. Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.

 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
class TrappingRainWaterEfficientSimple {
    fun trap(height: IntArray): Int {
        if (height.size < 2) return 0

        var area = 0
        val maxLefts = IntArray(height.size)
        maxLefts[0] = height[0]
        for (i in 1 until height.size) {
            maxLefts[i] = maxOf(height[i], maxLefts[i - 1])
        }
        val maxRights = IntArray(height.size)
        maxRights[height.size - 1] = height[height.size - 1]
        for (i in height.size - 2 downTo 0) {
            maxRights[i] = maxOf(height[i], maxRights[i + 1])
        }

        for (i in height.indices) {
            val candidate = minOf(maxRights[i], maxLefts[i]) - height[i]
            if (candidate > 0) { // this is not really necessary as candidate is always positive
                area += candidate
            }
        }

        return area
    }
}

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        if (height.size < 2) return 0
        var l = 0
        var r = 1
        var maxLeft = height[l]
        var maxRight = height[r]
        var area = 0
        while (r < height.size - 1) {
            if (maxLeft < maxRight) {

                //area += min(maxLeft, maxRight) - height[]
            } else {

                area += min(maxLeft, maxRight) * (r - l)
            }
        }
        return area
    }
}

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