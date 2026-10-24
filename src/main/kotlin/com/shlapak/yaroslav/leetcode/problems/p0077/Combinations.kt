package com.shlapak.yaroslav.leetcode.problems.p0077

/**
 * LeetCode 77: Combinations.
 *
 * Generates all k-element combinations from the integers 1 through n.
 *
 * @see <a href="https://leetcode.com/problems/combinations/">Problem statement</a>
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
