package com.shlapak.yaroslav.leetcode.problems1to100.problem40

import java.util.*


/**
 * Created on 2019/07/02.
 * https://leetcode.com/problems/combination-sum-ii/
 */
class CombinationSum2 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        // using backtracking run all find all possible subsets

        val res = mutableListOf<MutableList<Int>>()
        val comb = mutableListOf<Int>()
        candidates.sort()

        fun backtracking(i: Int, sum: Int) {
            if (sum == target) {
                res.add(comb.toMutableList())
            }

            for (j in i until candidates.size) {
                if (j > i && candidates[j] == candidates[j - 1]) {
                    continue
                }
                val cand = candidates[j]
                val newSum = sum + cand
                if (newSum > target) {
                    break
                }
                comb.add(cand)
                backtracking(j + 1, newSum)
                comb.removeLast()
            }

        }
        backtracking(0, 0)

        return res
    }
}

class Solution {
    val result = mutableSetOf<List<Int>>()
    val current = mutableListOf<Int>()
    val set = mutableSetOf<Int>()
    lateinit var c: IntArray
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        c = candidates
        combinationSum2(target, 0)
        return result.toList()
    }

    fun combinationSum2(target: Int, start: Int) {
        if (target > 0) {
            for (i in start until c.size) {
                if (!set.contains(i)) {
                    current.add(c[i])
                    set.add(i)
                    combinationSum2(target - c[i], i)
                    current.removeAt(current.size - 1)
                    set.remove(i)
                }
            }
        }
        if (target == 0) result.add(ArrayList(current).sorted())
    }
}

class Solution2 {
    val result = mutableListOf<List<Int>>()
    val path = mutableListOf<Int>()
    lateinit var cand: IntArray
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        cand = candidates
        dfs(0, target)
        return result
    }

    fun dfs(cur: Int, target: Int) {
        if (target == 0) {
            result.add(ArrayList(path))
            return
        }
        if (target < 0) return
        for (i in cur until cand.size) {
            if (i > cur && cand[i] == cand[i - 1]) {
                // nothing here
            } else {
                path.add(path.size, cand[i])
                dfs(i + 1, target - cand[i])
                path.removeAt(path.size - 1)
            }
        }
    }
}