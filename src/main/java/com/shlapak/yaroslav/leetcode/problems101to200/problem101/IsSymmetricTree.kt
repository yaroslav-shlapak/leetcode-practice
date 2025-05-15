package com.shlapak.yaroslav.leetcode.problems101to200.problem101

import com.shlapak.yaroslav.leetcode.utils.TreeNode
import java.util.LinkedList

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 */
class IsSymmetricTree_IterativeBFS {
    fun isSymmetric(root: TreeNode?): Boolean {
        val queue = LinkedList<TreeNode?>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val levelNodes = Array<TreeNode?>(levelSize) { null }
            var areAllNodesNull = true
            for (i in 0 until levelSize) {
                val node = queue.poll()
                levelNodes[i] = node
                if (node != null) {
                    areAllNodesNull = false
                    queue.offer(node.left)
                    queue.offer(node.right)
                }
            }
            if (areAllNodesNull) return true
            var left = 0
            var right = levelNodes.size - 1
            while (right > left) {
                if (levelNodes[left]?.`val` != levelNodes[right]?.`val`) {
                    return false
                }
                left++
                right--
            }

        }
        return true
    }

    fun isSymmetric2(root: TreeNode?): Boolean {
        if (root == null) return true
        val queue = LinkedList<TreeNode?>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val list = mutableListOf<TreeNode?>()
            val levelSize = queue.size
            var allNodesInLevelAreNull = true
            for (i in 0 until levelSize) {
                val curr = queue.poll()
                list.add(curr)
                if (curr != null) {
                    queue.offer(curr.left)
                    queue.offer(curr.right)
                    allNodesInLevelAreNull = false
                }

            }
            if (allNodesInLevelAreNull) {
                break
            }
            var left = 0
            var right = list.size - 1

            while (right > left) {
                if (list[right]?.`val` != list[left]?.`val`) {
                    return false
                }
                left++
                right--
            }
        }
        return true
    }
}

class IsSymmetricTree_IterativeBFS2 {
    fun isSymmetric(root: TreeNode?): Boolean {
        // An empty tree is symmetric
        if (root == null) {
            return true
        }

        // Use a queue to manage nodes for comparison.
        // We'll add nodes in pairs that are supposed to be symmetric.
        val queue = LinkedList<TreeNode?>()

        // Add the first pair to compare: root's left child and root's right child
        queue.offer(root.left)
        queue.offer(root.right)

        while (queue.isNotEmpty()) {
            // Dequeue two nodes that should be symmetric counterparts
            val node1 = queue.poll()
            val node2 = queue.poll()

            // Case 1: Both nodes are null (e.g., empty subtrees in symmetric positions)
            // This pair is symmetric, so continue to the next pair.
            if (node1 == null && node2 == null) {
                continue
            }

            // Case 2: One node is null, but the other is not.
            // This means asymmetry.
            if (node1 == null || node2 == null) {
                return false
            }

            // Case 3: Values of the nodes are different.
            // This means asymmetry.
            if (node1.`val` != node2.`val`) {
                return false
            }

            // If values match and both nodes are non-null, enqueue their children
            // in a specific order to maintain symmetric pairing for the next level.
            // The left child of node1 should be symmetric to the right child of node2.
            queue.offer(node1.left)
            queue.offer(node2.right)

            // The right child of node1 should be symmetric to the left child of node2.
            queue.offer(node1.right)
            queue.offer(node2.left)
        }

        // If the queue is exhausted and we haven't found any asymmetry,
        // the tree is symmetric.
        return true
    }
}

class IsSymmetricTree_Recursive {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return isMirror(root.left, root.right)
    }

    private fun isMirror(node1: TreeNode?, node2: TreeNode?): Boolean {
        // If both nodes are null, they are mirrors of each other
        if (node1 == null && node2 == null) {
            return true
        }

        // If only one of the nodes is null, or their values don't match, they are not mirrors
        if (node1 == null || node2 == null || node1.`val` != node2.`val`) {
            return false
        }

        // Recursively check if:
        // 1. The left child of node1 is a mirror of the right child of node2
        // 2. The right child of node1 is a mirror of the left child of node2
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left)
    }

}