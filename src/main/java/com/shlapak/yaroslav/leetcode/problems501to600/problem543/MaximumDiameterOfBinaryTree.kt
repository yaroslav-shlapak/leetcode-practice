package com.shlapak.yaroslav.leetcode.problems501to600.problem543

import com.shlapak.yaroslav.leetcode.utils.TreeNode

typealias Diameter = Int
typealias Height = Int

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */

class MaximumDiameterOfBinaryTreeIterative {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0
        val stack = ArrayDeque<TreeNode>()
        stack.add(root)
        val map = HashMap<TreeNode?, Pair<Diameter, Height>>()

        map[null] = (0 to 0)
        while (stack.isNotEmpty()) {
            val curr = stack.last()

            when {
                curr.left != null && !map.contains(curr.left) -> {
                    stack.addLast(curr.left!!)
                }

                curr.right != null && !map.contains(curr.right) -> {
                    stack.addLast(curr.right!!)
                }

                else -> {
                    stack.removeLast()
                    val (leftDiameter, leftHeight) = map[curr.left] ?: (0 to 0)
                    val (rightDiameter, rightHeight) = map[curr.right] ?: (0 to 0)
                    val maxHeight = maxOf(leftHeight, rightHeight) + 1
                    val maxDiameter = maxOf(leftHeight + rightHeight, maxOf(leftDiameter, rightDiameter))

                    map[curr] = (maxDiameter to maxHeight)
                }
            }
        }

        return map[root]?.first ?: 0
    }

}

class MaximumDiameterOfBinaryTreeRecursive {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var res = 0

        fun dfs(curr: TreeNode?): Int {
            if (curr == null) return 0

            val left = dfs(curr.left)
            val right = dfs(curr.right)

            res = maxOf(res, left + right)
            return 1 + maxOf(left, right)
        }

        dfs(root)
        return res
    }
}

class MaximumDiameterOfBinaryTree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var res = 0

        fun dfs(curr: TreeNode?): Height {
            if (curr == null) return 0

            val left = dfs(curr.left)
            val right = dfs(curr.right)

            res = maxOf(res, left + right)
            return 1 + maxOf(left, right)
        }

        dfs(root)
        return res
    }
}