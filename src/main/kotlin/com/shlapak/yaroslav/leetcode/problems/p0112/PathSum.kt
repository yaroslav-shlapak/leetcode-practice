package com.shlapak.yaroslav.leetcode.problems.p0112

import com.shlapak.yaroslav.leetcode.common.TreeNode
import java.util.LinkedList

/**
 * LeetCode 112: Path Sum.
 *
 * Checks whether a root-to-leaf path has a target sum.
 *
 * @see <a href="https://leetcode.com/problems/path-sum/">Problem statement</a>
 */
class PathSum {
    class Dfs {
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            var found = false
            fun dfs(node: TreeNode?, sum: Int) {
                if (found || node == null) {
                    return
                }
                val newSum = sum + node.`val`

                if (newSum == targetSum && node.left == null && node.right == null) {
                    found = true
                    return
                }

                node.left?.let {
                    dfs(it, newSum)
                }
                node.right?.let {
                    dfs(it, newSum)
                }
            }

            dfs(root, 0)

            return found
        }
    }
}
