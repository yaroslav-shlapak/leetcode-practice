package com.shlapak.yaroslav.leetcode.problems.p0523

/**
 * LeetCode 523: Continuous Subarray Sum.
 *
 * Checks whether a subarray of length at least two has a sum divisible by k.
 *
 * @see <a href="https://leetcode.com/problems/continuous-subarray-sum/">Problem statement</a>
 */
class ContinuousSubarraySum {
    /**
     * Stores the earliest index for each prefix-sum remainder modulo [k].
     *
     * Equal remainders delimit a subarray whose sum is divisible by [k]. Keeping the earliest
     * index maximizes its length; index -1 represents the empty prefix. Requires nonnegative
     * values in [nums] and a positive [k]. The input is not modified.
     *
     * Time: O(n) expected, where n is the length of [nums].
     * Space: O(min(n, k)) for the remainder map.
     */
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val earliestIndex = hashMapOf(0 to -1)
        var remainder = 0

        for (i in nums.indices) {
            remainder = ((remainder.toLong() + nums[i]) % k).toInt()
            val previousIndex = earliestIndex[remainder]
            if (previousIndex == null) {
                earliestIndex[remainder] = i
            } else if (i - previousIndex >= 2) {
                return true
            }
        }

        return false
    }
}

// TODO review
