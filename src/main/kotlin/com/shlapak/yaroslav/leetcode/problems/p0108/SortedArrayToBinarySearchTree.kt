package com.shlapak.yaroslav.leetcode.problems.p0108


import com.shlapak.yaroslav.leetcode.common.TreeNode

/**
 * LeetCode 108: Convert Sorted Array to Binary Search Tree.
 *
 * Builds a height-balanced binary search tree from a sorted array.
 *
 * @see <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Problem statement</a>
 */
class SortedArrayToBinarySearchTree {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {

        fun rec(left: Int, right: Int): TreeNode? {
            if (right < left) return null
            val mid = left + (right - left) / 2
            val curr = TreeNode(nums[mid])
            curr.left = rec(left, mid - 1)
            curr.right = rec(mid + 1, right)
            return curr
        }

        val root = rec(0, nums.lastIndex)

        return root
    }

    fun sortedArrayToBST2(nums: IntArray): TreeNode? {

        fun rec(left: Int, right: Int): TreeNode? {
            if (left > right) return null
            val mid = left + (right - left) / 2
            val cur = TreeNode(nums[mid])
            cur.left = rec(left, mid - 1)
            cur.right = rec(mid + 1, right)

            return cur
        }

        return rec(0, nums.size - 1)
    }
}
