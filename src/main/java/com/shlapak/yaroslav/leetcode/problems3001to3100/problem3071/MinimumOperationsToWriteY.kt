package com.shlapak.yaroslav.leetcode.problems3001to3100.problem3075

/**
 * 3071. Minimum Operations to Write Y
 * https://leetcode.com/problems/minimum-operations-to-write-y/
 */
class MinimumOperationsToWriteY {
    class BruteForce {
        fun minimumOperationsToWriteY(grid: Array<IntArray>): Int {

            var minCount = Int.MAX_VALUE
            val n = grid.size
            fun isInY(i: Int, j: Int): Boolean {
                val isTopLeftToCenter = i == j && i <= n / 2
                val isTopRightToCenter = i + j == n - 1 && i <= n / 2
                val isCenterToBottom = j == n / 2 && i >= n / 2

                return if (isTopLeftToCenter || isTopRightToCenter || isCenterToBottom) true
                else false
            }

            fun countOps(y: Int, nonY: Int): Int {
                var count = 0
                for (i in 0..n - 1) {
                    for (j in 0..n - 1) {
                        if (isInY(i, j)) {
                            if (grid[i][j] != y) count++
                        } else {
                            if (grid[i][j] != nonY) count++
                        }
                    }
                }
                return count
            }

            for (y in 0 until 3) {
                for (nonY in 0 until 3)
                    if (y != nonY) {
                        minCount = minOf(countOps(y, nonY), minCount)
                    }
            }
            return minCount
        }
    }
}
