package com.shlapak.yaroslav.leetcode.problems901to1000.problem994

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 */
class RootingOranges {
    class BFS {
        fun orangesRotting(grid: Array<IntArray>): Int {
            /*
            find all rotten oranges, if there are none return 0
            using BFS start rotting process until it finishes
            the process finishes when all adjacent oranges are visited
            and when we cannot do rotting

            check if there are fresh oranges if there are none return number of minutes (BFS layers) else return -1
            */

            val n = grid.size

            val m = grid[0].size
            val queue = ArrayDeque<Pair<Int, Int>>()

            var freshCount = 0
            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (grid[i][j] == 2) {
                        queue.addLast(i to j)
                    }
                    if (grid[i][j] == 1) {
                        freshCount++
                    }
                }
            }

            if (freshCount == 0) return 0
            var mins = -1
            while (queue.isNotEmpty()) {
                mins++
                val levelSize = queue.size
                for (k in 0 until levelSize) {
                    val (i, j) = queue.removeFirst()
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2
                        freshCount--
                        queue.addLast(i + 1 to j)
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2
                        freshCount--
                        queue.addLast(i - 1 to j)
                    }
                    if (j + 1 < m && grid[i][j + 1] == 1) {
                        grid[i][j + 1] = 2
                        freshCount--
                        queue.addLast(i to j + 1)
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        grid[i][j - 1] = 2
                        freshCount--
                        queue.addLast(i to j - 1)
                    }
                }
            }

            return if (freshCount == 0) mins else -1
        }
    }

    class BFSElegant {
        fun orangesRotting(grid: Array<IntArray>): Int {
            val queue = ArrayDeque<Pair<Int, Int>>()
            var freshCount = 0
            for (i in grid.indices) {
                for (j in grid[i].indices) {
                    if (grid[i][j] == 2) {
                        queue.add(Pair(i, j))
                    } else if (grid[i][j] == 1) {
                        freshCount++
                    }
                }
            }

            if (freshCount == 0) return 0

            var minutes = 0
            val directions = arrayOf(
                Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0)
            )

            while (queue.isNotEmpty()) {
                val size = queue.size
                for (i in 0 until size) {
                    val (x, y) = queue.removeFirst()
                    for ((dx, dy) in directions) {
                        val newX = x + dx
                        val newY = y + dy
                        if (newX in grid.indices && newY in grid[newX].indices && grid[newX][newY] == 1) {
                            grid[newX][newY] = 2
                            freshCount--
                            queue.add(Pair(newX, newY))
                        }
                    }
                }
                minutes++
            }

            return if (freshCount > 0) -1 else minutes - 1
        }
    }
}