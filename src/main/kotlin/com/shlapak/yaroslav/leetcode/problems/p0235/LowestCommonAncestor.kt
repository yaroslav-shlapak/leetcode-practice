package com.shlapak.yaroslav.leetcode.problems.p0235

import com.shlapak.yaroslav.leetcode.common.TreeNode

/**
 * LeetCode 235: Lowest Common Ancestor of a Binary Search Tree.
 *
 * Finds the lowest common ancestor of two nodes in a binary search tree.
 *
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Problem statement</a>
 */
class LowestCommonAncestor {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null
        val rVal = root.`val`
        val pVal = p.`val`
        val qVal = q.`val`
        return when {
            minOf(pVal, qVal) < rVal && maxOf(pVal, qVal) < rVal -> {
                lowestCommonAncestor(root.left, p, q)
            }

            minOf(pVal, qVal) > rVal && maxOf(pVal, qVal) > rVal -> {
                lowestCommonAncestor(root.right, p, q)
            }

            else -> {
                root
            }
        }
    }

    fun lowestCommonAncestorIterative(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var cur = root

        while (cur != null) {
            if (q!!.`val` > cur.`val` && p!!.`val` > cur.`val`) {
                cur = cur.right
            } else if (q!!.`val` < cur.`val` && p!!.`val` < cur.`val`) {
                cur = cur.left
            } else return cur
        }

        return null
    }
}
