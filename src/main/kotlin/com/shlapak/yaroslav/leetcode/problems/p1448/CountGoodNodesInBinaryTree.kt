package com.shlapak.yaroslav.leetcode.problems.p1448

import java.util.Stack

/**
 * LeetCode 1448: Count Good Nodes in Binary Tree.
 *
 * Counts tree nodes whose value is at least every value on their root path.
 *
 * @see <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/">Problem statement</a>
 */
class CountGoodNodesInBinaryTree {
    class Dfs {
        fun goodNodes(root: TreeNode?): Int {
            var count = 0
            fun dfs(node: TreeNode?, max: Int) {
                if (node == null) return
                if (node.`val` >= max) count++
                val newMax = maxOf(max, node.`val`)
                node.left?.let { l ->
                    dfs(l, newMax)
                }
                node.right?.let { r ->
                    dfs(r, newMax)
                }
            }
            dfs(root, root?.`val` ?: 0)

            return count
        }
    }

    class Bfs {
        fun goodNodes(root: TreeNode?): Int {
            if (root == null) return 0

            var res = 0
            val q = ArrayDeque<Pair<TreeNode, Int>>()
            q.add(root to Int.MIN_VALUE)

            while (q.isNotEmpty()) {
                val (node, maxVal) = q.removeFirst()

                if (node.`val` >= maxVal) {
                    res++
                }

                val newMaxVal = maxOf(maxVal, node.`val`)

                node.left?.let { q.add(it to newMaxVal) }
                node.right?.let { q.add(it to newMaxVal) }
            }

            return res
        }
    }
}
