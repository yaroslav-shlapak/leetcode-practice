package com.shlapak.yaroslav.leetcode.problems.p2606

/**
 * LeetCode 2606: Find the Substring with Maximum Cost.
 *
 * Finds the greatest substring cost under custom character values.
 *
 * @see <a href="https://leetcode.com/problems/find-the-substring-with-maximum-cost/">Problem statement</a>
 */
class FindSubstringWithMaxCost {
    fun maximumCostSubstring(s: String, chars: String, vals: IntArray): Int {
        var maxSum = 0
        var sum = 0
        val charToValue = IntArray(26)
        for (i in 0 until charToValue.size) {
            charToValue[i] = i + 1
        }
        for (i in 0 until chars.length) {
            charToValue[chars[i] - 'a'] = vals[i]
        }
        // charToValue = [1, 2, 3, -1000, 5, …]

        for (i in 0 until s.length) {
            val cand = sum + charToValue[s[i] - 'a'] // 2

            sum = maxOf(cand, 0) // 2
            maxSum = maxOf(sum, maxSum) // 2
        }

        return maxSum
    }
}
