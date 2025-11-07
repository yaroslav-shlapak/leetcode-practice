package com.shlapak.yaroslav.leetcode.problems1to100.problem23

import com.shlapak.yaroslav.leetcode.utils.ListNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created on 2019/05/09.
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
class MergeKSortedLists {

    class NaiveApproach {
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.size == 0) {
                return null
            }
            if (lists.size == 1) {
                return lists[0]
            }
            var res = lists[0]
            for (i in 1 until lists.size) {
                res = mergeTwoLists(res, lists[i])
            }

            return res
        }

        fun mergeTwoLists(list1: ListNode?, list2: ListNode?) : ListNode? {
            val head = ListNode(-1)
            var p1 = list1
            var p2 = list2
            var cur: ListNode? = head

            while (p1 != null && p2 != null) {
                if (p1.`val` < p2.`val`) {
                    cur?.next = p1
                    p1 = p1.next
                } else {
                    cur?.next = p2
                    p2 = p2.next
                }

                cur = cur?.next
            }

            if (p1 == null) {
                cur?.next = p2
            } else {
                cur?.next = p1
            }

            return head.next
        }
    }
    class NonRecursiveDivideAndConquerApproach {
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isEmpty()) return null
            var interval = 1
            var totalLists = lists.size
            while (interval < totalLists) {
                for (i in 0 until totalLists - interval step interval * 2) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + interval])
                }
                interval *= 2
            }
            return lists[0]
        }

        private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            val dummyHead = ListNode(0)
            var current: ListNode? = dummyHead
            var p1 = l1
            var p2 = l2
            while (p1 != null && p2 != null) {
                if (p1.`val` < p2.`val`) {
                    current?.next = p1
                    p1 = p1.next
                } else {
                    current?.next = p2
                    p2 = p2.next
                }
                current = current?.next
            }
            current?.next = p1 ?: p2
            return dummyHead.next
        }
    }
    class DivideAndConquerApproach {
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isEmpty()) return null
            return mergeKListsHelper(lists, 0, lists.size - 1)
        }

        private fun mergeKListsHelper(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {
            if (left == right) return lists[left]
            val mid = left + (right - left) / 2
            val l1 = mergeKListsHelper(lists, left, mid)
            val l2 = mergeKListsHelper(lists, mid + 1, right)
            return mergeTwoLists(l1, l2)
        }

        private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            val dummyHead = ListNode(0)
            var current: ListNode? = dummyHead
            var p1 = l1
            var p2 = l2
            while (p1 != null && p2 != null) {
                if (p1.`val` < p2.`val`) {
                    current?.next = p1
                    p1 = p1.next
                } else {
                    current?.next = p2
                    p2 = p2.next
                }
                current = current?.next
            }
            current?.next = p1 ?: p2
            return dummyHead.next
        }
    }
    class PriorityQueueApproach {
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            val queue = PriorityQueue<ListNode>(Comparator { o1, o2 ->
                when {
                    o1.`val` < o2.`val` -> -1
                    o1.`val` == o2.`val` -> 0
                    else -> 1
                }
            })

            val dummyHead = ListNode(0)
            var current: ListNode? = dummyHead

            for (node in lists) {
                if (node != null) {
                    queue.add(node)
                }
            }

            while (queue.isNotEmpty()) {
                val node = queue.poll()
                current?.next = node
                current = current?.next
                if (node.next != null) {
                    queue.add(node.next)
                }
            }

            return dummyHead.next
        }
    }
    class RecursiveApproach {
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            if (lists.isEmpty()) return null
            return mergeKListsHelper(lists, 0, lists.size - 1)
        }

        private fun mergeKListsHelper(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {
            if (left == right) return lists[left]
            val mid = left + (right - left) / 2
            val l1 = mergeKListsHelper(lists, left, mid)
            val l2 = mergeKListsHelper(lists, mid + 1, right)
            return mergeTwoLists(l1, l2)
        }

        private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            val dummyHead = ListNode(0)
            var current: ListNode? = dummyHead
            var p1 = l1
            var p2 = l2
            while (p1 != null && p2 != null) {
                if (p1.`val` < p2.`val`) {
                    current?.next = p1
                    p1 = p1.next
                } else {
                    current?.next = p2
                    p2 = p2.next
                }
                current = current?.next
            }
            current?.next = p1 ?: p2
            return dummyHead.next
        }
    }
    class SortingApproach {
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            val merged = mutableListOf<Int>()
            for (list in lists) {
                var current = list
                while (current != null) {
                    merged.add(current.`val`)
                    current = current.next
                }
            }
            merged.sort()
            val dummyHead = ListNode(0)
            var current: ListNode? = dummyHead
            for (value in merged) {
                current?.next = ListNode(value)
                current = current?.next
            }
            return dummyHead.next
        }
    }
}

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