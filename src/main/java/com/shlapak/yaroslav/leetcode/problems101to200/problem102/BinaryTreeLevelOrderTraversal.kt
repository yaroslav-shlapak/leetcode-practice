package com.shlapak.yaroslav.leetcode.problems101to200.problem102

import com.shlapak.yaroslav.leetcode.utils.TreeNode
import java.util.LinkedList

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        val res = mutableListOf<List<Int>>()

        // BFS
        // traverse tree level by level using queue
        // put non null values to list and add list to result list of lists
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val levelNodes = mutableListOf<Int>()
            for (i in 0 until levelSize) {
                val node = queue.poll()
                levelNodes.add(node.`val`)
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            res.add(levelNodes)
        }

        return res
    }
}