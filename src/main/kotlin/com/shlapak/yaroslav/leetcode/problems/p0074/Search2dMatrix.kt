package com.shlapak.yaroslav.leetcode.problems.p0074

/**
 * LeetCode 74: Search a 2D Matrix.
 *
 * Searches a matrix whose rows form a sorted sequence.
 *
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">Problem statement</a>
 */
class Search2dMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        var l = 0
        var r = m * n - 1
        while (l <= r) {
            val mid = l + (r - l) / 2
            val row = mid/n
            val pos = mid%n
            when {
                matrix[row][pos] == target -> return true
                matrix[row][pos] > target -> r = mid - 1
                else -> l = mid + 1
            }
        }
        return false
    }
}
