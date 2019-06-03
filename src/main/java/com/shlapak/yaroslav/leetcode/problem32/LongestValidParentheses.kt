package com.shlapak.yaroslav.leetcode.problem32

import java.util.*

/**
 * Created on 2019/05/28.
 * https://leetcode.com/problems/longest-valid-parentheses/
 */

class Solution {

    fun longestValidParentheses(s: String): Int {
        var max = 0
        val stack = Stack<Int>()
        stack.push(-1)
        for (i in 0 until s.length) {
            if (s[i] == '(') {
                stack.push(i)
            } else {
                stack.pop()
                if (stack.empty()) {
                    stack.push(i)
                } else {
                    val first = stack.peek()
                    max = Math.max(max, i - first) // i is las index
                    println("max: $max, i: $i, stack.peek(): ${stack.peek()}")
                }
            }
            println("stack: $stack")
        }
        return max
    }
}

class SolutionFaster {
    fun longestValidParentheses(s: String): Int {
        var max = 0

        outside@ for (start in 0 until s.length) {
            inside@ for (end in s.length downTo start + 1) {
                val sub = s.substring(start, end)
                val valid = isValid(sub)
                if (valid && sub.length > max) {
                    println("valid sub: $sub")
                    max = sub.length
                    break@inside
                }
                if (max > sub.length) {
                    break@inside
                }
            }
            if (max > s.length - start) {
                break@outside
            }
        }

        return max
    }

    private fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            if (it == '(') {
                stack.push('(')
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop()
            } else {
                return false
            }
        }
        return stack.size == 0
    }
}

class SolutionSlow {
    fun longestValidParentheses(s: String): Int {
        var max = 0

        outside@ for (start in 0 until s.length) {
            inside@ for (end in s.length downTo start + 1) {
                val sub = s.substring(start, end)
                val valid = isValid(sub)
                if (valid && sub.length > max) {
                    println("valid sub: $sub")
                    max = sub.length
                    break@inside
                }
            }
            if (max > s.length - start) {
                break@outside
            }
        }

        return max
    }

    private fun isValid(s: String): Boolean {
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
                '(' to ')'
        )
    }
}