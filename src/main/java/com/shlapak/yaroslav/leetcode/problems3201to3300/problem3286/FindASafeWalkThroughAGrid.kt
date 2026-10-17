package com.shlapak.yaroslav.leetcode.problems3201to3300.problem3286

/**
 * 3286. Find a Safe Walk Through a Grid
 * https://leetcode.com/problems/find-a-safe-walk-through-a-grid/description/
 */
import java.util.ArrayDeque

class FindASafeWalkThroughAGrid {
    class BFS_01 {
        fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
            val m = grid.size
            val n = grid[0].size
            val queue = ArrayDeque<Pair<Int, Int>>()

            val minDamage = Array(m) { IntArray(n) { Int.MAX_VALUE } }
            minDamage[0][0] = grid[0][0]
            queue.addFirst(0 to 0)

            val dirs = arrayOf(
                intArrayOf(1, 0),
                intArrayOf(-1, 0),
                intArrayOf(0, 1),
                intArrayOf(0, -1),
            )

            while (queue.isNotEmpty()) {
                val (r, c) = queue.removeFirst()

                for ((dr, dc) in dirs) {
                    val nr = r + dr
                    val nc = c + dc

                    if (nr !in 0 until m || nc !in 0 until n) {
                        continue
                    }

                    val newDamage = minDamage[r][c] + grid[nr][nc]

                    if (newDamage < minDamage[nr][nc]) {
                        minDamage[nr][nc] = newDamage

                        if (grid[nr][nc] == 0) {
                            queue.addFirst(nr to nc)
                        } else {
                            queue.addLast(nr to nc)
                        }
                    }

                }
            }

            return minDamage[m - 1][n - 1] < health
        }
    }
}