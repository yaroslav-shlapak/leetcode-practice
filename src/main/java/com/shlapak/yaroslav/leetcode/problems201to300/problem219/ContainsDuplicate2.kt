package com.shlapak.yaroslav.leetcode.problems201to300.problem219

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
class ContainsDuplicate2 {
    class Solution3 {
        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            if (k <= 0) {
                return false
            }
            val map = mutableMapOf<Int, Int>()
            for (i in 0 until nums.size) {
                if (map.contains(nums[i]) && map[nums[i]]!! >= i - k) {
                    return true
                }
                map[nums[i]] = i
            }
            return false
        }
    }

    class Solution2 {
        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            if (k <= 0) {
                return false
            }
            val set = mutableSetOf<Int>()
            for (i in 0 until nums.size) {
                if (set.contains(nums[i])) {
                    return true
                }
                if (i >= k) {
                    set.remove(nums[i - k])
                }
                set.add(nums[i])
            }
            return false
        }
    }

    class Solution1 {
        fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
            val map = mutableMapOf<Int, Int>() // {1:3,2:1,3:2,4:4}
            for (i in 0 until nums.size) { // i:5
                val n = nums[i]
                val idx = map[n]
                if (idx != null) {
                    if (i - idx <= k) { // 5 - 3 = 2 == k -> return true
                        return true
                    }
                }
                if (map.size > k) {
                    map.remove(nums[i - k])
                }
                map[n] = i
            }
            return false
        }
    }
}