package com.shlapak.yaroslav.leetcode.problems.p0875

/**
 * LeetCode 875: Koko Eating Bananas.
 *
 * Finds the minimum eating speed that finishes the bananas within a time limit.
 *
 * @see <a href="https://leetcode.com/problems/koko-eating-bananas/">Problem statement</a>
 */
class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        val max = piles.max()
        var l = 1
        var r = max
        var res = r // starting from the worst case

        while (l <= r) {
            var hours = 0
            val k = r + (r - l) / 2

            for (p in piles) {
                hours += p / k + if (p % k == 0) 0 else 1
                if (hours > h) {
                    break
                }
            }
            // if calculated hours are less or equal to h it means we could eat slower,
            // there is a better solutions
            if (hours <= h) {
                res = k // potential answer, but we need to move to the end of binary search
                r = k - 1
            } else {
                l = k + 1
            }
        }

        return res
    }
}
