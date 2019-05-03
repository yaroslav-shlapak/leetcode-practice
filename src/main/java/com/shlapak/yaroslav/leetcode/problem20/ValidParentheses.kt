package com.shlapak.yaroslav.leetcode.problem20

import java.util.*

/**
 * Created on 2019/05/03.
 * https://leetcode.com/problems/valid-parentheses/
 */
class Solution {

    private val map = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
    )

    fun isValid(s: String): Boolean {
        val stack = LinkedList<Char>()
        s.asSequence().forEach {
            val last = stack.peekLast()
            if (map.get(last) == it) {
                stack.pollLast()
            } else {
                stack.add(it)
            }
        }
        println(stack)
        return stack.size == 0
    }
}