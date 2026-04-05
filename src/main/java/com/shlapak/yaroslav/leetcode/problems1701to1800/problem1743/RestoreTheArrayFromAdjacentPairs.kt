package com.shlapak.yaroslav.leetcode.problems1701to1800.problem1768

/*
 * 1743. Restore the Array From Adjacent Pairs
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 */
class RestoreTheArrayFromAdjacentPairs {
    class Solution {
        fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
            val res = mutableListOf<Int>()
            val queue = ArrayDeque<Int>()
            val gr = mutableMapOf<Int, MutableList<Int>>()

            for (pair in adjacentPairs) {
                val p1 = pair[0]
                val p2 = pair[1]

                gr.getOrPut(p1) { mutableListOf<Int>() }.add(p2)
                gr.getOrPut(p2) { mutableListOf<Int>() }.add(p1)
            }
            var edge: Int = 0

            for (node in gr) {
                if (node.value.size == 1) {
                    edge = node.key
                }
            }

            queue.addAll(gr[edge]!!)
            gr[edge] = mutableListOf<Int>()
            res.add(edge)

            while (queue.isNotEmpty()) {
                val levelSize = queue.size
                for (i in 0 until levelSize) {
                    val key = queue.removeFirst()
                    if (gr[key]?.isNotEmpty() ?: false) {
                        queue.addAll(gr[key]!!)
                        res.add(key)
                        if ( gr[key]!!.size == 1) {
                            return res.toIntArray()
                        }
                        gr[key] = mutableListOf<Int>()
                    }
                }
            }

            return res.toIntArray()
        }
    }

    class MoreOptimalSolution {
        fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
            val graph = mutableMapOf<Int, MutableList<Int>>()

            for ((a, b) in adjacentPairs) {
                graph.getOrPut(a) { mutableListOf() }.add(b)
                graph.getOrPut(b) { mutableListOf() }.add(a)
            }

            var start = 0
            for ((node, neighbors) in graph) {
                if (neighbors.size == 1) {
                    start = node
                    break
                }
            }

            val n = adjacentPairs.size + 1
            val result = IntArray(n)
            result[0] = start
            result[1] = graph[start]!![0]

            for (i in 2 until n) {
                val neighbors = graph[result[i - 1]]!!
                result[i] = if (neighbors[0] == result[i - 2]) neighbors[1] else neighbors[0]
            }

            return result
        }
    }
}