package com.shlapak.yaroslav.leetcode.problems2301to2400.problem2390

/**
 * 2390. Removing Stars From a String
 * https://leetcode.com/problems/removing-stars-from-a-string/description/
 */
class RemovingStarsFromString {
    class SimpleAndEfficient {
        fun removeStars(s: String): String {
            val res = StringBuilder()
            for (i in 0 until s.length) {
                val ch = s[i]
                if (ch == '*') {
                    res.setLength(res.length - 1)
                } else {
                    res.append(ch)
                }
            }

            return res.toString()
        }
    }

    class TwoPointers {
        fun removeStars(s: String): String {
            val res = CharArray(s.length)
            var idx = 0
            for (i in 0 until s.length) {
                val ch = s[i]
                if (ch == '*') {
                    idx--
                } else {
                    res[idx] = ch
                    idx++
                }
            }

            return String(res, 0, idx)
        }
    }

    class Stack {
        fun removeStars(s: String): String {
            val stack = ArrayDeque<Char>()
            for (i in 0 until s.length) {
                val ch = s[i]
                if (ch == '*') {
                    stack.removeLast()
                } else {
                    stack.addLast(ch)
                }
            }

            return stack.joinToString("")
        }
    }
}