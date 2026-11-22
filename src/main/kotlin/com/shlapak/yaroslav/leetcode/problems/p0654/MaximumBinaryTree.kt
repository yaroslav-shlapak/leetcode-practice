package com.shlapak.yaroslav.leetcode.problems.p0654

import com.shlapak.yaroslav.leetcode.common.TreeNode

/**
 * LeetCode 654: Maximum Binary Tree.
 *
 * Builds a binary tree by using each subarray's maximum as its root.
 *
 * @see <a href="https://leetcode.com/problems/maximum-binary-tree/">Problem statement</a>
 */
class MaximumBinaryTree {
    /**
     * Keeps the tree's rightmost path on a decreasing stack. When a new node arrives,
     * the last smaller node popped becomes its left child and keeps its subtree.
     * If a larger node remains on the stack, its right child becomes the new node.
     *
     * Time: O(n), because each node is pushed and popped at most once.
     * Space: O(n) for the stack, excluding the result.
     */
    class MonotonicStack {
        /** Builds the tree from distinct values without modifying [nums]. */
        fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
            val stack = ArrayDeque<TreeNode>()
            for (value in nums) {
                val node = TreeNode(value)
                while (stack.isNotEmpty() && stack.last().`val` < value) {
                    node.left = stack.removeLast()
                }
                stack.lastOrNull()?.right = node
                stack.addLast(node)
            }
            return stack.firstOrNull()
        }
    }
}
