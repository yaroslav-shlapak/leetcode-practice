package com.shlapak.yaroslav.leetcode.problems301to400.problem392

class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) return false
        var i = 0
        var j = 0
        while (i < s.length && j < t.length) {
            if (s.length - i > t.length - j) break
            if (s[i] == t[j]) {
                i++
                j++
            } else {
                j++
            }
        }
        return i == s.length
    }

}