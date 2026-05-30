package com.shlapak.yaroslav.leetcode.problems601to700.problem623


import java.util.PriorityQueue
import kotlin.math.abs

/**
 * 623. Add One Row to tree
 */
class AddOneRowToTree {
    class Bfs {
        fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
            val queue = ArrayDeque<TreeNode>()
            if (root == null) return root

            queue.addLast(root)
            var levelNumber = 1

            if (depth == 1) {
                val newRoot = TreeNode(`val`)
                newRoot.left = root
                return newRoot
            }

            while (queue.isNotEmpty()) {
                val levelSize = queue.size
                levelNumber++
                for (i in 0 until levelSize) {
                    val cur = queue.removeFirst()
                    if (levelNumber == depth) {
                        val left = TreeNode(`val`)
                        left.left = cur.left
                        queue.addLast(left)
                        cur.left = left

                        val right = TreeNode(`val`)
                        right.right = cur.right
                        queue.addLast(right)
                        cur.right = right
                    } else {
                        cur.left?.let { queue.addLast(cur.left) }
                        cur.right?.let { queue.addLast(cur.right) }
                    }

                }
            }

            return root
        }
    }

}

