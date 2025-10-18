package com.shlapak.yaroslav.leetcode.problems1to100.problem28

/**
 * Created on 2019/05/19.
 * https://leetcode.com/problems/implement-strstr/
 */
class Solution {
    class TwoPointersSimple {
        fun strStr(haystack: String, needle: String): Int {
            if (needle.isEmpty()) {
                return 0
            }

            for (i in 0 until haystack.length) {
                var j = i
                var k = 0
                while (j < haystack.length && k < needle.length && haystack[j] == needle[k]) {
                    j++
                    k++
                }
                if (k == needle.length) {
                    return i
                }
            }

            return -1
        }
    }

    class TwoPointers3 {
        fun strStr(haystack: String, needle: String): Int {
            for (i in 0 until haystack.length) {
                var j = i
                var k = 0
                while (j < haystack.length && k < needle.length) {
                    if (haystack[j] == needle[k]) {
                        j++
                        k++
                    } else {
                        break
                    }
                }
                if (k == needle.length) {
                    return i
                }
            }

            return -1

        }
    }

    class TwoPointers2 {
        fun strStr(haystack: String, needle: String): Int {
            val hLen = haystack.length
            val nLen = needle.length

            if (nLen == 0) return 0
            if (nLen > hLen) return -1

            var i1 = 0   // index in haystack
            var i2 = 0   // index in needle
            var result = -1

            while (i1 < hLen) {
                if (haystack[i1] == needle[i2]) {
                    if (i2 == 0) {
                        result = i1  // potential match start
                    }
                    i2++
                    if (i2 == nLen) return result  // full match
                } else {
                    if (i2 > 0) {
                        // mismatch after some matches, backtrack
                        i1 = result  // go back to one after start
                    }
                    i2 = 0
                    result = -1
                }
                i1++
            }

            return -1
        }
    }

    class TwoPointers {
        fun strStr(haystack: String, needle: String): Int {
            if (needle.isEmpty()) return 0
            var i = 0
            var j = 0
            while (i < haystack.length && j < needle.length) {
                if (haystack[i] == needle[j]) {
                    i++
                    j++
                } else {
                    i -= j - 1
                    j = 0
                }
            }
            return if (j == needle.length) i - j else -1
        }
    }

    class StrangeTwoPointers {
        fun strStr(haystack: String, needle: String): Int {
            var r = 0
            var l = 0
            var i = 0
            while (i < haystack.length) {
                r = i
                while (r < haystack.length && haystack[r] == needle[l]) {
                    if (l == needle.length - 1) {
                        return r - l
                    }
                    l++
                    r++
                }
                l = 0
                i++
            }

            return -1
        }
    }

    class IndexOf {
        fun strStr(haystack: String, needle: String): Int {
            return haystack.indexOf(needle)
        }
    }

    class GoodCheating {
        fun strStr(haystack: String, needle: String): Int {
            if (needle.isEmpty()) return 0
            val index = haystack.indexOf(needle)
            return if (index >= 0) index else -1
        }
    }

    class Good {
        fun strStr(haystack: String, needle: String): Int {
            return if (needle.isNotEmpty()) {
                var result = -1
                for (index in 0..haystack.length - needle.length) {
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
}