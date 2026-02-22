package com.shlapak.yaroslav.leetcode.problems3201to3300.problem1436

/**
 * 1436. Destination City
 * https://leetcode.com/problems/destination-city/description/
 */

class Solution {
    fun destCity(paths: List<List<String>>): String {
        val start = paths.map { it[0] }.toSet()

        for (path in paths) {
            if (path[1] !in start) {
                return path[1]
            }
        }
        return ""
    }
}