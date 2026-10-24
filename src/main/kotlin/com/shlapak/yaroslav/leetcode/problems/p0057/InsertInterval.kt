package com.shlapak.yaroslav.leetcode.problems.p0057

/**
 * LeetCode 57: Insert Interval.
 *
 * Inserts an interval into a sorted, nonoverlapping interval list.
 *
 * @see <a href="https://leetcode.com/problems/insert-interval/">Problem statement</a>
 */
class InsertInterval {
    class BruteForce {
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            var i = 0
            val res = mutableListOf<IntArray>()
            // add all intervals before the new interval
            while (i < intervals.size && newInterval[0] > intervals[i][1]) {
                res.add(intervals[i])
                i++
            }
            // calculated the boundaries of insertion
            while (i < intervals.size && newInterval[1] >= intervals[i][0]) {
                newInterval[0] = minOf(newInterval[0], intervals[i][0])
                newInterval[1] = maxOf(newInterval[1], intervals[i][1])
                i++
            }
            res.add(newInterval)
            // add remaining intervals
            while (i < intervals.size) {
                res.add(intervals[i])
                i++
            }

            return res.toTypedArray()
        }
    }

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
