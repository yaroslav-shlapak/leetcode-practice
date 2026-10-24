package com.shlapak.yaroslav.leetcode.common

/**
 * Mutable binary-tree node using LeetCode's value naming.
 *
 * @property `val` Value stored in this node.
 * @property left Left child, or null.
 * @property right Right child, or null.
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
