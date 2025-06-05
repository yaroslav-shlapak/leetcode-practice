package com.shlapak.yaroslav.leetcode.problems1to100.problem20

import java.util.*

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 */

class Solution2 {
    fun isValid(s: String): Boolean {
        val map = mapOf('(' to ')', '{' to '}', '[' to ']')
        val stack = ArrayDeque<Char>()
        // add to stack only opening brace
        // if brace is closing peek top of the stack and get its value from map
        // compare the value with the current char
        // if equal pop and continue
        // if not equal return false
        // return true if stack is empty

        for (c in s) {
            if (stack.isNotEmpty() && map[stack.last()] == c) {
                stack.removeLast()
            } else {
                stack.addLast(c)
            }
        }

        return stack.isEmpty()
    }
}

class ValidParentheses {
    fun isValid2(s: String): Boolean {
        val stack = LinkedList<Char>()
        val map = mapOf('(' to ')', '[' to ']', '{' to '}')
        for (ch in s) {
            if (!stack.isEmpty() && map[stack.peekFirst()] == ch) {
                stack.removeFirst()
            } else {
                stack.addFirst(ch)
            }
        }
        return stack.isEmpty()
    }
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