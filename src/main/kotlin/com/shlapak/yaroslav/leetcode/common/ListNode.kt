package com.shlapak.yaroslav.leetcode.common

/**
 * Mutable singly linked-list node using LeetCode's value naming.
 *
 * @property `val` Value stored in this node.
 * @property next Next node, or null at the end of the list.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
