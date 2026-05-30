package com.shlapak.yaroslav.leetcode.problems1301to1400.poblem1306

import kotlin.math.min

/**
 * 1306. Jump Game 3
 * https://leetcode.com/problems/jump-game-iii/description/
 */
class JumpGame3 { // constant time
    class Dfs {
        fun canReach(arr: IntArray, start: Int): Boolean {
            var res = false

            fun dfs(idx: Int) {
                if (res) return
                if (arr[idx] == 0) {
                    res = true
                    return
                }

                val lIdx = idx - arr[idx]
                val rIdx = idx + arr[idx]
                arr[idx] = -1
                if ((lIdx in 0..(arr.size - 1)) && arr[lIdx] != -1) {
                    dfs(lIdx)
                }
                if ((rIdx in 0..(arr.size - 1)) && arr[rIdx] != -1) {
                    dfs(rIdx)
                }
            }

            dfs(start)

            return res
        }
    }
}