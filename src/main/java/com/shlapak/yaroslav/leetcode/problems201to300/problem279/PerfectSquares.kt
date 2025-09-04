package com.shlapak.yaroslav.leetcode.problems201to300.problem279

class PerfectSquares {
    class DynamicProgramming {
        fun numSquares(n: Int): Int {
            val dp = IntArray(n + 1) { Int.MAX_VALUE }
            dp[0] = 0

            for (i in 1..n) {
                var j = 1
                while (j * j <= i) {
                    dp[i] = minOf(dp[i], dp[i - j * j] + 1)
                    j++
                }
            }

            return dp[n]
        }
    }

    class DynamicProgramming2 {
        fun numSquares(n: Int): Int {
            val dp = IntArray(n + 1) { Int.MAX_VALUE }
            dp[0] = 0

            for (i in 1..n) {
                for (j in 1..Math.sqrt(i.toDouble()).toInt()) {
                    dp[i] = minOf(dp[i], dp[i - j * j] + 1)
                }
            }

            return dp[n]
        }
    }

    class DynamicProgramming3 {
        fun numSquares(n: Int): Int {
            val res = IntArray(n + 1) { it }
            val squares = IntArray(100) { (it + 1) * (it + 1) }
            for (i in 1..n)
                for (j in squares) {
                    if (j > i) break
                    res[i] = minOf(res[i], 1 + res[i - j])
                }
            return res[n]
        }
    }

    class BreadthFirstSearch {
        fun numSquares(n: Int): Int {
            val queue: ArrayDeque<Int> = ArrayDeque()
            val visited = BooleanArray(n + 1) { false }
            queue.add(n)
            visited[n] = true
            var level = 0

            while (queue.isNotEmpty()) {
                level++
                val size = queue.size
                for (i in 0 until size) {
                    val curr = queue.removeFirst()
                    var j = 1
                    while (j * j <= curr) {
                        val next = curr - j * j
                        if (next == 0) {
                            return level
                        }
                        if (!visited[next]) {
                            visited[next] = true
                            queue.add(next)
                        }
                        j++
                    }
                }
            }

            return level
        }
    }

}