package com.shlapak.yaroslav.leetcode.problems.p1232

/**
 * LeetCode 1232: Check If It Is a Straight Line.
 *
 * Determines whether all given points lie on one straight line in the XY plane.
 *
 * @see <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line/">Problem statement</a>
 */
class CheckIfItIsAStraightLine {
    /**
     * Compares each displacement from the first point with the direction of the first two points.
     * A zero cross product means the directions are parallel, including vertical and horizontal lines.
     * Avoids division and floating-point comparisons; uses Long arithmetic for the products.
     * Assumes at least two distinct points, as guaranteed by the problem. Does not modify the input.
     *
     * Time: O(n), where n is the number of points.
     * Space: O(1).
     */
    class CrossProduct {
        fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
            val x0 = coordinates[0][0].toLong()
            val y0 = coordinates[0][1].toLong()
            val dx = coordinates[1][0] - x0
            val dy = coordinates[1][1] - y0

            for (i in 2 until coordinates.size) {
                val x = coordinates[i][0] - x0
                val y = coordinates[i][1] - y0
                if (dx * y != dy * x) return false
            }

            return true
        }
    }
}
