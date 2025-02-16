package com.shlapak.yaroslav.leetcode.problems1to100.problem11

/**
 * Created on 2019/04/11.
 * https://leetcode.com/problems/container-with-most-water/
 */
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