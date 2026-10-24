package com.shlapak.yaroslav.leetcode.problems.p1791

/**
 * LeetCode 1791: Find Center of Star Graph.
 *
 * Finds the common center of a star graph's edges.
 *
 * @see <a href="https://leetcode.com/problems/find-center-of-star-graph/">Problem statement</a>
 */
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
