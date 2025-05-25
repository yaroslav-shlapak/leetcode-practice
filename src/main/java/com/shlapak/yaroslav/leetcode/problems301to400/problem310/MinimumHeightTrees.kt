package com.shlapak.yaroslav.leetcode.problems301to400.problem310

import java.util.LinkedList

/**
 * 310. Minimum Height Trees
 * https://leetcode.com/problems/minimum-height-trees/description/
 */
class MinimumHeightTrees {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)
        // find leaves connections
        val adj = mutableMapOf<Int, MutableList<Int>>()
        for (edge in edges) {
            adj.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            adj.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }

        // count neighbours and add leaves to queue
        val edgeCount = mutableMapOf<Int, Int>()
        val leaves = LinkedList<Int>()
        for (entry in adj) {
            val (edge, nei) = entry
            if (nei.size == 1) {
                leaves.offer(edge)
            }
            edgeCount[edge] = nei.size
        }
        // decrement visited neighbours layer by layer until whether empty or two or less nodes
        var rem = n
        while (leaves.isNotEmpty() && rem > 2) {
            val levelSize = leaves.size
            for (i in 0 until levelSize) {
                val leaf = leaves.poll()
                rem--
                (adj[leaf]!!).forEach { nei ->
                    edgeCount[nei] = edgeCount[nei]!! - 1
                    if (edgeCount[nei] == 1) {
                        leaves.offer(nei)
                    }
                }
            }
        }
        return leaves.toList()
    }
}

