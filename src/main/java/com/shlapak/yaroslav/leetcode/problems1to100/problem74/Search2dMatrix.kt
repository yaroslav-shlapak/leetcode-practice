package com.shlapak.yaroslav.leetcode.problems1to100.problem74

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/description/
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