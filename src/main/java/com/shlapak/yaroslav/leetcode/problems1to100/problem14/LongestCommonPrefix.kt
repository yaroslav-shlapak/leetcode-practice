package com.shlapak.yaroslav.leetcode.problems1to100.problem14

import java.util.*

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
class LongestCommonPrefix4 {
    fun longestCommonPrefix(strs: Array<String>): String {
        // use the first element as trie
        // check every element for the matcing length
        // return substring of the found length
        val base = strs[0]
        if (strs.size == 1) return base
        var len = 0

        outer@ for (i in 0 until base.length) {
            for (j in 1 until strs.size) {
                val str = strs[j]
                if (str.length <= i || base[i] != str[i]) {
                    break@outer
                }
            }
            len = i + 1
        }

        return base.substring(0, len)
    }
}

class LongestCommonPrefix3 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val firstStr = strs[0]
        var end = 0

        for (i in firstStr.indices) {
            for (j in 1 until strs.size) {
                if (i >= strs[j].length || strs[j][i] != firstStr[i]) {
                    return firstStr.substring(0, end)
                }
            }
            end++
        }

        return firstStr.substring(0, end)
    }
}

class LongestCommonPrefix2 {
    fun longestCommonPrefix(strs: Array<String>): String {
        Arrays.sort(strs)
        val base = strs[0]
        var end = base.length
        for (i in 1 until strs.size) {
            var n = 0
            while (n < end && strs[i].length > n && base[n] == strs[i][n]) {
                n++
            }
            end = n
        }

        return base.substring(0, end)
    }
}

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