package com.shlapak.yaroslav.leetcode.problems.p0105

import com.shlapak.yaroslav.leetcode.common.TreeNode

/**
 * LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal.
 *
 * Reconstructs a binary tree from its preorder and inorder traversals.
 *
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Problem statement</a>
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * Finds each root in preorder and splits its half-open inorder range at the root's index.
     * The left subtree's size determines where the right subtree starts in preorder.
     * The traversals describe the same tree with distinct values, and both arrays are preserved.
     *
     * Time: O(n) for n nodes.
     * Space: O(n) for the index map and O(h) call stack space for tree height h,
     * excluding the returned tree.
     */
    class DivideAndConquer {
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            val inorderIndex = HashMap<Int, Int>()
            for (index in inorder.indices) {
                inorderIndex[inorder[index]] = index
            }

            fun build(preStart: Int, inStart: Int, inEnd: Int): TreeNode? {
                if (inStart == inEnd) return null

                val value = preorder[preStart]
                val split = inorderIndex.getValue(value)
                val leftSize = split - inStart

                val node = TreeNode(value)
                node.left = build(preStart + 1, inStart, split)
                node.right = build(preStart + 1 + leftSize, split + 1, inEnd)
                return node
            }

            return build(0, 0, inorder.size)
        }
    }

    /**
     * Creates nodes in preorder and keeps ancestors on a stack until their values are visited
     * in inorder. The traversals describe the same tree and contain distinct values.
     * Both input arrays are preserved.
     *
     * Time: O(n) for n nodes.
     * Space: O(h) auxiliary space for tree height h, excluding the returned tree.
     */
    class IterativeStack {
        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            if (preorder.isEmpty()) return null

            val root = TreeNode(preorder[0])
            val pending = ArrayDeque<TreeNode>()
            pending.addLast(root)
            var inorderIndex = 0

            for (preorderIndex in 1 until preorder.size) {
                val node = TreeNode(preorder[preorderIndex])
                var parent = pending.last()
                if (parent.`val` != inorder[inorderIndex]) {
                    parent.left = node
                } else {
                    // Inorder visits an ancestor once its left subtree is complete.
                    // The next preorder node starts the last visited ancestor's right subtree.
                    do {
                        parent = pending.removeLast()
                        inorderIndex++
                    } while (pending.lastOrNull()?.`val` == inorder[inorderIndex])
                    parent.right = node
                }
                pending.addLast(node)
            }

            return root
        }
    }
}
