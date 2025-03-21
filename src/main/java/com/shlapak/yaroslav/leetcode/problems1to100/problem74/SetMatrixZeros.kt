package com.shlapak.yaroslav.leetcode.problems1to100.problem74

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */
class SetMatrixZeros {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val ro = BooleanArray(matrix.size)
        val col = BooleanArray(matrix[0].size)
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    ro[i] = true
                    col[j] = true
                }
            }
        }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (ro[i] || col[j]) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}