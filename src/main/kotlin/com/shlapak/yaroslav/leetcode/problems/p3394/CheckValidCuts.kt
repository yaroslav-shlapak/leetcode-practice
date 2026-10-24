package com.shlapak.yaroslav.leetcode.problems.p3394

/**
 * LeetCode 3394: Check if Grid can be Cut into Sections.
 *
 * Determines whether two parallel cuts can divide the grid into three sections,
 * each containing at least one whole rectangle.
 *
 * @see <a href="https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/">Problem statement</a>
 */
class CheckValidCuts {
    /**
     * Projects rectangles onto separate interval lists without modifying the input.
     */
    class Intervals {
        /**
         * Sorts separate projections of [rectangles] onto each axis and counts disjoint groups.
         *
         * Touching intervals belong to separate groups because a cut may follow rectangle edges.
         * The input array and its coordinate arrays are not modified.
         *
         * Time: O(m log m), where m is the number of rectangles.
         * Space: O(m) for the projections and sorting workspace.
         *
         * @param n Grid side length; only relative interval positions affect the result.
         */
        fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
            if (rectangles.size < 3) return false

            data class Interval(val start: Int, val end: Int)

            // Project all rectangles onto the Y axis.
            val intervalsY = mutableListOf<Interval>()
            for (i in rectangles.indices) {
                intervalsY.add(Interval(rectangles[i][1], rectangles[i][3]))
            }
            intervalsY.sortBy { it.start }

            // Project all rectangles onto the X axis.
            val intervalsX = mutableListOf<Interval>()
            for (i in rectangles.indices) {
                intervalsX.add(Interval(rectangles[i][0], rectangles[i][2]))
            }
            intervalsX.sortBy { it.start }

            for (intervals in listOf(intervalsY, intervalsX)) {
                var groups = 1
                var maxEnd = intervals[0].end

                for (i in 1 until intervals.size) {
                    val interval = intervals[i]
                    if (interval.start >= maxEnd) {
                        groups++
                        if (groups >= 3) return true
                    }
                    maxEnd = maxOf(maxEnd, interval.end)
                }
            }

            return false
        }
    }

    /**
     * Variant of [Intervals] that sorts the input array directly.
     */
    class InPlace {
        /**
         * Sorts [rectangles] by each axis and checks for three disjoint projection groups.
         *
         * Touching intervals may be separated by a cut. Modifies the input array's order,
         * but does not modify the coordinate arrays. Stops after the first successful axis.
         *
         * Time: O(m log m), where m is the number of rectangles.
         * Space: O(m) worst-case sorting workspace; no projection lists are allocated.
         *
         * @param n Grid side length; only relative interval positions affect the result.
         */
        fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
            if (rectangles.size < 3) return false

            fun hasThreeGroups(startIndex: Int, endIndex: Int): Boolean {
                // Sorts the original array, so the input order is modified.
                rectangles.sortWith(compareBy { it[startIndex] })

                var groups = 1
                var maxEnd = rectangles[0][endIndex]

                for (i in 1 until rectangles.size) {
                    val start = rectangles[i][startIndex]
                    val end = rectangles[i][endIndex]

                    if (start >= maxEnd) {
                        groups++
                        if (groups >= 3) return true
                    }
                    maxEnd = maxOf(maxEnd, end)
                }

                return false
            }

            return hasThreeGroups(0, 2) || hasThreeGroups(1, 3)
        }
    }
}
