package com.shlapak.yaroslav.leetcode.problem23

import com.shlapak.yaroslav.leetcode.utils.ListNode

/**
 * Created on 2019/05/09.
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
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
}