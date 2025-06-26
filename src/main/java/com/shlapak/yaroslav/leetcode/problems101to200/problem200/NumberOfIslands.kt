package com.shlapak.yaroslav.leetcode.problems101to200.problem200

class NumberOfIslands {
    class Dfs {
        fun numIslands(grid: Array<CharArray>): Int {
            // run loop and run dfs for each index until island is found
            // save visited into map
            val n = grid.size
            val m = grid[0].size
            val map = mutableMapOf<Pair<Int, Int>, Int>()

            fun dfs(i: Int, j: Int) {
                if (i >= n || i < 0 || j >= m || j < 0) {
                    return
                }
                val value = map[i to j]
                if (value != null) {
                    return
                }
                if (grid[i][j] == '0') {
                    map[i to j] = 0
                    return
                }
                map[i to j] = 1
                dfs(i + 1, j)
                dfs(i - 1, j)
                dfs(i, j + 1)
                dfs(i, j - 1)
            }

            var count = 0
            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (grid[i][j] == '1' && !map.contains(i to j)) {
                        dfs(i, j)
                        count++
                    }
                }
            }

            return count
        }
    }

    class Bfs {
        fun numIslands(grid: Array<CharArray>): Int {
            val n = grid.size
            val m = grid[0].size
            val visited = Array(n) { BooleanArray(m) }
            var count = 0

            fun bfs(i: Int, j: Int) {
                val queue = ArrayDeque<Pair<Int, Int>>()
                queue.addLast(i to j)
                visited[i][j] = true

                while (queue.isNotEmpty()) {
                    val (x, y) = queue.removeFirst()
                    for (dx in -1..1) {
                        for (dy in -1..1) {
                            if (Math.abs(dx) + Math.abs(dy) == 1) { // Only horizontal and vertical moves
                                val newX = x + dx
                                val newY = y + dy
                                if (newX in 0 until n && newY in 0 until m && !visited[newX][newY] && grid[newX][newY] == '1') {
                                    visited[newX][newY] = true
                                    queue.addLast(newX to newY)
                                }
                            }
                        }
                    }
                }
            }

            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        bfs(i, j)
                        count++
                    }
                }
            }

            return count
        }
    }
}
