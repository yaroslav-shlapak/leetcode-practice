package com.shlapak.yaroslav.leetcode.problems.p2054

import java.util.PriorityQueue

/**
 * LeetCode 2054: Two Best Non-Overlapping Events.
 *
 * Finds the maximum value obtainable by attending at most two non-overlapping events.
 *
 * @see <a href="https://leetcode.com/problems/two-best-non-overlapping-events/">Problem statement</a>
 */
class TwoBestNonOverlappingEvents {
    /**
     * Processes events by start time, keeping earlier events in a min-heap by end time.
     * Before each event, removes events that ended strictly earlier and remembers their
     * highest value. The input is not modified.
     *
     * Time: O(n log n), where n is the number of events.
     * Space: O(n), including the sorted copy, heap, and sorting workspace.
     */
    class PriorityQueueSweep {
        fun maxTwoEvents(events: Array<IntArray>): Int {
            val sorted = events.sortedBy { it[0] }
            val pending = PriorityQueue<IntArray>(compareBy { it[1] })
            var bestEnded = 0
            var best = 0

            for (event in sorted) {
                while (pending.isNotEmpty() && pending.peek()[1] < event[0]) {
                    bestEnded = maxOf(bestEnded, pending.poll()[2])
                }
                best = maxOf(best, bestEnded + event[2])
                pending.add(event)
            }
            return best
        }
    }

    /**
     * Sorts events by start time and uses binary search and suffix maxima to find the best
     * compatible later event. Endpoints are inclusive. The input is not modified.
     *
     * Time: O(n log n), where n is the number of events.
     * Space: O(n), including the sorted copy, suffix maxima, and sorting workspace.
     */
    class BinarySearch {
        fun maxTwoEvents(events: Array<IntArray>): Int {
            val sorted = events.sortedBy { it[0] }
            val suffixMax = IntArray(sorted.size + 1)
            for (i in sorted.indices.reversed()) {
                suffixMax[i] = maxOf(suffixMax[i + 1], sorted[i][2])
            }

            var best = 0
            for (event in sorted) {
                var left = 0
                var right = sorted.size
                while (left < right) {
                    val mid = left + (right - left) / 2
                    if (sorted[mid][0] <= event[1]) left = mid + 1 else right = mid
                }
                best = maxOf(best, event[2] + suffixMax[left])
            }
            return best
        }
    }
}
