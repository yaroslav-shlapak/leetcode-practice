package com.shlapak.yaroslav.leetcode.problems701to800.problem729

/**
 * 759. My Calendar I
 *
 * https://leetcode.com/problems/my-calendar-i/description/
 */
class MyCalendar1 {
    class BruteForce() {
        private val list = mutableListOf<Pair<Int, Int>>()

        fun book(startTime: Int, endTime: Int): Boolean {
            if (list.isEmpty()) {
                addToList(startTime, endTime)
                return true
            }
            for (i in 0 until list.size) {
                val (s, e) = list[i]
                when {
                    i == 0 && endTime <= s -> {
                        addToList(startTime, endTime)
                        return true
                    }
                    i > 0 && startTime >= list[i - 1].second && endTime <= s -> {
                        addToList(startTime, endTime)
                        return true
                    }
                    i == list.size - 1 && e <= startTime -> {
                        addToList(startTime, endTime)
                        return true
                    }
                }
            }
            //print(list)
            return false
        }

        private fun addToList(startTime: Int, endTime: Int) {
            list.add(startTime to endTime)
            list.sortBy { it.first }
            //print(list)
        }

    }

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