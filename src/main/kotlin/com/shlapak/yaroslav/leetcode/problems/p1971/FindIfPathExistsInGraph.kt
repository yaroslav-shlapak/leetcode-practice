package com.shlapak.yaroslav.leetcode.problems.p1971

/**
 * LeetCode 1971: Find If Path Exists in Graph.
 *
 * Checks whether two vertices are connected in an undirected graph.
 *
 * @see <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/">Problem statement</a>
 */
class FindIfPathExistsInGraph {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        if (source == destination) return true
        val map = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach { pair ->
            val u = pair[0]
            val v = pair[1]

            map.getOrPut(u) { mutableListOf() }.add(v)
            map.getOrPut(v) { mutableListOf() }.add(u)
        }

        val stack = ArrayDeque<Int>()
        stack.add(source)
        val visited = mutableSetOf<Int>()
        while (!stack.isEmpty()) {
            val edge = stack.removeLast()
            if (visited.contains(edge)) continue
            visited.add(edge)
            val con = map[edge]
            if (con == null) continue
            for (c in con) {
                if (c == destination) {
                    return true
                }
                stack.addLast(c)
            }
        }

        return false
    }
}
