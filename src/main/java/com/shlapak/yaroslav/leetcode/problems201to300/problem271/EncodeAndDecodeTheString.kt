package com.shlapak.yaroslav.leetcode.problems201to300.problem271

/**
 * 271. Encode and Decode Strings
 * https://leetcode.com/problems/encode-and-decode-strings/
 * https://neetcode.io/problems/string-encode-and-decode?list=neetcode150
 */
class EncodeAndDecodeTheString {
    class Codec() {

        // Encodes a list of strings to a single string.
        fun encode(strs: List<String>): String {
            val sb = StringBuilder()
            for (s in strs) {
                sb.append(s.length).append('#').append(s)
            }
            return sb.toString()
        }

        // Decodes a single string to a list of strings.
        fun decode(s: String): List<String> {
            val res = mutableListOf<String>()
            var i = 0
            while (i < s.length) {
                var j = i
                while (s[j] != '#') j++
                val length = s.substring(i, j).toInt()
                i = j + 1 + length
                res.add(s.substring(j + 1, i))
            }
            return res
        }
    }
}