package com.shlapak.yaroslav.leetcode.problems.p0853

/**
 * LeetCode 853: Car Fleet.
 *
 * Counts car fleets arriving at a destination.
 *
 * @see <a href="https://leetcode.com/problems/car-fleet/">Problem statement</a>
 */
class CarFleet {

    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val sortedPairs = position.mapIndexed { index, i -> i to speed[index] }.sortedByDescending { it.first }
        var fleetCount = 0
        var prevTimeToFinish = 0.0
        for (i in sortedPairs.indices) {
            val (pos, velocity) = sortedPairs[i]
            val timeToFinish = (target - pos).toDouble() / velocity
            if (timeToFinish > prevTimeToFinish) {
                fleetCount++
                prevTimeToFinish = timeToFinish
            }
        }

        return fleetCount
    }
}
