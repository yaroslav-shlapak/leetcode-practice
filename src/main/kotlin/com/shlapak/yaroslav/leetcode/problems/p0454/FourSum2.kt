package com.shlapak.yaroslav.leetcode.problems.p0454

/**
 * LeetCode 454: 4Sum II.
 *
 * Counts zero-sum tuples formed by choosing one value from each of four arrays.
 *
 * @see <a href="https://leetcode.com/problems/4sum-ii/">Problem statement</a>
 */
class FourSum2 {
    class PairSumPlusHashMap {
        fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
            val map = HashMap<Int, Int>()
            for (n1 in nums1) {
                for (n2 in nums2) {
                    val key = n1 + n2
                    map[key] = map.getOrDefault(key, 0) + 1
                }
            }
            var res = 0

            for (n3 in nums3) {
                for (n4 in nums4) {
                    val key = -(n3 + n4)
                    res += map.getOrDefault(key, 0)
                }
            }

            return res
        }
    }
}
