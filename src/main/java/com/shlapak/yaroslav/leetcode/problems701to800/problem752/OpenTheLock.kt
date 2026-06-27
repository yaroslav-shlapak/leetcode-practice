package com.shlapak.yaroslav.leetcode.problems701to800.problem752

/**
 * 752. Open the Lock
 *
 * https://leetcode.com/problems/open-the-lock/description/
 */

class OpenTheLock {

    class Bfs {
        fun openLock(deadends: Array<String>, target: String): Int {
            val dead = deadends.toSet()
            val start = "0000"
            if (start in dead) return -1
            if (target in dead) return -1
            if (start == target) return 0

            val queue = ArrayDeque<Pair<String, Int>>()
            queue.addLast(start to 0)
            val visited = mutableSetOf(start)

            while (queue.isNotEmpty()) {
                val (cur, moves) = queue.removeFirst()

                val nexts = getNextMoves(cur)
                for (next in nexts) {
                    if (next in dead) continue
                    if (next in visited) continue

                    if (next == target) return moves + 1

                    visited.add(next)
                    queue.addLast(next to moves + 1)
                }
            }

            return -1
        }

        private fun getNextMoves(cur: String): List<String> {
            val result = mutableListOf<String>()

            for (i in cur.indices) {
                val up = cur.toCharArray()
                val down = cur.toCharArray()

                up[i] = if (cur[i] == '9') '0' else cur[i] + 1
                down[i] = if (cur[i] == '0') '9' else cur[i] - 1

                result.add(String(up))
                result.add(String(down))
            }

            return result
        }
    }
}