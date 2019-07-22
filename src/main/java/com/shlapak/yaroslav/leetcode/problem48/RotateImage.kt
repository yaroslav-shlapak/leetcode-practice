package com.shlapak.yaroslav.leetcode.problem48

/**
 * Created on 2019/07/19.
 * https://leetcode.com/problems/rotate-image/
 */
class Solution {

    fun rotate(matrix: Array<IntArray>) {
        if (matrix.size > 1) {
            transpose(matrix)
            reverseRows(matrix)
        }
    }

    private fun transpose(matrix: Array<IntArray>) {
        for (i in matrix.indices) {
            for (j in i until matrix[i].size) {
                val temp = matrix[j][i]
                matrix[j][i] = matrix[i][j]
                matrix[i][j] = temp
            }
        }
    }

    private fun reverseRows(matrix: Array<IntArray>) {
        for (i in matrix.indices) {
            for (j in 0 until matrix[i].size / 2) {
                val temp = matrix[i][j]
                val ind = matrix[i].size - 1 - j
                matrix[i][j] = matrix[i][ind]
                matrix[i][ind] = temp
            }
        }
    }
}