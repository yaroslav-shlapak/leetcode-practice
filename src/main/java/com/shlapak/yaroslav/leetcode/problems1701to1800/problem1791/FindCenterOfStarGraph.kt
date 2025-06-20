package com.shlapak.yaroslav.leetcode.problems1701to1800.problem1791

class FindCenterOfStarGraph {
    fun findCenter(edges: Array<IntArray>): Int {
        val list = listOf(edges[0][0], edges[0][1], edges[1][0], edges[1][1])
        val set = mutableSetOf<Int>()
        for (e in list) {
            if (set.contains(e)) {
                return e
            }
            set.add(e)
        }

        return -1
    }
}