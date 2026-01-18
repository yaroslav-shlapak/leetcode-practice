package com.shlapak.yaroslav.leetcode.problems101to200.problem113

import com.shlapak.yaroslav.leetcode.utils.TreeNode
import java.util.LinkedList

/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/
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