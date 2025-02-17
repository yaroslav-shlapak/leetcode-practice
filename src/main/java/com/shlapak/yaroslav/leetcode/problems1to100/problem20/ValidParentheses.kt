package com.shlapak.yaroslav.leetcode.problems1to100.problem20

import java.util.*

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 */

class ValidParentheses {
    /**
     *  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     *  determine if the input string is valid.
     *
     *  An input string is valid if:
     *
     *  Open brackets must be closed by the same type of brackets.
     *  Open brackets must be closed in the correct order.
     *  Every close bracket has a corresponding open bracket of the same type.
     */
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val map = mapOf('(' to ')', '{' to '}', '[' to ']')
        s.forEach { c ->
            if (stack.isNotEmpty() && map[stack.peek()] == c) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
        return stack.isEmpty()
    }
}


class Solution {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            if (stack.isNotEmpty() && map[stack.peek()] == it) {
                stack.pop()
            } else {
                stack.add(it)
            }
        }
        return stack.size == 0
    }

    companion object {
        private val map = mapOf(
                '(' to ')',
                '{' to '}',
                '[' to ']'
        )
    }
}