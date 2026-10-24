package com.shlapak.yaroslav.leetcode.problems.p0962

/**
 * LeetCode 962: Maximum Width Ramp.
 *
 * Finds the greatest distance between indices i < j for which nums[i] <= nums[j].
 * Returns zero when no such pair exists.
 *
 * @see <a href="https://leetcode.com/problems/maximum-width-ramp/">Problem statement</a>
 */
class MaximumWidthRamp {
    /**
     * Uses prefix minima and suffix maxima to search possible widths with two pointers.
     */
    class PrefixSuffixTwoPointers {
        /**
         * Compares the smallest value through a left index with the largest value from a right index.
         *
         * A qualifying comparison guarantees a valid pair at least that far apart, so the right
         * pointer advances to search for a wider ramp. Otherwise the left pointer advances.
         * The input is not modified. Arrays with fewer than two elements return zero.
         *
         * Time: O(n), where n is the length of [nums].
         * Space: O(n) for the two helper arrays.
         */
        fun maxWidthRamp(nums: IntArray): Int {
            val n = nums.size
            if (n < 2) return 0

            val minLeft = IntArray(n)
            val maxRight = IntArray(n)

            minLeft[0] = nums[0]
            for (i in 1 until n) {
                minLeft[i] = minOf(minLeft[i - 1], nums[i])
            }

            maxRight[n - 1] = nums[n - 1]
            for (i in n - 2 downTo 0) {
                maxRight[i] = maxOf(maxRight[i + 1], nums[i])
            }

            var l = 0
            var r = 0
            var maxWidth = 0

            while (l < n && r < n) {
                if (minLeft[l] <= maxRight[r]) {
                    maxWidth = maxOf(maxWidth, r - l)
                    r++
                } else {
                    l++
                }
            }

            return maxWidth
        }
    }

    /**
     * Keeps candidate left indices whose values are strictly decreasing.
     */
    class MonotonicStack {
        /**
         * Scans right boundaries from right to left and removes candidates once their widest
         * possible ramp has been found.
         *
         * A later left index with an equal or greater value cannot improve on an earlier candidate.
         * Each stored index is pushed and popped at most once. The input is not modified.
         * Arrays with fewer than two elements return zero.
         *
         * Time: O(n), where n is the length of [nums].
         * Space: O(n) in the worst case for the index stack.
         */
        fun maxWidthRamp(nums: IntArray): Int {
            val stack = ArrayDeque<Int>()

            // Store indices of strictly decreasing prefix minima.
            for (i in nums.indices) {
                if (stack.isEmpty() || nums[i] < nums[stack.last()]) {
                    stack.addLast(i)
                }
            }

            var maxWidth = 0

            // The first valid right boundary for each candidate gives its greatest width.
            for (r in nums.lastIndex downTo 0) {
                while (stack.isNotEmpty() && nums[stack.last()] <= nums[r]) {
                    val l = stack.removeLast()
                    maxWidth = maxOf(maxWidth, r - l)
                }
            }

            return maxWidth
        }
    }
}
