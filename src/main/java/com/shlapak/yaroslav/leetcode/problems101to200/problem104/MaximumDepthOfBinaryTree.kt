package com.shlapak.yaroslav.leetcode.problems101to200.problem104

import com.shlapak.yaroslav.leetcode.utils.TreeNode

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

class MaximumDepthOfBinaryTreeRecursive {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val left = maxDepth(root.left)
        val right = maxDepth(root.right)

        return 1 + maxOf(left, right)
    }
}

class MaximumDepthOfBinaryTreeRecursiveOptimized {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        return 1 + maxOf(
            maxDepth(root.left),
            maxDepth(root.right)
        )
    }
}

class MaximumDepthOfBinaryTreeRecursiveNaive {
    fun maxDepth(root: TreeNode?): Int {
        var res = 0

        fun rec(curr: TreeNode?, level: Int) {
            if (curr == null) return
            res = maxOf(res, level + 1)

            rec(curr.left, level + 1)
            rec(curr.right, level + 1)
        }

        rec(root, res)

        return res
    }
}

class MaximumDepthOfBinaryTreeIterative {
    fun maxDepth(root: TreeNode?): Int {
        val stack = ArrayDeque<Pair<TreeNode, Int>>()
        if (root != null) stack.addLast(root to 1)
        var res = 0
        while (stack.isNotEmpty()) {
            val (curr, level) = stack.removeLast()
            res = maxOf(res, level)
            val left = curr.left
            val right = curr.right
            if (left != null) stack.addLast(left to level + 1)
            if (right != null) stack.addLast(right to level + 1)
        }

        return res
    }
}