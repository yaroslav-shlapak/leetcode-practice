package com.shlapak.yaroslav.leetcode.problems.p0974

/**
 * LeetCode 974: Subarray Sums Divisible by K.
 *
 * Counts nonempty subarrays whose sums are divisible by k.
 *
 * @see <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">Problem statement</a>
 */
class SubarraySumsDivisibleByK {
    /**
     * Counts previous prefix sums with the same normalized remainder modulo [k].
     *
     * Each matching prefix forms a divisible subarray ending at the current index. The empty
     * prefix contributes one occurrence of remainder zero. Negative remainders are normalized
     * before indexing the frequency array. Requires a positive [k] and the problem's bounds
     * on array length and values, so the remainder arithmetic and result fit in Int.
     * The input is not modified.
     *
     * Time: O(n + k), where n is the length of [nums].
     * Space: O(k) for the remainder frequencies.
     */
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val frequencies = IntArray(k)
        frequencies[0] = 1
        var remainder = 0
        var count = 0

        for (num in nums) {
            remainder = (remainder + num) % k
            if (remainder < 0) remainder += k

            count += frequencies[remainder]
            frequencies[remainder]++
        }

        return count
    }
}
