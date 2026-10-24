package com.shlapak.yaroslav.leetcode.problems.p0271

/**
 * LeetCode 271: Encode and Decode Strings.
 *
 * Encodes a list of strings and decodes it without losing string boundaries.
 *
 * @see <a href="https://leetcode.com/problems/encode-and-decode-strings/">Problem statement</a>
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
