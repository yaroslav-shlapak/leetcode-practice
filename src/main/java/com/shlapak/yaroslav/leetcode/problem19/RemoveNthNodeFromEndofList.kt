package com.shlapak.yaroslav.leetcode.problem19

/**
 * Created on 2019/04/25.
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        return if (head == null) {
            null
        } else {
            val res = if (n == 0) {
                val next = head.next
                if (next != null) {
                    next
                } else {
                    null
                }
            } else {
                head
            }

            var next = res?.next
            var count = 2
            while (next != null) {
                if (count != n) {
                    next = next.next
                } else {
                    println(next.next?.`val`)
                    next.next = next.next?.next
                }
                count++
            }

            res
        }
    }

    fun ListNode?.copy(): ListNode? {
        return if (this == null) {
            null
        } else {
            val res = ListNode(this.`val`)
            val next = this.next
            res.next = this.next
            res
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}