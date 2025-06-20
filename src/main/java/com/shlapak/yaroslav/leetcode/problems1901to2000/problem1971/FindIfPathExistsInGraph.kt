package com.shlapak.yaroslav.leetcode.problems1901to2000.problem1971

/**
 * 1971. Find if Path Exists in Graph
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
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