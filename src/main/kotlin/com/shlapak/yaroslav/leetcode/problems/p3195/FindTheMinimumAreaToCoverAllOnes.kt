package com.shlapak.yaroslav.leetcode.problems.p3195

/**
 * LeetCode 3195: Find the Minimum Area to Cover All Ones.
 *
 * Finds the area of the smallest axis-aligned rectangle covering all ones.
 *
 * @see <a href="https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones/">Problem statement</a>
 */
class FindTheMinimumAreaToCoverAllOnes {
    class Optimal {
        fun minimumArea(grid: Array<IntArray>): Int {
            var sX = grid[0].size - 1
            var sY = grid.size - 1
            var eX = 0
            var eY = 0

            for (i in 0 until grid.size) {
                for (j in 0 until grid[0].size) {
                    if (grid[i][j] == 1) {
                        sX = minOf(sX, j)
                        sY = minOf(sY, i)
                        eX = maxOf(eX, j)
                        eY = maxOf(eY, i)
                    }
                }
            }

            return (eX - sX + 1) * (eY - sY + 1)
        }
    }

}
