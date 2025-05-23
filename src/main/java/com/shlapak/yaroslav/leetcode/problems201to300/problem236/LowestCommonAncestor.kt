package com.shlapak.yaroslav.leetcode.problems201to300.problem236

import com.shlapak.yaroslav.leetcode.utils.TreeNode

/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class LowestCommonAncestor {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null
            || root.`val` == p?.`val`
            || root.`val` == q?.`val`
        ) {
            return root
        }

        val right = lowestCommonAncestor(root.right, p, q)
        val left = lowestCommonAncestor(root.left, p, q)
        return when {
            right != null && left != null -> {
                root
            }

            right != null -> {
                right
            }

            else -> {
                left
            }
        }
    }
}