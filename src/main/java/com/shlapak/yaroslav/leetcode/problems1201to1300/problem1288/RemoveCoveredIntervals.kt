package com.shlapak.yaroslav.leetcode.problems1201to1300.problem1288

/**
 * 1288. Remove Covered Intervals
 * https://leetcode.com/problems/remove-covered-intervals
 */
class RemoveCoveredIntervals {
    class SortingAndPass {
        fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
            intervals.sortBy { it[0] }

            /*
            in1
            ---
              ---
             ------
            sorted in1
            ---
             ------
              ---

            in2
            ---
             -
            */

            var res = 1
            var start = intervals[0][0]
            var end = intervals[0][1]
            for ( (l, r) in intervals) {
                if (l > start && r > end) {
                    start = l
                    res++
                }
                end = maxOf(end, r)
            }
            return res
        }

    }

    class BruteForce {
        fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
            val n = intervals.size
            var res = n

            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (i != j && intervals[j][0] <= intervals[i][0] &&
                        intervals[j][1] >= intervals[i][1]) {
                        res--
                        break
                    }
                }
            }
            return res
        }
    }
}