package com.shlapak.yaroslav.leetcode.problem21

import com.shlapak.yaroslav.leetcode.utils.ListNode

/**
 * Created on 2019/05/03.
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        return when {
            l1 == null && l2 == null -> {
                null
            }
            l1 == null -> {
                l2
            }
            l2 == null -> {
                l1
            }
            else -> {
                val res = ListNode(0)
                var next1 = l1
                var next2 = l2
                var next: ListNode? = null
                while (next1 != null || next2 != null) {
                    when {
                        next1 != null && next2 != null -> {
                            if (next1.`val` > next2.`val`) {
                                if (next == null) {
                                    next = ListNode(next2.`val`)
                                    res.next = next
                                } else {
                                    next.next = ListNode(next2.`val`)
                                }
                                next2 = next2.next
                            } else {
                                if (next == null) {
                                    next = ListNode(next1.`val`)
                                    res.next = next
                                } else {
                                    next.next = ListNode(next1.`val`)
                                }
                                next1 = next1.next
                            }
                        }
                        next1 != null -> {
                            next?.next = ListNode(next1.`val`)
                            next1 = next1.next
                        }
                        next2 != null -> {
                            next?.next = ListNode(next2.`val`)
                            next2 = next2.next
                        }
                    }
                    if (next?.next != null) {
                        next = next.next
                    }
                }
                res.next
            }

        }
    }
}

