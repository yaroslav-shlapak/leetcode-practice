package com.shlapak.yaroslav.leetcode.problems.p0226

import com.shlapak.yaroslav.leetcode.common.TreeNode

/**
 * LeetCode 226: Invert Binary Tree.
 *
 * Swaps the left and right children throughout a binary tree.
 *
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">Problem statement</a>
 */
class InvertBinaryTreeRecursive {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return root

        val temp = root.left
        root.left = root.right
        root.right = temp
        invertTree(root.left)
        invertTree(root.right)

        return root
    }
}

class InvertBinaryTreeIterative {
    fun invertTree(root: TreeNode?): TreeNode? {
        val stack = ArrayDeque<TreeNode>()
        if (root != null) stack.addLast(root)

        while (stack.isNotEmpty()) {
            val curr = stack.removeLast()
            val temp = curr.left
            curr.left = curr.right
            curr.right = temp

            if (curr.left != null) stack.addLast(curr.left)
            if (curr.right != null) stack.addLast(curr.right)
        }

        return root
    }
}
