package com.shlapak.yaroslav.leetcode.problems801to900.problem853

/**
 * 853. Car Fleet
 *
 * https://leetcode.com/problems/car-fleet/
 *
 * There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
 *
 * You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
 *
 * A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
 *
 * A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
 *
 * If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
 *
 * Return the number of car fleets that will arrive at the destination.
 *
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