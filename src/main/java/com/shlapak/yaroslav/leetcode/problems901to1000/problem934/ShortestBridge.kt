package com.shlapak.yaroslav.leetcode.problems901to1000.problem934

/**
 * 934. Shortest Bridge
 * https://leetcode.com/problems/shortest-bridge/description/
 */
class ShortestBridge {
    class Solution {
        data class Key(val i: Int, val j: Int)

        fun shortestBridge(grid: Array<IntArray>): Int {

            val queue = ArrayDeque<Key>()
            var start: Key = Key(-1, -1)

            for (i in 0 until grid.size) {
                for (j in 0 until grid[0].size) {
                    if (grid[i][j] == 1) {
                        start = Key(i, j)
                    }
                }
            }

            queue.addFirst(start)

            val moves = mutableListOf<Key>(Key(0, -1), Key(0, 1), Key(1, 0), Key(-1, 0))

            val visited = mutableSetOf<Key>(start)

            while (queue.isNotEmpty()) {
                val levelSize = queue.size
                for (i in 0 until levelSize) {
                    val key = queue.removeFirst()
                    for (move in moves) {
                        val (iInc, jInc) = move
                        val newI = (key.i + move.i).coerceAtMost(grid.size - 1).coerceAtLeast(0)
                        val newJ = (key.j + move.j).coerceAtMost(grid[0].size - 1).coerceAtLeast(0)
                        val p = grid[newI][newJ]
                        val newKey = Key(newI, newJ)
                        if (p == 1 && !visited.contains(newKey)) {
                            queue.addLast(Key(newI, newJ))
                            visited.add(newKey)
                        }
                    }
                }
            }

            queue.addAll(visited)
            var count = -1

            while (queue.isNotEmpty()) {

                val levelSize = queue.size
                count++
                for (i in 0 until levelSize) {
                    val key = queue.removeFirst()

                    for (move in moves) {
                        val (iInc, jInc) = move
                        val newI = (key.i + move.i).coerceAtMost(grid.size - 1).coerceAtLeast(0)
                        val newJ = (key.j + move.j).coerceAtMost(grid[0].size - 1).coerceAtLeast(0)
                        val p = grid[newI][newJ]
                        val newKey = Key(newI, newJ)
                        if (p == 1 && !visited.contains(newKey)) {
                            return count
                        }
                        if (p == 0 && !visited.contains(newKey)) {
                            queue.addLast(Key(newI, newJ))
                            visited.add(newKey)
                        }
                    }
                }

            }

            return -1
        }
    }

    /*
    [
    [0,1,0,0,0],
    [0,1,0,1,1],
    [0,0,0,0,1],
    [0,0,0,0,0],
    [0,0,0,0,0]]

    [
        [1,1,1,1,1],
        [1,0,0,0,1],
        [1,0,1,0,1],
        [1,0,0,0,1],
        [1,1,1,1,1]
        ]

     */
}