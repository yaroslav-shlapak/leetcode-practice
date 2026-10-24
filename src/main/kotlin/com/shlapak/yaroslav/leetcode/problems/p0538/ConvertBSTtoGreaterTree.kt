package com.shlapak.yaroslav.leetcode.problems.p0538

import com.shlapak.yaroslav.leetcode.common.TreeNode

/**
 * LeetCode 538: Convert BST to Greater Tree.
 *
 * Replaces binary-search-tree values with sums of greater or equal values.
 *
 * @see <a href="https://leetcode.com/problems/convert-bst-to-greater-tree/">Problem statement</a>
 */
class ConvertBSTtoGreaterTree {
    class Dfs {
        fun convertBST(root: TreeNode?): TreeNode? {
            var sum = 0

            fun dfs(node: TreeNode?) {
                if (node == null) {
                    return
                }
                dfs(node.right)
                node.`val` += sum
                sum = node.`val`
                dfs(node.left)
            }

            dfs(root)
            return root
        }
    }
}
