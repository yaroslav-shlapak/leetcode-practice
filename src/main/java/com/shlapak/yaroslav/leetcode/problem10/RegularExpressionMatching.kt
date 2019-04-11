package com.shlapak.yaroslav.leetcode.problem10

/**
 * Created on 2019/04/10.
 */
class Solution {
    fun isMatch2(s: String, p: String): Boolean {
        return s.matches(p.toRegex())
    }
    fun isMatch(s: String, p: String): Boolean {
        var result = false
        when {
            p.isEmpty() -> result = false
            s == p -> result = true
        }

        var index = 0
        var current = p.getOrLast(index)
        run loop@{

        }
        s.asSequence().forEach { char ->
            if (char == current) {

            } else {

            }
        }

        return result

    }

    private fun String.filterAndConvertToSet(): Set<Char> {
        return asSequence().filter { it != '.' && it != '*' }.toSet()
    }

    private fun String.getOrLast(index: Int): Char {
        return if (index >= length) last() else get(index)
    }
}
