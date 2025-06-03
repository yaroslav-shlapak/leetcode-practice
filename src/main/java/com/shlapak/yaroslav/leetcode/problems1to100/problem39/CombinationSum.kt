package com.shlapak.yaroslav.leetcode.problems1to100.problem39

import java.util.*


/**
 * Created on 2019/07/01.
 * https://leetcode.com/problems/combination-sum/
 */
class CombinationSum {
    /*
    time complexity: O(2 ^ (t/n)) where n is the number of candidates and t is the target
    space complexity: O(t/n) for the recursion stack
     */
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        // create backtracing function which will add numbers
        // the base case if when sum is larger than taget
        // if sum is equal to target add to the result

        val res = mutableListOf<MutableList<Int>>()

        // [2,3,6,7]
        // target = 7
        // 2
        fun backtracking(sum: Int, i: Int, list: MutableList<Int>) {
            if (sum == target) {
                res.add(list.toMutableList())
                return
            }

            for (j in i until candidates.size) {
                val cand = candidates[j]
                val newSum = sum + cand
                if (sum + cand > target) {
                    continue
                }
                list.add(cand)
                backtracking(newSum, j, list)
                list.removeLast()
            }
        }
        backtracking(0, 0, mutableListOf<Int>())
        return res
    }
}

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val set = mutableSetOf<List<Int>>()
        val stack = Stack<Pair<Int, MutableList<Int>>>()

        val c = candidates.asSequence()

        candidates.forEach {
            stack.push(Pair(it, mutableListOf(it)))
        }

        while (stack.isNotEmpty()) {
            val (sum, l) = stack.pop()
            c.forEach {
                if (sum == target) {
                    set.add(l.sorted())
                } else if (sum + it <= target) {
                    val temp = l.toMutableList()
                    temp.add(it)
                    stack.add(Pair(sum + it, temp))
                }

            }
        }

        return set.toList()
    }
}


class Solution2 {
    val result = mutableListOf<List<Int>>()
    val current = mutableListOf<Int>()
    lateinit var c: IntArray

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        c = candidates
        combinationSum(target, 0)
        return result
    }

    fun combinationSum(target: Int, start: Int) {
        if (target > 0) {
            for (i in start until c.size) {
                current.add(c[i])
                combinationSum(target - c[i], i)
                current.removeAt(current.size - 1)
            }
        }
        if (target == 0) result.add(ArrayList(current))
    }
}