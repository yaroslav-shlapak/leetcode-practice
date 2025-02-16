package com.shlapak.yaroslav.leetcode.problems1to100.problem23

import com.shlapak.yaroslav.leetcode.utils.ListNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created on 2019/05/09.
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
class Solution {
    fun mergeKListsNaive(lists: Array<ListNode?>): ListNode? {
        val temp = mutableListOf<Int>()
        lists.asSequence().forEach {
            var next = it
            while (next != null) {
                temp.add(next.`val`)
                next = next.next
            }
        }
        val res = ListNode(0)
        var next: ListNode? = res
        temp
                .sorted()
                .asSequence()
                .forEach { value ->
                    next?.next = ListNode(value)
                    next = next?.next
                }
        return res.next
    }

    fun mergeKListsNaive2(lists: Array<ListNode?>): ListNode? {
        val temp = ArrayList<ListNode>(lists.size)
        lists.asSequence().forEach {
            var next = it
            while (next != null) {
                temp.add(next)
                next = next.next
            }
        }
        val res = ListNode(0)
        var next: ListNode? = res
        temp.sortWith(
                Comparator { o1, o2 ->
                    when {
                        o1.`val` < o2.`val` -> -1
                        o1.`val` == o2.`val` -> 0
                        else -> 1
                    }
                }
        )
        temp
                .asSequence()
                .forEach { value ->
                    next?.next = value
                    next = next?.next
                }
        return res.next
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        val queue = PriorityQueue(
                lists.size,
                Comparator<ListNode> { o1, o2 ->
                    when {
                        o1.`val` < o2.`val` -> -1
                        o1.`val` == o2.`val` -> 0
                        else -> 1
                    }
                })

        val res = ListNode(0)
        var next: ListNode? = res

        for (node in lists)
            if (node != null)
                queue.add(node)

        while (queue.isNotEmpty()) {
            next?.next = queue.poll()
            next = next?.next

            if (next?.next != null) {
                queue.add(next.next)
            }
        }
        return res.next
    }
}