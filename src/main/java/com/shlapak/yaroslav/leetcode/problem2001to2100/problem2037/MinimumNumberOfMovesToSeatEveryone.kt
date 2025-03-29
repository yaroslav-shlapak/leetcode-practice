package com.shlapak.yaroslav.leetcode.problem2001to2100.problem2037

/*
2037. Minimum Number of Moves to Seat Everyone
https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/
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