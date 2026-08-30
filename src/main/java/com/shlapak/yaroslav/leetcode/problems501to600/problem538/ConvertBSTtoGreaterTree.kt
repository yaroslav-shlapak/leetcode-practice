package com.shlapak.yaroslav.leetcode.problems501to600.problem538

import com.shlapak.yaroslav.leetcode.utils.TreeNode

/**
 * 538. Convert BST to Greater Tree
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
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