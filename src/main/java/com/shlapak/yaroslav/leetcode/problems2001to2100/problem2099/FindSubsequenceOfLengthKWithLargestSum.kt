package com.shlapak.yaroslav.leetcode.problems2001to2100.problem2099

import java.util.PriorityQueue

/**
 * 2099. Find Subsequence of Length K With the Largest Sum
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 */
class FindSubsequenceOfLengthKWithLargestSum {

    class PriorityQueue {
        fun maxSubsequence(nums: IntArray, k: Int): IntArray {
            val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

            for (i in nums.indices) {
                minHeap.offer(nums[i] to i)
            }

            for (i in 0 until k) {
                minHeap.poll()
            }

            return minHeap.toList().sortedBy { it.second }.map { it.first }.toIntArray()
        }
    }

    fun maxSubsequence_sorting(nums: IntArray, k: Int): IntArray {
        val list = nums.sorted()
        val arr = IntArray(k)
        var j = 0
        for (i in nums.size - k until nums.size) {
            arr[j] = list[i]
            j++
        }
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until arr.size) {
            val value = map.getOrPut(arr[i]) { 0 }
            map[arr[i]] = value + 1
        }
        val res = IntArray(k)
        j = 0
        for (i in 0 until nums.size) {
            val value = map[nums[i]]
            if (value != null && value > 0) {
                res[j] = nums[i]
                map[nums[i]] = value - 1
                j++
            }
        }

        return res
    }

    fun maxSubsequence_priorityQueue(nums: IntArray, k: Int): IntArray {
        val minQueue = PriorityQueue<Int>() { o1, o2 -> o2.compareTo(o1) }

        for (num in nums) {
            minQueue.offer(num)
        }

        val map = mutableMapOf<Int, Int>()
        for (i in 0 until k) {
            val key = minQueue.poll()
            val value = map.getOrPut(key) { 0 }
            map[key] = value + 1
        }

        val res = IntArray(k)
        var i = 0
        for (num in nums) {
            val value = map[num]
            if (value != null && value > 0) {
                res[i] = num
                map[num] = value - 1
                i++
            }
        }

        return res
    }

}