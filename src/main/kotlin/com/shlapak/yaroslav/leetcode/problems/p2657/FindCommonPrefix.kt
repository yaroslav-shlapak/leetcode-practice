package com.shlapak.yaroslav.leetcode.problems.p2657

/**
 * LeetCode 2657: Find the Prefix Common Array of Two Arrays.
 *
 * Counts values common to corresponding prefixes of two permutations.
 *
 * @see <a href="https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/">Problem statement</a>
 */
class FindCommonPrefix {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        val res = IntArray(A.size)
        var count = 0
        for (i in 0 until A.size) {
            val aVal = A[i]
            val bVal = B[i]
            val countA = map.getOrDefault(aVal, 0)
            if (countA == 1) {
                count++
            } else {
                map[aVal] = 1
            }
            val countB = map.getOrDefault(bVal, 0)
            if (countB == 1) {
                count++
            } else {
                map[bVal] = 1
            }
            res[i] = count
        }
        return res
    }
}
