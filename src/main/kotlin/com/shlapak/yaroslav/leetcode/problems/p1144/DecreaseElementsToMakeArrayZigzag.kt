package com.shlapak.yaroslav.leetcode.problems.p1144

/**
 * LeetCode 1144: Decrease Elements To Make Array Zigzag.
 *
 * Finds the fewest decrements needed to make alternating elements valleys.
 *
 * @see <a href="https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/">Problem statement</a>
 */
class DecreaseElementsToMakeArrayZigzag {
    /**
     * Computes the even- and odd-valley costs in two explicit loops. Each valley is
     * lowered independently below both neighbors. The input is not modified.
     * Time: O(n). Space: O(1).
     */
    class TwoLoops {
        fun movesToMakeZigzag(nums: IntArray): Int {
            if (nums.size == 1) return 0

            var evenCount = 0
            for (i in 0 until nums.size step 2) {
                val left = if (i > 0) nums[i - 1] else Int.MAX_VALUE
                val right = if (i < nums.lastIndex) nums[i + 1] else Int.MAX_VALUE
                val smallestNeighbor = minOf(left, right)
                evenCount += maxOf(0, nums[i] - smallestNeighbor + 1)
            }

            var oddCount = 0
            for (i in 1 until nums.size step 2) {
                val left = if (i > 0) nums[i - 1] else Int.MAX_VALUE
                val right = if (i < nums.lastIndex) nums[i + 1] else Int.MAX_VALUE
                val smallestNeighbor = minOf(left, right)
                oddCount += maxOf(0, nums[i] - smallestNeighbor + 1)
            }
            return minOf(evenCount, oddCount)
        }
    }

    /**
     * Calculates the cost of each valley parity in a separate pass. Valleys do not touch,
     * so each can be lowered independently below its smallest neighbor.
     * The input is not modified. Time: O(n). Space: O(1).
     */
    class SeparatePasses {
        fun movesToMakeZigzag(nums: IntArray): Int {
            fun movesForValleys(parity: Int): Int {
                var moves = 0
                for (i in parity until nums.size step 2) {
                    var limit = Int.MAX_VALUE
                    if (i > 0) limit = minOf(limit, nums[i - 1])
                    if (i + 1 < nums.size) limit = minOf(limit, nums[i + 1])
                    if (limit != Int.MAX_VALUE) moves += maxOf(0, nums[i] - limit + 1)
                }
                return moves
            }
            return minOf(movesForValleys(0), movesForValleys(1))
        }
    }

    /**
     * Accumulates the two valley-pattern costs together in one pass, using the original
     * neighbors as limits. The input is not modified. Time: O(n). Space: O(1).
     */
    class SinglePass {
        fun movesToMakeZigzag(nums: IntArray): Int {
            var evenCount = 0
            var oddCount = 0
            for (i in nums.indices) {
                val left = if (i > 0) nums[i - 1] else Int.MAX_VALUE
                val right = if (i < nums.lastIndex) nums[i + 1] else Int.MAX_VALUE
                val smallestNeighbor = minOf(left, right)
                val moves = if (smallestNeighbor == Int.MAX_VALUE) 0
                else maxOf(0, nums[i] - smallestNeighbor + 1)
                if (i % 2 == 0) evenCount += moves else oddCount += moves
            }
            return minOf(evenCount, oddCount)
        }
    }
}
