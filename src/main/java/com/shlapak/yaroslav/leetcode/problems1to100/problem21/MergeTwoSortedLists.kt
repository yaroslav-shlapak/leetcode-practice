package com.shlapak.yaroslav.leetcode.problems1to100.problem21

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
class MergeTwoLists_TheBest {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val top = ListNode(Int.MIN_VALUE)
        var curr: ListNode? = top
        var p1 = list1
        var p2 = list2

        while (p1 != null && p2 != null) {
            if (p1.`val` > p2.`val`) {
                curr?.next = p2
                p2 = p2.next
            } else {
                curr?.next = p1
                p1 = p1.next
            }
            curr = curr?.next
        }

        curr?.next = if (p1 == null) {
            p2
        } else {
            p1
        }

        return top.next
    }
}

class MergeTwoSortedLists {
    private fun ListNode?.value(): Int = this?.`val` ?: Int.MAX_VALUE

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        // go through two linked lists and merge them taking into account the value
        var p1 = list1
        var p2 = list2
        val top: ListNode? = if (p1.value() > p2.value()) {
            val temp = p2
            p2 = p2?.next
            temp
        } else {
            val temp = p1
            p1 = p1?.next
            temp
        }
        var curr = top
        while (p1 != null || p2 != null) {
            val next = if (p1.value() > p2.value()) {
                val temp = p2
                p2 = p2?.next
                temp
            } else {
                val temp = p1
                p1 = p1?.next
                temp
            }
            curr?.next = next
            curr = curr?.next
        }
        return top
    }
}


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

