package com.shlapak.yaroslav.leetcode.problems101to200.problem151

/**
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
class ReverseWordsInString {
    class ListBasedApproach {
        fun reverseWords(str: String): String {
            val res = mutableListOf<String>()
            var buf = StringBuilder()
            for (i in 0 until str.length) {
                val ch = str[i]
                when {
                    ch == ' ' && buf.length > 0 -> {
                        res.add(buf.toString())
                        buf = StringBuilder()
                    }
                    ch != ' ' -> {
                        buf.append(ch)
                    }
                }
            }
            if (buf.length > 0) {
                res.add(buf.toString())
            }
            buf = StringBuilder()
            val rev = res.reversed()
            for (i in 0 until rev.size) {
                val s = rev[i]
                buf.append(s)
                if (i != rev.size - 1) {
                    buf.append(" ")
                }
            }

            return buf.toString()
        }
    }

    class TwoPointers {
        fun reverseWords(s: String): String {
            val sb = StringBuilder()
            var right = s.length - 1
            var left = right
            while (left >= 0) {
                while (left >= 0 && s[left] != ' ') {
                    left--
                }
                if (right < s.length - 1) {
                    sb.append(' ')
                }
                sb.append(s.substring(left + 1, right + 1))
                while (left >= 0 && s[left] == ' ') {
                    left--
                }
                right = left
            }
            return sb.toString()
        }
    }
}

