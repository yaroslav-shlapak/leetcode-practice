package com.shlapak.yaroslav.leetcode.problems101to200.problem165

import kotlin.time.Duration.Companion.seconds

/**
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/
 */
class CompareVersionNumbers {
    class Solution {
        fun compareVersion(v1: String, v2: String): Int {
            //v1=01.002.0.3
            // v2=01.02.04
            val arr1 = v1.split(".") // [“01”]
            val arr2 = v2.split(".") // [“01]
            val n = max(arr1.size, arr2.size) //4
            for (i in 0 until n) {
                val i1 = if (i < arr1.size) {
                    arr1[i].toInt() // 0 ->1
                } else {
                    0
                }
                val i2 = if (i < arr2.size) {
                    arr2[i].toInt() // 04->1
                } else {
                    0
                }
                when {
                    i1 < i2 -> return -1
                    i1 > i2 -> return 1
                    else -> {}
                }
            }

            return 0
        }
    }
}