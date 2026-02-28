package com.shlapak.yaroslav.leetcode.problems401to500.problem452

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 */
class MinimumNumberOfArrowsToBurstBallons {
    class Optimal {
        fun findMinArrowShots(points: Array<IntArray>): Int {
            if (points.isEmpty()) return 0
            points.sortBy { it[1] }
            var count = 1
            var end = points[0][1]
            for (i in 1 until points.size) {
                if (points[i][0] > end) {
                    count++
                    end = points[i][1]
                }
            }
            return count
        }
    }

    class Optimal2 {
        fun findMinArrowShots(points: Array<IntArray>): Int {

            points.sortBy { it[1] }

            // val l = points.map { it.toList()}.toList()
            // println(l)

            var i = 0
            var arr = 0
            // [[10,16],[2,8],[1,6],[7,12]]
            // [[1,6],[2,8],[7,12],[10,16]]
            while (i < points.size) {
                var j = i + 1
                arr++
                while (j < points.size && points[i][1] >= points[j][0]) {
                    j++
                }
                i = j
            }

            return arr
        }
    }

    class MergeIntervals {
        fun findMinArrowShots(points: Array<IntArray>): Int {
            if (points.isEmpty()) return 0
            points.sortBy { it[0] }
            var count = 1
            var end = points[0][1]
            for (i in 1 until points.size) {
                if (points[i][0] > end) {
                    count++
                    end = points[i][1]
                } else {
                    end = minOf(end, points[i][1])
                }
            }
            return count
        }
    }

}