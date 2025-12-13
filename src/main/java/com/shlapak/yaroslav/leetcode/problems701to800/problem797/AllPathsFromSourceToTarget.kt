package com.shlapak.yaroslav.leetcode.problems701to800.problem797

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
class AllPathsFromSourceToTarget {
    class DFSAndBacktracking {
        fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
            val last = graph.size - 1
            val res = mutableListOf<List<Int>>()
            fun dfs(n: Int, list: MutableList<Int>) {
                if (n == last) {
                    res.add(list.toList())
                    return
                }
                for (num in graph[n]) {
                    list.add(num)
                    dfs(num, list)
                    list.removeLast()
                }
            }

            dfs(0, mutableListOf(0))
            return res
        }
    }
    class Backtracking {
        fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
            val res = mutableListOf<List<Int>>()
            val path = mutableListOf<Int>()
            val target = graph.size - 1

            fun backtrack(node: Int) {
                path.add(node)
                if (node == target) {
                    res.add(path.toList())
                } else {
                    for (next in graph[node]) {
                        backtrack(next)
                    }
                }
                path.removeAt(path.size - 1)
            }

            backtrack(0)

            return res
        }
    }
}