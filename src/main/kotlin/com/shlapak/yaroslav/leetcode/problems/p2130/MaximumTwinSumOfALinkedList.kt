package com.shlapak.yaroslav.leetcode.problems.p2130

import com.shlapak.yaroslav.leetcode.common.ListNode

/**
 * LeetCode 2130: Maximum Twin Sum of a Linked List.
 *
 * Finds the maximum sum of mirrored node pairs in an even-length linked list.
 *
 * @see <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">Problem statement</a>
 */
class MaximumTwinSumOfALinkedList {
    /**
     * Stores node values to compare mirrored positions without modifying the list.
     */
    class ArrayValues {
        /**
         * Finds the greatest twin sum in an acyclic list of even length with positive values.
         * Returns zero for a null head.
         *
         * Time: O(n), where n is the number of nodes.
         * Space: O(n).
         */
        fun pairSum(head: ListNode?): Int {
            val values = mutableListOf<Int>()
            var current = head
            while (current != null) {
                values.add(current.`val`)
                current = current.next
            }

            var maximum = 0
            for (i in 0 until values.size / 2) {
                maximum = maxOf(maximum, values[i] + values[values.lastIndex - i])
            }
            return maximum
        }
    }
}
