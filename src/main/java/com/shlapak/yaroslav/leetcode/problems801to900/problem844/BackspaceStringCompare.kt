package com.shlapak.yaroslav.leetcode.problems801to900.problem844

import java.util.*

/**
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
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