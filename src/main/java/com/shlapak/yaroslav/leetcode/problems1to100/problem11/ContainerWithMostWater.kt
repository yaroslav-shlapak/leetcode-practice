package com.shlapak.yaroslav.leetcode.problems1to100.problem11

/**
 * 11. Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/
 *
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var r = height.size - 1
        var l = 0
        var maxArea = 0
        while (r > l) {
            val width = r - l
            val candidateArea = minOf(height[r], height[l]) * width
            maxArea = maxOf(maxArea, candidateArea)
            if (height[r] > height[l]) {
                l++
            } else {
                r--
            }

        }
        return maxArea
    }

    fun maxArea2(height: IntArray): Int {
        var r = height.size - 1
        var l = 0
        var maxArea = 0
        while (r > l) {
            val area = if (height[r] > height[l]) {
                val a = height[l] * (r - l)
                l++
                a
            } else {
                val a = height[r] * (r - l)
                r--
                a
            }
            maxArea = maxOf(maxArea, area)
        }
        return maxArea
    }
}

class Solution {
    var maxArea = 0
    fun maxArea(height: IntArray): Int {
        height.asSequence().forEachIndexed { i1, h1 ->
            for (i2 in i1 + 1 until height.size) {
                val h2 = height[i2]
                val w = i2 - i1
                val h = Math.min(h1, h2)
                val area = calculateArea(h, w)
                updateMaxArea(area)
            }
        }

        return maxArea
    }

    private fun updateMaxArea(newArea: Int) {
        if (newArea > maxArea) maxArea = newArea
    }

    private fun calculateArea(height: Int, width: Int): Int {
        return height * width
    }
}