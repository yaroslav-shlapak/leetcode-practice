package com.shlapak.yaroslav.leetcode.problems501to600.problem543

import com.shlapak.yaroslav.leetcode.utils.TreeNode

typealias Diameter = Int
typealias Height = Int

/**
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/
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