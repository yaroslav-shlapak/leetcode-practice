package com.shlapak.yaroslav.leetcode.problems.p0844

import java.util.*

/**
 * LeetCode 844: Backspace String Compare.
 *
 * Compares strings after interpreting backspace characters.
 *
 * @see <a href="https://leetcode.com/problems/backspace-string-compare/">Problem statement</a>
 */
class BackspaceStringCompare {
    fun backspaceCompare(s: String, t: String): Boolean {
        return processBackspaces(s) == processBackspaces(t)
    }

    private fun processBackspaces(str: String): LinkedList<Char> {
        val stack = LinkedList<Char>()
        for (ch in str) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.removeFirst()
                }
            } else {
                stack.addFirst(ch)
            }
        }
        return stack
    }
}
