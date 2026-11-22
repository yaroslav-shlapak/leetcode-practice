package com.shlapak.yaroslav.leetcode.problems.p0932

/**
 * LeetCode 932: Beautiful Array.
 *
 * Builds a permutation in which the average of two entries never occurs between them.
 *
 * @see <a href="https://leetcode.com/problems/beautiful-array/description/">Problem statement</a>
 */
class BeautifulArray {
    /**
     * Expands a beautiful array into an odd block (2x - 1) followed by an even block (2x).
     * Each transformation preserves the property within its block. Endpoints in different
     * blocks have an odd sum, so their average cannot be an integer. Skipping values above n
     * preserves the order of the remaining entries.
     *
     * Time: O(n), since the array doubles at each step before the final expansion.
     * Space: O(n), including the result and the previous array.
     */
    class ParityExpansion {
        fun beautifulArray(n: Int): IntArray {
            var values = intArrayOf(1)
            while (values.size < n) {
                val expanded = IntArray(minOf(n, values.size * 2))
                var nextIndex = 0
                for (value in values) {
                    val odd = 2 * value - 1
                    if (odd <= n) expanded[nextIndex++] = odd
                }
                for (value in values) {
                    val even = 2 * value
                    if (even <= n) expanded[nextIndex++] = even
                }
                values = expanded
            }
            return values
        }
    }
}
