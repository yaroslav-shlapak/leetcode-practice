package com.shlapak.yaroslav.leetcode.problems1to100.problem57

/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/description/
 *
 * You are given an array of non-overlapping intervals `intervals`
 * where `intervals[i] = [starti, endi]` represent the start
 * and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end]
 * that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order
 * by starti and intervals still does not have any overlapping intervals
 * (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */
class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val res = mutableListOf<IntArray>()
        var i = 0
        while (i < intervals.size) {
            when {
                newInterval[0] > intervals[i][1] -> { // intervals before the newInterval
                    res.add(intervals[i])
                }
                newInterval[1] < intervals[i][0] -> { // next interval is after the newInterval
                    break
                }
                else -> { // all cases in between
                    newInterval[0] = minOf(newInterval[0], intervals[i][0])
                    newInterval[1] = maxOf(newInterval[1], intervals[i][1])
                }
            }
            i++
        }

        res.add(newInterval) // adding calculated new interval and continue iteration
        while (i < intervals.size) {
            res.add(intervals[i])
            i++
        }

        return res.toTypedArray()
    }

    private fun binarySearch(intervals: Array<IntArray>, i: Int): Int {
        var lo = 0
        var hi = intervals.size - 1
        var mid: Int = lo
        while (hi > lo) {
            mid = lo + (hi - lo) / 2
            val eqRes = intervals[mid].eq(i)
            when (eqRes) {
                0 -> return mid
                -1 -> lo = mid + 1
                1 -> hi = mid - 1
            }
            mid
        }
        return mid
    }

    private fun IntArray.eq(i: Int): Int {
        return when {
            i >= this[0] && i <= this[1] -> 0
            i < this[0] -> -1
            else -> 1
        }
    }
}

sealed class SearchResult {
    data class Inside(val index: Int) : SearchResult()
    data class Between(val start: Int, val end: Int) : SearchResult()
    data object NotFound : SearchResult()
}