package com.shlapak.yaroslav.leetcode.problems.p2487

import com.shlapak.yaroslav.leetcode.common.ListNode

/**
 * LeetCode 2487: Remove Nodes From Linked List.
 *
 * Removes each node with a strictly greater value somewhere to its right.
 *
 * @see <a href="https://leetcode.com/problems/remove-nodes-from-linked-list/">Problem statement</a>
 */
class RemoveNodesFromLinkedList {
    /**
     * Reverses the list, then filters and restores its order in the same pass.
     * Reuses and relinks the input nodes.
     *
     * Time: O(n). Space: O(1).
     */
    class ReverseTwoPasses {
        fun removeNodes(head: ListNode?): ListNode? {
            var current = reverse(head)
            var result: ListNode? = null
            var maximum = Int.MIN_VALUE
            while (current != null) {
                val next = current.next
                if (current.`val` >= maximum) {
                    maximum = current.`val`
                    current.next = result
                    result = current
                }
                current = next
            }
            return result
        }
    }

    /**
     * Reverses the list, links the surviving nodes, then reverses them back.
     * The last kept node holds the maximum encountered so far. Reuses and relinks input nodes.
     *
     * Time: O(n). Space: O(1).
     */
    class ReverseThreePasses {
        fun removeNodes(head: ListNode?): ListNode? {
            val newHead = reverse(head) ?: return null
            var lastKept = newHead
            var current = newHead.next
            while (current != null) {
                if (current.`val` >= lastKept.`val`) {
                    lastKept.next = current
                    lastKept = current
                }
                current = current.next
            }
            lastKept.next = null
            return reverse(newHead)
        }
    }

    /**
     * Maintains a nonincreasing stack of nodes, removing smaller nodes when a larger one arrives.
     * Reuses and relinks the input nodes; equal values remain on the stack.
     *
     * Time: O(n). Space: O(n) for the stack.
     */
    class MonotonicStack {
        fun removeNodes(head: ListNode?): ListNode? {
            val stack = ArrayDeque<ListNode>()
            var current = head
            while (current != null) {
                while (stack.isNotEmpty() && stack.last().`val` < current.`val`) {
                    stack.removeLast()
                }
                stack.addLast(current)
                current = current.next
            }
            val dummy = ListNode(0)
            var tail = dummy
            for (node in stack) {
                tail.next = node
                tail = node
            }
            tail.next = null
            return dummy.next
        }
    }

    /**
     * Repeatedly selects the first maximum of the remaining suffix and skips nodes before it.
     * Reuses and relinks input nodes. This illustrative approach can be quadratic.
     *
     * Time: O(n²). Space: O(1).
     */
    class SuffixMaximum {
        fun removeNodes(head: ListNode?): ListNode? {
            val dummy = ListNode(0)
            var tail = dummy
            var remaining = head
            while (remaining != null) {
                var maximum: ListNode = remaining
                var current = remaining.next
                while (current != null) {
                    if (current.`val` > maximum.`val`) maximum = current
                    current = current.next
                }
                tail.next = maximum
                tail = maximum
                remaining = maximum.next
            }
            tail.next = null
            return dummy.next
        }
    }

    companion object {
        private fun reverse(head: ListNode?): ListNode? {
            var current = head
            var previous: ListNode? = null
            while (current != null) {
                val next = current.next
                current.next = previous
                previous = current
                current = next
            }
            return previous
        }
    }
}
