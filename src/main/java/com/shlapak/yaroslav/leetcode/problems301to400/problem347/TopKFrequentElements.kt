package com.shlapak.yaroslav.leetcode.problems301to400.problem347

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

