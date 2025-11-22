package com.shlapak.yaroslav.leetcode.problems1to100.problem55

/*
    * 55. Jump Game
    * https://leetcode.com/problems/jump-game/
 */
class JumpGame {

    class GreedyOptimal {
        fun canJump(nums: IntArray): Boolean {
            var maxReach = 0
            // [2,3,1,1,4]
            //  |
            for (i in 0 until nums.size) { // i: 0
                if (i > maxReach) {
                    break
                }
                maxReach = maxOf(maxReach, i + nums[i]) // maxReach: 2

                if (maxReach >= nums.size - 1) {
                    return true
                }
            }

            return false
        }
    }

    class RecursionWithMemo1 {
        fun canJump(nums: IntArray): Boolean {
            if (nums.size == 1) return true
            val n = nums.size - 1

            var reached = false
            // -1 = unknown, 0 = cannot reach end from here, 1 = can reach end
            val memo = IntArray(nums.size) { -1 }

            fun rec(i: Int) {
                if (reached) return

                when {
                    i >= n -> {
                        reached = true
                        return
                    }
                    memo[i] == 0 -> {
                        return
                    }

                    memo[i] == 1 -> {
                        reached = true
                        return
                    }

                    i < n -> {
                        val j = nums[i]

                        // Direct jump to or beyond the end
                        if (i + j >= n) {
                            reached = true
                            memo[i] = 1
                            return
                        }

                        // Try all possible jumps from here
                        for (k in 1..j) {
                            rec(i + k)
                            if (reached) {
                                memo[i] = 1
                                return
                            }
                        }

                        // If we tried everything and didn't reach -> dead end
                        memo[i] = 0
                    }

                    else -> {
                        return
                    }
                }
            }

            rec(0)
            return reached
        }
    }

    class RecursionWithMemo2 {
        fun canJump(nums: IntArray): Boolean {
            val n = nums.size
            // -1 = unknown, 0 = cannot reach end from here, 1 = can reach end
            val memo = IntArray(n) { -1 }

            fun rec(i: Int): Boolean {
                if (i >= n - 1) return true
                if (memo[i] != -1) return memo[i] == 1
                val maxJump = nums[i]
                for (step in 1..maxJump) {
                    if (rec(i + step)) {
                        memo[i] = 1
                        return true
                    }
                }
                memo[i] = 0
                return false
            }

            return rec(0)
        }
    }
}