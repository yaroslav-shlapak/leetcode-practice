package com.shlapak.yaroslav.leetcode.problems.p1436

/**
 * LeetCode 1436: Destination City.
 *
 * Finds the city with no outgoing path.
 *
 * @see <a href="https://leetcode.com/problems/destination-city/">Problem statement</a>
 */
class DestinationCity {
    fun destCity(paths: List<List<String>>): String {
        val start = paths.map { it[0] }.toSet()

        for (path in paths) {
            if (path[1] !in start) {
                return path[1]
            }
        }
        return ""
    }
}
