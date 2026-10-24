package com.shlapak.yaroslav.leetcode.problems.p1399

/**
 * LeetCode 1399: Count Largest Group.
 *
 * Counts the largest groups of integers sharing the same digit sum.
 *
 * @see <a href="https://leetcode.com/problems/count-largest-group/">Problem statement</a>
 */
class CountLargestGroup {
    fun countLargestGroup(n: Int): Int {
        val map = mutableMapOf<Int, Int>()
        var max = 0
        for (i in 1..n) {
            val key = convertToKey(i)
            val value = map.getOrDefault(key, 0)
            val newValue = value + 1
            map[key] = newValue
            max = maxOf(newValue, max)
        }
        var res = 0
        for (entry in map) {
            val (key, value) = entry
            if (value == max) {
                res++
            }
        }
        return res
    }

    private fun convertToKey(i: Int): Int {
        var res = 0
        val s = i.toString()
        for (ch in s) {
            res = res + ch.digitToInt()
        }
        return res
    }
}
