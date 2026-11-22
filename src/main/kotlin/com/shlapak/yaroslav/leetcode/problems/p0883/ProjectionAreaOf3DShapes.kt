package com.shlapak.yaroslav.leetcode.problems.p0883

/**
 * LeetCode 883: Projection Area of 3D Shapes.
 *
 * Finds the total area of the top and two side projections of stacks of cubes.
 *
 * @see <a href="https://leetcode.com/problems/projection-area-of-3d-shapes/">Problem statement</a>
 */
class ProjectionAreaOf3DShapes {
    /**
     * Counts nonempty cells for the top view and sums row and column maxima for the side views.
     * Stacks in the same row or column overlap in a side projection, so only the tallest matters.
     * For [[1, 2], [3, 4]], the three areas are 4, 2 + 4, and 3 + 4, totaling 17.
     * Assumes a square grid as specified by the problem and does not modify it.
     *
     * Time: O(n²), where n is the grid's side length.
     * Space: O(1).
     */
    class RowAndColumnMaxima {
        fun projectionArea(grid: Array<IntArray>): Int {
            val n = grid.size
            var topArea = 0
            var sideArea = 0
            var frontArea = 0

            for (i in 0 until n) {
                var tallestInRow = 0
                var tallestInColumn = 0
                for (j in 0 until n) {
                    if (grid[i][j] > 0) topArea++
                    tallestInRow = maxOf(tallestInRow, grid[i][j])
                    tallestInColumn = maxOf(tallestInColumn, grid[j][i])
                }
                sideArea += tallestInRow
                frontArea += tallestInColumn
            }
            return topArea + sideArea + frontArea
        }
    }
}
