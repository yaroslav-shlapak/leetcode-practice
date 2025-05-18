package com.shlapak.yaroslav.leetcode.problems101to200.problem199

import com.shlapak.yaroslav.leetcode.utils.TreeNode
import java.util.LinkedList

/*
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        val res = mutableListOf<Int>()

        // BFS
        // traverse the tree level by level and add to list only last non null node value
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            for (i in 0 until levelSize) {
                val node = queue.poll()
                if (i == levelSize - 1) {
                    res.add(node.`val`)
                }
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
        }

        return res
    }
}