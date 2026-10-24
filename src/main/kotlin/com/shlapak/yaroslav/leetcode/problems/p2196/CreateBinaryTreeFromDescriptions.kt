package com.shlapak.yaroslav.leetcode.problems.p2196

import com.shlapak.yaroslav.leetcode.common.TreeNode

/**
 * LeetCode 2196: Create Binary Tree from Descriptions.
 *
 * Builds a binary tree from parent-child descriptions.
 *
 * @see <a href="https://leetcode.com/problems/create-binary-tree-from-descriptions/">Problem statement</a>
 */
class CreateBinaryTreeFromDescriptions {
    class MapSolution {
        fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
            // descriptions[i] = [parenti, childi, isLefti]
            // to map
            val map = mutableMapOf<Int, TreeNode>()
            val nodes = mutableSetOf<Int>()
            for (d in descriptions) {
                val key = d[0]
                val node = if (map[key] != null) {
                    map[key]!!
                } else {
                    map[key] = TreeNode(key)
                    map[key]!!
                }

                val childKey = d[1]
                nodes.add(childKey)
                val childNode = if (map[childKey] != null) {
                    map[childKey]!!
                } else {
                    map[childKey] = TreeNode(childKey)
                    map[childKey]!!
                }

                if (d[2] == 1) {
                    node.left = childNode
                } else {
                    node.right = childNode
                }
            }

            for (key in map.keys) {
                if (key !in nodes) {
                    return map[key]
                }
            }

            return null
        }
    }
}
