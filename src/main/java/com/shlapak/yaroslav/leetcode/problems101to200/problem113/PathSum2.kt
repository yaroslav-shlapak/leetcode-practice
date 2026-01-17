package com.shlapak.yaroslav.leetcode.problems101to200.problem113

import com.shlapak.yaroslav.leetcode.utils.TreeNode
import java.util.LinkedList

/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 */
class PathSum2 {
    class DfsBacktracking {
        fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
            if (root == null) return emptyList()
            val res = mutableListOf<List<Int>>()

            fun dfs(node: TreeNode, path: MutableList<Int>, sum: Int) {
                path.add(node.`val`)
                val newSum = sum + node.`val`

                if (node.right == null && node.left == null) {
                    if (newSum == targetSum) {
                        res.add(path.toList())
                    }
                } else {
                    node.left?.let {
                        dfs(it, path, newSum)
                    }
                    node.right?.let {
                        dfs(it, path, newSum)
                    }
                }
                // Now, backtrack: remove the current node's value from the path
                // so that when we explore a sibling or another branch from the parent,
                // the path is in the correct state (reflecting the path up to the parent).
                path.removeAt(path.size - 1)
            }

            dfs(root, mutableListOf<Int>(), 0)

            return res
        }
    }

    class DfsBacktracking2 {
        fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
            if (root == null) return emptyList()
            val res = mutableListOf<List<Int>>()

            // sum = 0
            // node: 1
            // list: [1,2,5]
            // stack: [5,3]
            fun rec(node: TreeNode?, sum: Int, list: MutableList<Int>) {
                if (node == null) {
                    return
                }
                if (sum == targetSum && node.right == null && node.left == null) {
                    res.add(list.toList())
                    return
                }

                node.left?.let { left ->
                    list.add(left.`val`)
                    rec(left, sum + left.`val`, list)
                    list.removeLast()
                }

                node.right?.let { right ->
                    list.add(right.`val`)
                    rec(right, sum + right.`val`, list)
                    list.removeLast()
                }
            }

            rec(root, root.`val`, mutableListOf<Int>(root.`val`))
            return res

        }
    }

    class Iterative {
        fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
            if (root == null) return emptyList()

            val resultPaths = mutableListOf<List<Int>>()

            // Stack stores pairs of: (node, current sum up to and including this node)
            val stack = ArrayDeque<Pair<TreeNode, Int>>()

            // Map to store parent pointers to reconstruct paths
            // Key: child node, Value: parent node
            val parentMap = mutableMapOf<TreeNode, TreeNode?>()

            // Initial push for the root node
            stack.addLast(Pair(root, root.`val`))
            parentMap[root] = null // Root's parent is marked as null

            while (stack.isNotEmpty()) {
                val (currentNode, currentSum) = stack.removeLast()

                // Check if it's a leaf node
                if (currentNode.left == null && currentNode.right == null) {
                    if (currentSum == targetSum) {
                        // If sum matches, reconstruct the path and add to results
                        val path = reconstructPath(currentNode, parentMap)
                        resultPaths.add(path)
                    }
                } else {
                    // Process children:
                    // Push right child first so left child is processed first (LIFO behavior)
                    currentNode.right?.let { rightChild ->
                        parentMap[rightChild] = currentNode // Set parent before pushing
                        stack.addLast(Pair(rightChild, currentSum + rightChild.`val`))
                    }
                    currentNode.left?.let { leftChild ->
                        parentMap[leftChild] = currentNode // Set parent before pushing
                        stack.addLast(Pair(leftChild, currentSum + leftChild.`val`))
                    }
                }
            }
            return resultPaths
        }

        private fun reconstructPath(leafNode: TreeNode, parentMap: Map<TreeNode, TreeNode?>): List<Int> {
            val path = LinkedList<Int>() // Use LinkedList for efficient addFirst
            var currentNode: TreeNode? = leafNode
            while (currentNode != null) {
                path.addFirst(currentNode.`val`)
                currentNode = parentMap[currentNode]
            }
            return path // LinkedList is a subtype of List, so this is fine
        }
    }
}