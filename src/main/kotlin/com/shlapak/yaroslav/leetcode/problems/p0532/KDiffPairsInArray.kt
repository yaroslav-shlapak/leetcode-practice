package com.shlapak.yaroslav.leetcode.problems.p0532

import kotlin.math.max
import kotlin.math.min

/**
 * LeetCode 532: K Diff Pairs in an Array.
 *
 * Counts distinct pairs whose values differ by k.
 *
 * @see <a href="https://leetcode.com/problems/k-diff-pairs-in-an-array/">Problem statement</a>
 */
class KDiffPairsInArray {
    fun findPairs(nums: IntArray, k: Int): Int {
        // |nums[i] - nums[j]| == k
        // nums[i] - nums[j] == k -> -nums[j] = k - nums[i] -> nums[j] = -k + nums[i]
        // nums[i] - nums[j] == -k -> -nums[j] = -k - nums[i] -> nums[j] = k + nums[i]
        val map = mutableMapOf<Int, Int>()
        val unique = mutableSetOf<String>()
        var count = 0
        for (i in nums.indices) {
            count += calculateAddition(map, nums, unique, nums[i] - k, i)
            count += calculateAddition(map, nums, unique, nums[i] + k, i)
            map[nums[i]] = i
        }
        return count
    }

    private fun calculateAddition(
        map: Map<Int, Int>,
        nums: IntArray,
        unique: MutableSet<String>,
        pair: Int,
        i: Int,
    ): Int {
        val value = map[pair]
        var addition = 0
        if (value != null && value != i) {
            val first = min(nums[i], pair)
            val second = max(nums[i], pair)
            val uniquePairCandidate = "$first, $second"
            if (!unique.contains(uniquePairCandidate)) {
                addition++
            }
            unique.add(uniquePairCandidate)
        }
        return addition
    }
}
