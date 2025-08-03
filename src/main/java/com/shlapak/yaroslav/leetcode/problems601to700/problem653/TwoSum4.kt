package com.shlapak.yaroslav.leetcode.problems601to700.problem653

import com.shlapak.yaroslav.leetcode.utils.TreeNode

/**
 * 653. Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
class TwoSum4 {

    class MySolution {
        fun findTarget(root: TreeNode?, k: Int): Boolean {
            val diff = mutableMapOf<Int, Int>()
            val set = mutableSetOf<Int>()
            fun dfs(node: TreeNode?) {
                if (node == null) return
                val dif = k - node.`val`
                diff[dif] = node.`val`
                set.add(node.`val`)
                dfs(node.left)
                dfs(node.right)
            }
            dfs(root)

            for (e in set) {
                if (diff[e] != null && diff[e] != e) {
                    return true
                }
            }
            return false
        }
    }

    class Optimized {
        fun findTarget(root: TreeNode?, k: Int): Boolean {
            val set = mutableSetOf<Int>()
            return findTargetHelper(root, k, set)
        }

        private fun findTargetHelper(node: TreeNode?, target: Int, set: MutableSet<Int>): Boolean {
            if (node == null) return false
            if (set.contains(target - node.`val`)) return true
            set.add(node.`val`)
            return findTargetHelper(node.left, target, set) || findTargetHelper(node.right, target, set)
        }
    }

    class BruteForce {
        fun findTarget(root: TreeNode?, k: Int): Boolean {
            val list = mutableListOf<Int>()
            inOrderTraversal(root, list)
            return twoSum(list, k)
        }

        private fun inOrderTraversal(node: TreeNode?, list: MutableList<Int>) {
            if (node == null) return
            inOrderTraversal(node.left, list)
            list.add(node.`val`)
            inOrderTraversal(node.right, list)
        }

        private fun twoSum(list: List<Int>, target: Int): Boolean {
            val set = mutableSetOf<Int>()
            for (num in list) {
                if (set.contains(target - num)) {
                    return true
                }
                set.add(num)
            }
            return false
        }
    }
}