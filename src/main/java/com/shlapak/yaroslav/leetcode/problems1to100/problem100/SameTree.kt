package com.shlapak.yaroslav.leetcode.problems1to100.problem100

import com.shlapak.yaroslav.leetcode.utils.TreeNode

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
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