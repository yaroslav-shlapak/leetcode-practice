package com.shlapak.yaroslav.leetcode.problems.p0623

import com.shlapak.yaroslav.leetcode.common.TreeNode


import java.util.PriorityQueue
import kotlin.math.abs

/**
 * LeetCode 623: Add One Row to Tree.
 *
 * Inserts a row of nodes at a specified binary-tree depth.
 *
 * @see <a href="https://leetcode.com/problems/add-one-row-to-tree/">Problem statement</a>
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
                        cur.left?.let { queue.addLast(it) }
                        cur.right?.let { queue.addLast(it) }
                    }

                }
            }

            return root
        }
    }

}
