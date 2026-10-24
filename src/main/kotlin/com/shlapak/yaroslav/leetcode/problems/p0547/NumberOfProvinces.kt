package com.shlapak.yaroslav.leetcode.problems.p0547

import com.shlapak.yaroslav.leetcode.common.TreeNode

typealias Diameter = Int
typealias Height = Int

/**
 * LeetCode 547: Number of Provinces.
 *
 * Counts connected components in a city adjacency matrix.
 *
 * @see <a href="https://leetcode.com/problems/number-of-provinces/">Problem statement</a>
 */
class NumberOfProvinces {
    class Bfs {
        fun findCircleNum(isConnected: Array<IntArray>): Int {
            val n = isConnected.size
            val visited = BooleanArray(n)
            var count = 0

            for (city in 0 until n) {
                if (!visited[city]) {
                    count++
                    bfs(city, isConnected, visited)
                }
            }

            return count
        }

        private fun bfs(
            start: Int,
            isConnected: Array<IntArray>,
            visited: BooleanArray
        ) {
            val queue = ArrayDeque<Int>()
            queue.addLast(start)

            while (queue.isNotEmpty()) {
                val city = queue.removeFirst()
                visited[city] = true

                for (nextCity in isConnected.indices) {
                    if (isConnected[city][nextCity] == 1 && !visited[nextCity]) {
                        queue.addLast(nextCity)
                    }
                }
            }
        }
    }

    class Dfs {
        fun findCircleNum(isConnected: Array<IntArray>): Int {
            val n = isConnected.size
            val visited = BooleanArray(n)
            var count = 0

            for (city in 0 until n) {
                if (!visited[city]) {
                    count++
                    dfs(city, isConnected, visited)
                }
            }

            return count
        }

        private fun dfs(
            city: Int,
            isConnected: Array<IntArray>,
            visited: BooleanArray
        ) {
            visited[city] = true

            for (nextCity in isConnected.indices) {
                if (isConnected[city][nextCity] == 1 && !visited[nextCity]) {
                    dfs(nextCity, isConnected, visited)
                }
            }
        }
    }
}
