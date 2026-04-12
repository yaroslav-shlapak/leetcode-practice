package com.shlapak.yaroslav.leetcode.problems801to900.problem814
/**
 * 814. Binary Tree Pruning
 * https://leetcode.com/problems/binary-tree-pruning/
 */
class BinaryTreePruning {
    class Dfs {
        fun pruneTree(root: TreeNode?): TreeNode? {

            fun dfs(node: TreeNode?) : Boolean {
                if (node == null) {
                    return false
                }

                val hasOnesInTheLeft = dfs(node?.left)

                if (!hasOnesInTheLeft) {
                    node.left = null
                }

                val hasOnesInTheRight = dfs(node?.right)

                if (!hasOnesInTheRight) {
                    node.right = null
                }

                return node.`val` == 1 || hasOnesInTheLeft || hasOnesInTheRight
            }

            val anyOne = dfs(root)
            return if (anyOne) root else null
        }
    }

    class  Dfs2 {
        fun pruneTree(root: TreeNode?): TreeNode? {
            if (root == null) return null

            root.left = pruneTree(root.left)
            root.right = pruneTree(root.right)

            return if (root.`val` == 0 && root.left == null && root.right == null) {
                null
            } else {
                root
            }
        }
    }
}