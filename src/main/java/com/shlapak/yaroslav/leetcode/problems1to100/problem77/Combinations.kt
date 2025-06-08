package com.shlapak.yaroslav.leetcode.problems1to100.problem77

/**
 * 
 */
class Combinations {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun backtracking(start: Int, comb: MutableList<Int>) {
            if (comb.size == k) {
                res.add(comb.toList())
                return
            }

            for (i in start..n) {
                comb.add(i)
                backtracking(i + 1, comb)
                comb.removeLast()
            }
        }

        backtracking(1, mutableListOf())

        return res
    }
}