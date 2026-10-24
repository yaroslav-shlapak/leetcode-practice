package com.shlapak.yaroslav.leetcode.problems.p2037

/**
 * LeetCode 2037: Minimum Number of Moves to Seat Everyone.
 *
 * Minimizes movement when assigning students to seats.
 *
 * @see <a href="https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/">Problem statement</a>
 */
class MinimumNumberOfMovesToSeatEveryone {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort() // O(NlogN)
        var sum = 0
        for (i in seats.indices) {
            sum += Math.abs(seats[i] - students[i])
        }
        // O(N)
        return sum
    }
}
