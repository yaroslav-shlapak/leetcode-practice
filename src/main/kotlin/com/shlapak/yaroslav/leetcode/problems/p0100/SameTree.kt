package com.shlapak.yaroslav.leetcode.problems.p0100

import com.shlapak.yaroslav.leetcode.common.TreeNode

/**
 * LeetCode 100: Same Tree.
 *
 * Determines whether two binary trees have identical structure and values.
 *
 * @see <a href="https://leetcode.com/problems/same-tree/">Problem statement</a>
 */
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p?.`val` != q?.`val`) return false
        if (p?.`val` == null) return true

        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }

    fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p?.`val` != q?.`val`) {
            return false
        }
        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}
