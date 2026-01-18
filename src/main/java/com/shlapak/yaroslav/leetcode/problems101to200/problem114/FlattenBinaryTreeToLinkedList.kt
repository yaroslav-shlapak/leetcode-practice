package com.shlapak.yaroslav.leetcode.problems101to200.problem114

import com.shlapak.yaroslav.leetcode.utils.TreeNode

/**
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */

class FlattenBinaryTreeToLinkedList {
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

    fun Recursive2 {
        fun flatten(root: TreeNode?) {
            if (root == null) return

            flatten(root.left)
            flatten(root.right)

            val left = root.left
            val right = root.right

            root.left = null
            root.right = left

            var curr = root
            while (curr.right != null) {
                curr = curr.right!!
            }
            curr.right = right
        }
    }

    fun Iterative {
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

    fun StackBased {
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