package com.shlapak.yaroslav.leetcode.problems1to100.problem22

import java.util.*


/**
 * Created on 2019/05/09.
 * https://leetcode.com/problems/generate-parentheses/
 */
class Solution {
    private val res = mutableListOf<String>()
    private val stack = Stack<Candidate>()
    private var max = 0
    fun generateParenthesis(n: Int): List<String> {
        max = n
        stack.add(Candidate("", 0, 0))
        while (stack.isNotEmpty()) {
            backtrack(stack.pop())
        }
        return res
    }

    private fun backtrack(c: Candidate) {
        if (c.str.length == max * 2) {
            res.add(c.str)
            return
        }

        if (c.openBrace < max) {
            stack.add(Candidate("${c.str}(", c.openBrace + 1, c.closeBrace))
        }

        if (c.closeBrace < c.openBrace) {
            stack.add(Candidate("${c.str})", c.openBrace, c.closeBrace + 1))
        }
    }

    data class Candidate(
            val str: String,
            val openBrace: Int,
            val closeBrace: Int
    )
}