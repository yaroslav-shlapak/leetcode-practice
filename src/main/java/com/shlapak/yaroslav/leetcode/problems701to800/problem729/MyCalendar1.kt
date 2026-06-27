package com.shlapak.yaroslav.leetcode.problems701to800.problem729

/**
 * 759. My Calendar I
 *
 * https://leetcode.com/problems/my-calendar-i/description/
 */
class MyCalendar1 {

    /**
     * TreeMap-based solution.
     *
     * Stores bookings as:
     * startTime -> endTime
     *
     * TreeMap keeps all start times sorted, so for a new interval we only need
     * to check two possible conflicting intervals:
     * 1. The closest booking before startTime
     * 2. The closest booking after startTime
     *
     * Time complexity:
     * - floorEntry: O(log n)
     * - ceilingEntry: O(log n)
     * - insert: O(log n)
     * - Total per book(): O(log n)
     *
     * Space complexity:
     * - O(n), where n is the number of accepted bookings
     */
    class TreeMapCalendar {

        private val bookings = java.util.TreeMap<Int, Int>()

        fun book(startTime: Int, endTime: Int): Boolean {
            val low = bookings.floorEntry(startTime)
            val up = bookings.ceilingEntry(startTime)

            // Previous booking overlaps if it ends after the new booking starts.
            if (low != null && low.value > startTime) {
                return false
            }

            // Next booking overlaps if the new booking ends after the next booking starts.
            if (up != null && endTime > up.key) {
                return false
            }

            bookings[startTime] = endTime
            return true
        }
    }

    /**
     * Sorted-list solution.
     *
     * Keeps all bookings sorted by start time.
     * For every new booking, it tries to find a valid place:
     * - before the first booking
     * - between two existing bookings
     * - after the last booking
     *
     * After adding a booking, the list is sorted again.
     *
     * Time complexity:
     * - Scanning list: O(n)
     * - Adding to list: O(1)
     * - Sorting after insert: O(n log n)
     * - Total per successful book(): O(n log n)
     * - Total per failed book(): O(n)
     *
     * Space complexity:
     * - O(n), where n is the number of accepted bookings
     */
    class BruteForce {
        private val list = mutableListOf<Pair<Int, Int>>()

        fun book(startTime: Int, endTime: Int): Boolean {
            if (list.isEmpty()) {
                addToList(startTime, endTime)
                return true
            }

            for ((i, element) in list.withIndex()) {
                val (s, e) = element

                when {
                    // New booking goes before the first booking.
                    i == 0 && endTime <= s -> {
                        addToList(startTime, endTime)
                        return true
                    }

                    // New booking goes between previous booking and current booking.
                    i > 0 &&
                            startTime >= list[i - 1].second &&
                            endTime <= s -> {
                        addToList(startTime, endTime)
                        return true
                    }

                    // New booking goes after the last booking.
                    i == list.size - 1 && e <= startTime -> {
                        addToList(startTime, endTime)
                        return true
                    }
                }
            }

            return false
        }

        private fun addToList(startTime: Int, endTime: Int) {
            list.add(startTime to endTime)
            list.sortBy { it.first }
        }
    }

    /**
     * Simple overlap-check solution.
     *
     * Does not keep bookings sorted.
     * For every new booking, checks it against every existing booking.
     *
     * Two intervals overlap if each one starts before the other one ends:
     *
     * newStart < existingEnd && existingStart < newEnd
     *
     * Time complexity:
     * - Checking all bookings: O(n)
     * - Adding booking: O(1)
     * - Total per book(): O(n)
     *
     * Space complexity:
     * - O(n), where n is the number of accepted bookings
     */
    class Simple {
        private val bookings = mutableListOf<Pair<Int, Int>>()

        fun book(startTime: Int, endTime: Int): Boolean {
            for ((start, end) in bookings) {
                val overlaps = startTime < end && start < endTime

                if (overlaps) {
                    return false
                }
            }

            bookings.add(startTime to endTime)
            return true
        }
    }
}