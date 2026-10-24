package com.shlapak.yaroslav.leetcode.problems.p0070

/**
 * LeetCode 70: Climbing Stairs.
 *
 * Counts ways to climb stairs taking one or two steps at a time.
 *
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">Problem statement</a>
 */
class ClimbingStairs {
    fun climbStairs(n: Int): Int {

        val memo = IntArray(n + 1)
        fun dfs(i: Int): Int {
            if (i > n) return 0
            if (memo[i] != 0) return memo[i]
            if (i == n) return 1
            memo[i] = dfs(i + 1) + dfs(i + 2)
            return memo[i]
        }

        return dfs(0)
    }
}
