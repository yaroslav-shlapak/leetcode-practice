package com.shlapak.yaroslav.leetcode.problems901to1000.problem935

/**
 * 935. Knight Dialer
 * https://leetcode.com/problems/knight-dialer/description/
 */

class KnightDialler {
    class BacktrackingWithMemoization {
        fun knightDialer(n: Int): Int {
            val mod = 1_000_000_007

            val jumps = arrayOf(
                intArrayOf(4, 6),
                intArrayOf(6, 8),
                intArrayOf(7, 9),
                intArrayOf(4, 8),
                intArrayOf(3, 9, 0),
                intArrayOf(),
                intArrayOf(1, 7, 0),
                intArrayOf(2, 6),
                intArrayOf(1, 3),
                intArrayOf(2, 4)
            )

            val memo = Array(10) { IntArray(n + 1) { -1 } }

            fun dfs(digit: Int, len: Int): Int {
                if (len == n) return 1
                if (memo[digit][len] != -1) return memo[digit][len]

                var count = 0
                for (next in jumps[digit]) {
                    count = (count + dfs(next, len + 1)) % mod
                }

                memo[digit][len] = count
                return count
            }

            var res = 0
            for (digit in 0..9) {
                res = (res + dfs(digit, 1)) % mod
            }

            return res
        }
    }

    class BruteForceBacktracking {
        fun knightDialer(n: Int): Int {
            val jumps = arrayOf(
                intArrayOf(4, 6),
                intArrayOf(6, 8),
                intArrayOf(7, 9),
                intArrayOf(4, 8),
                intArrayOf(3, 9, 0),
                intArrayOf(),
                intArrayOf(1, 7, 0),
                intArrayOf(2, 6),
                intArrayOf(1, 3),
                intArrayOf(2, 4)
            )

            fun dfs(digit: Int, len: Int): Int {
                if (len == n) return 1

                var count = 0
                for (next in jumps[digit]) {
                    count += dfs(next, len + 1)
                }
                return count
            }

            var res = 0
            for (digit in 0..9) {
                res += dfs(digit, 1)
            }
            return res
        }
    }

    class BottomUpDp {
        fun knightDialer(n: Int): Int {
            if (n == 1) return 10

            val mod = (1e9 + 7).toInt()

            val jumps = arrayOf(
                intArrayOf(4, 6), // 0
                intArrayOf(6, 8), // 1
                intArrayOf(7, 9), // 2
                intArrayOf(4, 8), // 3
                intArrayOf(3, 9, 0), // 4
                intArrayOf(), // 5
                intArrayOf(1, 7, 0), // 6
                intArrayOf(2, 6), // 7
                intArrayOf(1, 3), // 8
                intArrayOf(2, 4), // 9
            )

            var dp = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)

            for (i in 1 until n) {
                val nextDp = IntArray(10)
                for (j in 0 until 10) {
                    for (m in jumps[j]) {
                        nextDp[m] = (nextDp[m] + dp[j]) % mod
                    }
                }
                dp = nextDp
            }

            var res = 0
            for (n in dp) {
                res = (res + n) % mod
            }

            return res
        }
    }
}