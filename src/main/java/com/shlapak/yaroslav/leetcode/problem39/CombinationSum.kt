package com.shlapak.yaroslav.leetcode.problem39

/**
 * Created on 2019/07/01.
 * https://leetcode.com/problems/combination-sum/
 */
class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        val map = mutableMapOf<Int, List<Int>>()

        candidates.sorted().asSequence().forEach { cur ->
            if (cur == target) {
                list.add(listOf(cur))
                return list
            } else {

            }
        }

        return list
    }
}