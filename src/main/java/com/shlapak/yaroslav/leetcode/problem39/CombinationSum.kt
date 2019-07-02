package com.shlapak.yaroslav.leetcode.problem39

import java.util.*

/**
 * Created on 2019/07/01.
 * https://leetcode.com/problems/combination-sum/
 */
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