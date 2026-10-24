package com.shlapak.yaroslav.leetcode.problems.p0215

import java.util.PriorityQueue

/**
 * LeetCode 215: Kth Largest Element in an Array.
 *
 * Finds the kth largest value in an array.
 *
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Problem statement</a>
 */
class KthLargestElementInArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>(k)
        for (n in nums) {
            minHeap.offer(n)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }
        return minHeap.peek()
        // nums.sort()
        // return nums[nums.size - k]
    }

    class Solution1 {
        fun findKthLargest(nums: IntArray, k: Int): Int {
            val minHeap = PriorityQueue<Int>(Comparator { a, b -> a.compareTo(b) } )

            for (n in nums) {
                minHeap.offer(n)
                if (minHeap.size > k) {
                    minHeap.poll()
                }
            }

            return minHeap.first()
        }
    }

    class Solution2 {
        fun findKthLargest(nums: IntArray, k: Int): Int {
            val minHeap = PriorityQueue<Int>(Comparator { a, b -> a.compareTo(b) } )

            for (n in nums) {
                minHeap.offer(n)
            }

            for (i in 0 until nums.size - k) {
                minHeap.poll()
            }

            return minHeap.poll()
        }
    }
}
