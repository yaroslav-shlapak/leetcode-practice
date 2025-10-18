package com.shlapak.yaroslav.leetcode.problems1to100.problem56

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
class MergeIntervals {

    class SortingAndMerging {
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            if (intervals.size < 2) return intervals
            val res = mutableListOf<IntArray>()
            val sorted = intervals.sortedBy { it[0] }
            // [[1,3],[2,6],[8,10],[15,18]]
            //
            res.add(sorted[0])
            for (i in 1 until sorted.size) {
                val pair = sorted[i]
                if (pair[0] > res.last()[1]) {
                    res.add(pair)
                } else {
                    res.last()[1] = maxOf(res.last()[1], pair[1])
                }
            }

            return res.toTypedArray()
        }
    }

    class OptimalWithComments {
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            val n = intervals.size
            intervals.sortBy { it[0] } // sorting by first value to for to have overlapping intervals at the beginning
            if (n == 1) return intervals
            val res = mutableListOf<IntArray>()
            for (next in intervals) {
                // res.last()[1] is the end of the sequence
                if (res.isEmpty() || next[0] > res.last()[1]) {
                    res.add(next)
                } else {
                    // merge intervals when the next[0] is smaller than the res.last()[1], i.e. there is an overlap
                    val newEnd =
                        maxOf(next[1], res.last()[1]) // maxOf is used to for case when next is inside res.last()
                    res.last()[1] = newEnd
                }
            }
            return res.toTypedArray()
        }
    }
}