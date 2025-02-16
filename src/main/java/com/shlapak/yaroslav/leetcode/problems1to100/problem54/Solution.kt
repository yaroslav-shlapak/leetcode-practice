package com.shlapak.yaroslav.leetcode.problems1to100.problem54

/**
 * Created on 2019/11/24.
 */
class Solution {
    val set = mutableSetOf<String>()
    lateinit var input: Array<IntArray>

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return emptyList()
        }
        input = matrix
        val totalLength = matrix.size * matrix[0].size
        val res = ArrayList<Int>(totalLength)
        var i = 0
        var j = 0
        var dir: Direction = Direction.StartToEnd
        var bounds = Bounds(start = 0, end = matrix[0].size - 1, top = 0, bottom = matrix.size - 1)
        while (res.size < totalLength) {
            //println("dir: $dir, size: ${res.size}, totalLength: $totalLength, res: ${res}, i: $i, j: $j")
            when (dir) {
                is Direction.StartToEnd -> {
                    when {
                        j <= bounds.end && !visited(i, j) -> {
                            res.add(matrix[i][j])
                            set.add(toKey(i, j))
                            checkVisited(i, j)
                            if (j + 1 <= bounds.end) {
                                j++
                            }
                        }
                        else -> {
                            if (i + 1 < matrix.size) {
                                i++
                            }
                            dir = Direction.TopToBottom
                            val bottom =
                                    if (visited(bounds.bottom, j)) {
                                        bounds.bottom - 1
                                    } else {
                                        bounds.bottom
                                    }
                            bounds = bounds.copy(bottom = bottom)
                        }
                    }
                }
                is Direction.EndToStart -> {
                    when {
                        j >= bounds.start && !visited(i, j) -> {
                            res.add(matrix[i][j])
                            checkVisited(i, j)
                            set.add(toKey(i, j))
                            if (j - 1 >= bounds.start) {
                                j--
                            }
                        }
                        else -> {
                            if (i - 1 >= 0) {
                                i--
                            }
                            dir = Direction.BottomToTop

                            val top =
                                    if (visited(bounds.top, j)) {
                                        bounds.top + 1
                                    } else {
                                        bounds.top
                                    }
                            bounds = bounds.copy(top = top)
                        }
                    }
                }
                is Direction.TopToBottom -> {
                    when {
                        i <= bounds.bottom && !visited(i, j) -> {
                            res.add(matrix[i][j])
                            checkVisited(i, j)
                            set.add(toKey(i, j))
                            if (i + 1 <= bounds.bottom) {
                                i++
                            }
                        }
                        else -> {
                            if (j - 1 >= 0) {
                                j--
                            }
                            dir = Direction.EndToStart
                            val start =
                                    if (visited(i, bounds.start)) {
                                        bounds.start + 1
                                    } else {
                                        bounds.start
                                    }
                            bounds = bounds.copy(start = start)
                        }
                    }
                }
                is Direction.BottomToTop -> {
                    when {
                        i >= bounds.top && !visited(i, j) -> {
                            res.add(matrix[i][j])
                            checkVisited(i, j)
                            set.add(toKey(i, j))
                            if (i - 1 >= bounds.top) {
                                i--
                            }
                        }
                        else -> {
                            if (j + 1 < matrix[0].size) {
                                j++
                            }
                            dir = Direction.StartToEnd

                            val end =
                                    if (visited(i, bounds.end)) {
                                        bounds.end - 1
                                    } else {
                                        bounds.end
                                    }
                            bounds = bounds.copy(end = end)
                        }
                    }
                }
            }
        }
        return res
    }

    private fun checkVisited(i: Int, j: Int) {
        //input[i][j] = VISITED_INT
    }

    private fun visited(i: Int, j: Int) = set.contains(toKey(i, j))//input[i][j] == VISITED_INT

    private fun toKey(i: Int, j: Int): String {
        return "${i}x$j"
    }

    sealed class Direction {
        object StartToEnd : Direction()
        object EndToStart : Direction()
        object TopToBottom : Direction()
        object BottomToTop : Direction()
    }

    data class Bounds(
            val start: Int,
            val end: Int,
            val top: Int,
            val bottom: Int
    )

    companion object {
        const val VISITED_INT = -666
    }
}