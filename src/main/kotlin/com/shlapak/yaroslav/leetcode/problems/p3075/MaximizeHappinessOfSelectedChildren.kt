package com.shlapak.yaroslav.leetcode.problems.p3075



/**
 * LeetCode 3075: Maximize Happiness of Selected Children.
 *
 * Maximizes the happiness obtained by selecting k children.
 *
 * @see <a href="https://leetcode.com/problems/maximize-happiness-of-selected-children/">Problem statement</a>
 */
class MaximizeHappinessOfSelectedChildren {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        // [5,5,1,2,4]
        happiness.sort()
        //[1,1,1,2,2,2,2,2]
        //         |
        // k = 4
        var n = 0
        var sum = 0L // 0
        for (i in happiness.size - 1 downTo (happiness.size - k)) {
            happiness[i] = (happiness[i] - n).coerceAtLeast(0) // 0
            if (happiness[i] <= 0) {
                break
            }
            sum += happiness[i] // 3
            n++ // 2
        }

        //[1,2,2,4,5]

        return sum

    }
}
