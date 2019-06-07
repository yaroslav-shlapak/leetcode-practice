package com.shlapak.yaroslav.leetcode.problem36

/**
 * Created on 2019/06/07.
 * https://leetcode.com/problems/valid-sudoku/
 */
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