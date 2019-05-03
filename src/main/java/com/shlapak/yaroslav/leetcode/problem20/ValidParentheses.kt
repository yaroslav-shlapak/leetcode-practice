package com.shlapak.yaroslav.leetcode.problem20

import java.util.*

/**
 * Created on 2019/05/03.
 * https://leetcode.com/problems/valid-parentheses/
 */
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