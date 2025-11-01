package com.shlapak.yaroslav.leetcode.problems301to400.problem347

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * Given an integer array nums and an integer k,
 * return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
class TopKFrequentElements_PrioritiyQueue2 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val minHeap = PriorityQueue<Pair<Int, Int>>(
            compareBy { it.first }
        )
        val map = mutableMapOf<Int, Int>()

        for (n in nums) {
            map[n] = (map[n] ?: 0) + 1
        }

        for (entry in map) {
            val (value, count) = entry
            minHeap.offer(count to value)
        }

        for (i in k until minHeap.size) {
            minHeap.poll()
        }

        val res = IntArray(k)
        for (i in 0 until k) {
            res[i] = minHeap.poll().second
        }

        return res
    }
}

class TopKFrequentElements_BacketSort {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = mutableMapOf<Int, Int>()
        nums.forEach { freqMap[it] = (freqMap[it] ?: 0) + 1 }
        // create freq to values list
        // size + 1 no take into account nums that contains duplicates
        val freq = Array<MutableList<Int>>(nums.size + 1) { mutableListOf<Int>() }
        // populate the list
        freqMap.forEach { (value, frequency) ->
            freq[frequency].add(value)
        }
        val res = mutableListOf<Int>()
        val n = freq.size - 1
        outer@ for (i in n downTo 0) {
            for (j in freq[i]) {
                res.add(j)
                if (res.size == k) break@outer
            }
        }

        return res.toIntArray()
    }
}

class TopKFrequentElements_PriorityQueue {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums) {
            map[i] = (map[i] ?: 0) + 1
        }
        // priority queue to keep the elements in order
        val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        for ((num, freq) in map) {
            // add to queue
            queue.offer(num to freq)
            // if size is larger than needed number, remove the last one in queue
            if (queue.size > k) {
                queue.poll()
            }
        }

        val res = IntArray(k)
        // add elements from largest to smallest
        for (i in k - 1 downTo 0) {
            res[i] = queue.poll().first
        }
        return res
    }
}

class TopKFrequentElements {

    /**
     * Given an integer array nums and an integer k,
     * return the k most frequent elements.
     * You may return the answer in any order.
     *
     */
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            frequencyMap[num] = (frequencyMap[num] ?: 0).inc()
        }
        return frequencyMap
            .toList()
            .sortedByDescending { it.second }
            .take(k)
            .map { it.first }
            .toIntArray()
    }

    fun topKFrequent2(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        val freq: List<MutableList<Int>> = List(nums.size + 1) { mutableListOf<Int>() }

        nums.forEach { num ->
            frequencyMap[num] = (frequencyMap[num] ?: 0).inc()
        }

        frequencyMap.forEach { (num, count) ->
            freq[count].add(num)
        }

        val res = mutableListOf<Int>()
        for (i in freq.size - 1 downTo 0) {
            for (num in freq[i]) {
                res.add(num)
                if (res.size == k) {
                    return res.toIntArray()
                }
            }
        }

        return res.toIntArray()
    }
}

