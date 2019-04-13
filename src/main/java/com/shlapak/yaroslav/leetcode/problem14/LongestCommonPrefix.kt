package com.shlapak.yaroslav.leetcode.problem14

/**
 * Created on 2019/04/13.
 * https://leetcode.com/problems/longest-common-prefix/
 */
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        return when {
            strs.size == 1 -> {
                strs[0]
            }
            strs.isNotEmpty() -> {
                val minLenIndex = 0
                var lastIndex = 0
                outer@ for (i in 0 until strs[minLenIndex].length) {
                    inner@ for (j in 1 until strs.size) {
                        if (i < strs[j].length) {
                            if (strs[j][i] != strs[minLenIndex][i]) {
                                break@outer
                            } else if (j == strs.size - 1) {
                                lastIndex = i + 1
                            }
                        } else {
                            break@outer
                        }
                    }
                }
                strs[0].substring(0, lastIndex)
            }
            else -> {
                ""
            }
        }
    }

    private fun getMinLengthIndex(strs: Array<String>): Int {
        var minLenIndex = 0
        var min = strs[0].length
        strs.asSequence().forEachIndexed { i, s ->
            if (s.length < min) {
                minLenIndex = i
                min = s.length
            }
        }
        return minLenIndex
    }
}