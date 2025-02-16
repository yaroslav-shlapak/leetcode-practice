package com.shlapak.yaroslav.leetcode.problems1to100.problem36


/**
 * 36. Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/
 */
class ValidSudoku {
    /**
     * Determine if a 9 x 9 Sudoku board is valid.
     * Only the filled cells need to be validated according to the following rules:
     *
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * Note:
     *
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     *
     */
    private val boardSize = 9
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val columns = MutableList<MutableSet<Char>>(boardSize) { mutableSetOf() }
        val subBoxes = MutableList<MutableSet<Char>>(boardSize) { mutableSetOf() }
        val rows = MutableList<MutableSet<Char>>(boardSize) { mutableSetOf() }
        for (i in 0 until boardSize) {
            for (j in 0 until boardSize) {
                if (!rows[i].addIfValid(board[i][j])) {
                    return false
                }
                if (!columns[j].addIfValid(board[i][j])) {
                    return false
                }
                /**
                 * 0: 0 1 2 | 3 4 5
                 * 1: 0 1 2 | 3 4 5
                 * 2: 0 1 2 | 3 4 5
                 * -  - - - | - - -
                 * 3: 0 1 2 |
                 * 4: 0 1 2 |
                 * 5: 0 1 2 |
                 */
                val subBoxIndex = i / 3 + (j / 3 * 3)
                if (!subBoxes[subBoxIndex].addIfValid(board[i][j])) {
                    return false
                }
            }
        }
        return true
    }

    private fun MutableSet<Char>.addIfValid(c: Char): Boolean {
        return when {
            c == '.' -> true
            !contains(c) -> {
                add(c)
                true
            }
            else -> {
                false
            }
        }
    }

}

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowSets = mutableMapOf<Int, MutableSet<Char>>()
        val columnSets = mutableMapOf<Int, MutableSet<Char>>()
        val boxSets = mutableMapOf<Int, MutableSet<Char>>()

        board.forEachIndexed { arrayIndex, chars ->
            chars.forEachIndexed { charIndex, c ->
                if (c != '.') {
                    val boxIndex = arrayIndex / 3 * 3 + charIndex / 3
                    if (!rowSets.addChar(arrayIndex, c)
                        || !columnSets.addChar(charIndex, c)
                        || !boxSets.addChar(boxIndex, c)
                    ) {
                        return false
                    }
                }
            }
        }

        return true
    }

    private fun MutableMap<Int, MutableSet<Char>>.addChar(index: Int, c: Char): Boolean {
        return when {
            !this.containsKey(index) -> {
                val set = mutableSetOf<Char>()
                set.add(c)
                this[index] = set
                true
            }

            else -> {
                this[index]!!.add(c)
            }
        }
    }
}

class Solution2 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = mutableSetOf<String>()

        board.forEachIndexed { arrayIndex, chars ->
            chars.forEachIndexed { charIndex, c ->
                if (c != '.') {
                    if (!set.add("$c in row $arrayIndex")
                        || !set.add("$c in column $charIndex")
                        || !set.add("$c in box ${arrayIndex / 3} - ${charIndex / 3}")
                    ) {
                        return false
                    }
                }
            }
        }
        return true
    }
}