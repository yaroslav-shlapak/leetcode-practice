package com.shlapak.yaroslav.leetcode.problems501to600.problem560

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
class SubArraySumsEqualsK {

    class BruteForce {
        fun subarraySum(nums: IntArray, k: Int): Int {
            var res = 0
            for (i in nums.indices) {
                var sum = 0
                for (j in i until nums.size) {
                    sum += nums[j]
                    if (sum == k) {
                        res++
                    }
                }
            }
            return res
        }
    }

    class BruteForce2 {
        fun subarraySum(nums: IntArray, k: Int): Int {
            var res = 0
            val sums = IntArray(nums.size)
            sums[0] = nums[0]
            val map = mutableMapOf<Int, Int>()
            for (i in 1 until nums.size) {
                sums[i] = sums[i - 1] + nums[i]
            }

            for (i in nums.indices) {
                if (sums[i] == k) {
                    res++
                }
                for (j in i + 1 until nums.size) {
                    if (sums[j] - sums[i] == k) {
                        res++
                    }
                }
            }

            return res
        }
    }

    class PrefixSum {
        /**
         * Using a map to store the frequency of prefix sums.
         * The key is the prefix sum and the value is the count of how many times that sum has occurred.
         */
        fun subarraySum(nums: IntArray, k: Int): Int {
            var res = 0
            val map = mutableMapOf<Int, Int>()
            map[0] = 1
            var sum = 0
            for (i in nums.indices) {
                sum += nums[i]
                val diff = sum - k
                val count = map[diff]
                if (count != null) {
                    res += count
                }
                map[sum] = map.getOrDefault(sum, 0) + 1
            }
            return res
        }
    }

    class PrefixSum2 {
        fun subarraySum(nums: IntArray, k: Int): Int {
            var res = 0
            val sums = mutableMapOf<Int, Int>()
            var sum = 0
            sums[sum] = 1
            for (i in nums) {
                sum += i
                val count = sums[sum - k]
                if (count != null) {
                    res += count
                }
                val currentCount = sums[sum]
                if (currentCount != null) {
                    sums[sum] = currentCount + 1
                } else {
                    sums[sum] = 1
                }
            }

            return res
        }
    }
}