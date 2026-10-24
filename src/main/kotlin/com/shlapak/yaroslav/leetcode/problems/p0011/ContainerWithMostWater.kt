package com.shlapak.yaroslav.leetcode.problems.p0011

/**
 * LeetCode 11: Container with Most Water.
 *
 * Finds the greatest area enclosed by two vertical lines.
 *
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">Problem statement</a>
 */
class ContainerWithMostWater {
    class Oct042025 {
        fun maxArea(height: IntArray): Int {
            var l = 0
            var r = height.size - 1
            var max = 0
            while (r > l) {
                val w = r - l
                val h = minOf(height[r], height[l])
                val area = w * h
                max = maxOf(area, max)
                if (height[r] > height[l]) {
                    l++
                } else {
                    r--
                }
            }
            return max
        }
    }

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

class ContainerWithMostWaterLegacy {
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
