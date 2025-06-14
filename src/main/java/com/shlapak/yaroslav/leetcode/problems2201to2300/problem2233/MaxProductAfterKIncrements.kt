package com.shlapak.yaroslav.leetcode.problems2201to2300.problem2233

import java.util.PriorityQueue

/**
 * 2233. Maximum Product After K Increments
 * https://leetcode.com/problems/maximum-product-after-k-increments/
 */
class MaxProductAfterKIncrements {
    fun maximumProduct(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()

        for (n in nums) {
            minHeap.offer(n)
        }

        for (i in 0 until k) {
            val min = minHeap.poll()
            minHeap.offer(min + 1)
        }

        var res = 1L
        val mod = 1_000_000_007
        for (n in minHeap) {
            res = res * n
            res = res % mod
        }

        return res.toInt()
    }
}