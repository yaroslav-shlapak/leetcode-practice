package com.shlapak.yaroslav.leetcode.problems1to100.problem28

/**
 * Created on 2019/05/19.
 * https://leetcode.com/problems/implement-strstr/
 */
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        return if (needle.isNotEmpty()) {
            var result = -1
            for (index in 0 .. haystack.length - needle.length) {
                //println("index: $index, result: $result, str: ${haystack.substring(index, index + needle.length)}")
                if (haystack.substring(index, index + needle.length) == needle) {
                    result = index
                    break
                }
            }
            result
        } else {
            0
        }
    }
}