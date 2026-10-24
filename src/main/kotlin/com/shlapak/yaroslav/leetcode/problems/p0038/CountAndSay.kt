package com.shlapak.yaroslav.leetcode.problems.p0038

/**
 * LeetCode 38: Count and Say.
 *
 * Generates a term of the count-and-say sequence.
 *
 * @see <a href="https://leetcode.com/problems/count-and-say/">Problem statement</a>
 */
class CountAndSay {
    fun countAndSay(n: Int): String {
        var s = StringBuilder("1")

        for (i in 2..n) {
            val tmp = StringBuilder()
            var current = s[0]
            var count = 0
            for (j in 0..s.length) {
                if ((j < s.length && s[j] == current)) {
                    count++
                    if (j + 1 < s.length && s[j + 1] != current || j + 1 == s.length) {
                        tmp.append(count)
                        tmp.append(current)
                        if (j + 1 < s.length) {
                            count = 0
                            current = s[j + 1]
                        }
                    }
                }
            }
            s = tmp
        }
        return s.toString()
    }
}
