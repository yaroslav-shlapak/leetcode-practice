package com.shlapak.yaroslav.leetcode.problems1to100.problem14

/**
 * 14. Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 */
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        return when (strs.size) {
            0 -> ""
            1 -> strs[0]
            else -> {
                findPrefix(strs)
            }
        }
    }

    private fun findPrefix(strs: Array<String>): String {
        val first = strs[0]
        var index = 0;
        if (first.isNotEmpty()) {
            outer@ for (n in first.indices) {
                val ch = first[n]
                for (i in 1 until strs.size) {
                    val str = strs[i]
                    if (n == str.length || str[n] != ch) {
                        index = n
                        break@outer
                    }
                }
                index = n + 1
            }
        }
        return first.substring(0, index)
    }
}

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