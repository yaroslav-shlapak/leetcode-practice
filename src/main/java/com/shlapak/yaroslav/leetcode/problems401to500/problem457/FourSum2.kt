package com.shlapak.yaroslav.leetcode.problems401to500.problem457

/**
 * 454. 4Sum II
 * https://leetcode.com/problems/4sum-ii/description/
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