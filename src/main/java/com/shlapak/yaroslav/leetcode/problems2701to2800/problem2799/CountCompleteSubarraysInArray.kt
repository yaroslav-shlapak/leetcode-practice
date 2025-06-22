package com.shlapak.yaroslav.leetcode.problems2701to2800.problem2799

class CountCompleteSubarraysInArray {
    class BruteForce {
        fun countCompleteSubarrays(nums: IntArray): Int {
            val set = nums.toSet()
            var count = 0
            for (i in nums.indices) {
                val map = mutableSetOf<Int>()
                for (j in i until nums.size) {
                    map.add(nums[j])
                    if (map.size == set.size) {
                        count++
                    }
                }
            }
            return count
        }

    }

    class BruteForce2 {
        fun countCompleteSubarrays(nums: IntArray): Int {
            val map = mutableMapOf<Int, Int>()
            for (num in nums) {
                val freq = map.getOrDefault(num, 0)
                map[num] = freq
            }

            val n = map.size
            var r = 0
            var count = 0
            for (l in nums.indices) {
                val set = mutableSetOf<Int>()
                r = l
                while (set.size < n && r < nums.size) {
                    set.add(nums[r])
                    r++
                }
                if (set.size == n) {
                    count += (nums.size - r + 1)
                }
            }
            return count
        }
    }

    class SlidingWindow {
        fun countCompleteSubarrays(nums: IntArray): Int {
            val freq = mutableMapOf<Int, Int>()
            val k = nums.toSet().size
            val n = nums.size
            var l = 0
            var count = 0
            for (r in nums.indices) {
                val keyR = nums[r]
                freq[keyR] = freq.getOrDefault(keyR, 0) + 1
                while (freq.size == k && l <= r) {
                    val key = nums[l]
                    val value = freq[key]!!
                    freq[key] = value - 1
                    if (value == 1) freq.remove(key)
                    count += n - r // we do not need to continue iteration,
                    // we know that remaining items should also be counted
                    l++
                }
            }
            return count
        }
    }

    class SlidingWindow2 {
        fun countCompleteSubarrays(nums: IntArray): Int {
            val map = mutableMapOf<Int, Int>()
            for (num in nums) {
                map[num] = 0
            }

            var l = 0
            var r = 0
            var count = 0
            var uniqueCount = 0

            while (r < nums.size) {
                if (map[nums[r]] == 0) {
                    uniqueCount++
                }
                map[nums[r]] = map[nums[r]]!! + 1

                while (uniqueCount == map.size) {
                    count += (nums.size - r)
                    map[nums[l]] = map[nums[l]]!! - 1
                    if (map[nums[l]] == 0) {
                        uniqueCount--
                    }
                    l++
                }
                r++
            }
            return count
        }
    }
}