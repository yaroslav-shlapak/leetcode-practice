package com.shlapak.yaroslav.leetcode.problems201to300.problem215

import java.util.PriorityQueue

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
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