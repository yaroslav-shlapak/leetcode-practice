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
}