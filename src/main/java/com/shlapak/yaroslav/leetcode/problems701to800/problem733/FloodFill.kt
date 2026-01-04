package com.shlapak.yaroslav.leetcode.problems701to800.problem733

import java.util.LinkedList

class FloodFill {

    class DfsElegant {
        class Solution {
            fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
                val start = image[sr][sc]
                if (start == color) return image
                fun dfs(r: Int, c: Int) {
                    if (r !in image.indices) return
                    if (c !in image[0].indices) return
                    if (image[r][c] != start) return

                    image[r][c] = color

                    dfs(r - 1, c)
                    dfs(r + 1, c)
                    dfs(r, c + 1)
                    dfs(r, c - 1)

                }
                dfs(sr, sc)
                return image
            }
        }
    }

    class DfsRecursive {
        fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
            val originalColor = image[sr][sc]
            if (originalColor == newColor) return image

            val directions = arrayOf(
                Pair(0, 1), // right
                Pair(1, 0), // down
                Pair(0, -1), // left
                Pair(-1, 0) // up
            )

            fun dfs(r: Int, c: Int) {
                // Change the color of the current pixel
                image[r][c] = newColor

                // Explore neighbors
                for (dir in directions) {
                    val nr = r + dir.first
                    val nc = c + dir.second

                    // Check boundaries and original color
                    if (nr in image.indices && nc in image[0].indices && image[nr][nc] == originalColor) {
                        dfs(nr, nc)
                    }
                }
            }

            dfs(sr, sc)
            return image
        }
    }

    class BfsUsingArrayDeque {
        private data class Pos(
            val r: Int,
            val c: Int
        )

        fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {

            /* Input: image =
            [
                [1,1,1],
                [1,1,0],
                [1,0,1]
                ],
                sr = 1, sc = 1, color = 2
                [2,2,2],
                [2,2,0],
                [2,0,1]
            */
            // BFS
            val n = image.size
            val m = image[0].size
            val queue = ArrayDeque<Pos>()
            val originalColor = image[sr][sc]
            queue.addLast(Pos(r = sr, c = sc))

            val dir = listOf(Pos(0, -1), Pos(0, 1), Pos(1, 0), Pos(-1, 0))

            while (queue.isNotEmpty()) {
                val levelSize = queue.size
                for (i in 0 until levelSize) {
                    val pos = queue.removeFirst()
                    image[pos.r][pos.c] = color
                    // try to add neigbourghs
                    for (d in dir) {
                        val r = pos.r + d.r
                        val c = pos.c + d.c
                        val isInBounds = r in 0..n - 1 && c in 0..m - 1
                        if (isInBounds && image[r][c] == originalColor && image[r][c] != color) {
                            queue.addLast(Pos(r, c))
                        }
                    }

                }
            }

            return image
        }
    }

    class BFSUsingLinkedList {
        fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
            val queue = LinkedList<Pair<Int, Int>>()
            val m = image.size
            val n = image[0].size
            val visited = Array(m) { IntArray(n) }

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
    }

    class BfsWithoutVisitedArray {
        fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
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

}