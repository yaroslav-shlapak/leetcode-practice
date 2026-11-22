package com.shlapak.yaroslav.leetcode.problems.p3039

/**
 * LeetCode 3039: Apply Operations to Make String Empty.
 *
 * Returns the string immediately before repeatedly removing each distinct character empties it.
 *
 * @see <a href="https://leetcode.com/problems/apply-operations-to-make-string-empty/">Problem statement</a>
 */
class ApplyOperationsToMakeStringEmpty {
    /**
     * Counts each letter and orders the most frequent letters by their last occurrence.
     * Each operation removes one occurrence of each remaining letter, so these are the
     * characters that survive until the last operation. Assumes lowercase English letters.
     *
     * Time: O(n), where n is the string length; sorting at most 26 letters is constant.
     * Space: O(1), including the result and intermediate collections, which contain at most 26 letters.
     */
    class FrequencyAndLastIndex {
        data class ChStats(val count: Int, val lastIndex: Int)

        fun lastNonEmptyString(s: String): String {
            val map = arrayOfNulls<ChStats>(26)
            var maxCount = 0
            for (i in 0 until s.length) {
                val ch = s[i]
                val prev = map[ch - 'a']
                val newStats = ChStats(
                    count = (prev?.count ?: 0) + 1,
                    lastIndex = i,
                )
                map[ch - 'a'] = newStats
                maxCount = maxOf(maxCount, newStats.count)
            }
            return map.mapIndexedNotNull { index, stats ->
                if (stats != null && stats.count == maxCount) {
                    ('a' + index) to stats.lastIndex
                } else {
                    null
                }
            }
                .sortedBy { it.second }
                .joinToString("") { it.first.toString() }
        }
    }
}
