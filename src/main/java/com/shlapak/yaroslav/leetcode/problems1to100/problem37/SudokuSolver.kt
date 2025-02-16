package com.shlapak.yaroslav.leetcode.problems1to100.problem37

/**
 * Created on 2019/06/12.
 * https://leetcode.com/problems/sudoku-solver/
 */
class Solution {
    private lateinit var board: Array<CharArray>

    fun solveSudoku(b: Array<CharArray>): Unit {
        board = b
        dfs(0)
        printBoard()
    }

    fun dfs(n: Int): Boolean {
        //
        if (n == 81) return true
        val x = n / 9
        val y = n % 9
        if (board[x][y] != '.') {
            return dfs(n + 1)
        }
        for (i in 0 until 9) {
            board[x][y] = ('1'.toInt() + i).toChar()
            if (validate(x, y) && dfs(n + 1)) {
                return true
            }
            board[x][y] = '.'

        }
        return false
    }

    fun validate(x: Int, y: Int): Boolean {
        for (i in 0 until 9) {
            if (i != x && board[i][y] == board[x][y]) return false
            if (i != y && board[x][i] == board[x][y]) return false
        }
        val r = x / 3 * 3
        val c = y / 3 * 3
        for (i in r until r + 3) {
            for (j in c until c + 3) {
                if (i == x && j == y) continue
                if (board[i][j] == board[x][y]) return false
            }
        }
        return true
    }

    private fun printBoard() {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                print("${board[i][j]}")
                if (j < 8) {
                    print(", ")
                }
            }
            println()
        }
    }
}