package com.shlapak.yaroslav.leetcode.problems.p0114

import com.shlapak.yaroslav.leetcode.common.TreeNode

/**
 * LeetCode 114: Flatten Binary Tree to Linked List.
 *
 * Flattens a binary tree into a linked list in preorder.
 *
 * @see <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Problem statement</a>
 */
class FlattenBinaryTreeToLinkedList {
    class RecursiveUnderstandable {
        fun flatten(root: TreeNode?) {

            fun dfs(node: TreeNode?): TreeNode? {
                if (node == null) {
                    return null
                }

                val leftTail = dfs(node.left)
                val rightTail = dfs(node.right)

                if (node.left != null) {
                    leftTail?.right = node.right
                    node.right = node.left
                    node.left = null
                }

                return rightTail ?: leftTail ?: node

                // 1 -> 2 -> 3 -> 4
            }

            dfs(root)
        }
    }

    class Recursive {
        var prev: TreeNode? = null
        fun flatten(root: TreeNode?): Unit {
            if (root == null) return

            flatten(root.right)
            flatten(root.left)

            root.right = prev
            root.left = null
            prev = root
        }
    }

    class Recursive2 {
        fun flatten(root: TreeNode?) {
            if (root == null) return

            flatten(root.left)
            flatten(root.right)

            val left = root.left
            val right = root.right

            root.left = null
            root.right = left

            var curr: TreeNode = root
            while (curr.right != null) {
                curr = curr.right!!
            }
            curr.right = right
        }
    }

    class Iterative {
        fun flatten(root: TreeNode?): Unit {
            var curr = root

            while (curr != null) {
                if (curr.left != null) {
                    var rightmost = curr.left
                    while (rightmost?.right != null) {
                        rightmost = rightmost.right
                    }
                    rightmost?.right = curr.right
                    curr.right = curr.left
                    curr.left = null
                }
                curr = curr.right
            }
        }
    }

    class StackBased {
        fun flatten(root: TreeNode?) {
            if (root == null) return

            val stack = ArrayDeque<TreeNode>()
            stack.addLast(root)

            while (stack.isNotEmpty()) {
                val curr = stack.removeLast()

                curr.right?.let {
                    stack.addLast(it)
                }
                curr.left?.let {
                    stack.addLast(it)
                }

                if (stack.isNotEmpty()) {
                    curr.right = stack.last()
                }
                curr.left = null
            }
        }
    }
}
