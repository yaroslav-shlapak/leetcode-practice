package com.shlapak.yaroslav.leetcode.problems701to800.problem733

import java.util.LinkedList

class FloodFill {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val queue = LinkedList<Pair<Int, Int>>()
        val m = image.size
        val n = image[0].size
        val visited = Array(m) { IntArray(n)}

        queue.offer(Pair(sr, sc))
        val colorToReplace = image[sr][sc]

        // using bfs add qualified cells to qeue and chane their color when polling from queue
        // have a separate array to track visited cells
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            for (i in 0 until levelSize) {
                val (r, c) = queue.poll()
                image[r][c] = color
                // add adjacent items to stack
                if (r - 1 >= 0 && image[r - 1][c] == colorToReplace && visited[r - 1][c] == 0) {
                    queue.add(Pair(r - 1, c))
                    visited[r - 1][c] = 1
                }
                if (c - 1 >= 0 && image[r][c - 1] == colorToReplace && visited[r][c - 1] == 0) {
                    queue.add(Pair(r, c - 1))
                    visited[r][c - 1] = 1
                }

                if (r + 1 < m && image[r + 1][c] == colorToReplace && visited[r + 1][c] == 0) {
                    queue.add(Pair(r + 1, c))
                    visited[r + 1][c] = 1
                }
                if (c + 1 < n && image[r][c + 1] == colorToReplace && visited[r][c + 1] == 0) {
                    queue.add(Pair(r, c + 1))
                    visited[r][c + 1] = 1
                }
            }
        }
        return image
    }

    fun floodFill2(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val originalColor = image[sr][sc]

        // 1. If the original color is already the new color, no need to do anything.
        if (originalColor == newColor) {
            return image
        }

        val m = image.size
        val n = image[0].size
        val queue = LinkedList<Pair<Int, Int>>()

        queue.offer(Pair(sr, sc))
        image[sr][sc] = newColor // Color the starting pixel immediately

        // Define directions for neighbors (up, down, left, right)
        val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

        while (queue.isNotEmpty()) {
            val (r, c) = queue.poll()

            for (dir in directions) {
                val nr = r + dir.first
                val nc = c + dir.second

                // Check boundaries and if the neighbor has the original color
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == originalColor) {
                    image[nr][nc] = newColor // Change color
                    queue.offer(Pair(nr, nc)) // Add to queue
                }
            }
        }
        return image
    }
}