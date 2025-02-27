package com.shlapak.yaroslav.leetcode.problems1to100.problem22

import com.shlapak.yaroslav.leetcode.problems1to100.problem22.Solution.Candidate
import java.util.*

/**
 * 22. Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */

class GenerateParentheses {
    private val res = mutableListOf<String>()
    private val stack = Stack<Candidate>()
    private var max: Int = 0
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
            stack.push(Candidate(str = c.str.plus(OPEN), openBrace = c.openBrace + 1, closeBrace = c.closeBrace))
        }

        if (c.closeBrace < c.openBrace) {
            stack.push(Candidate(str = c.str.plus(CLOSE), openBrace = c.openBrace, closeBrace = c.closeBrace + 1))
        }
    }

    data class Candidate(
        val str: String,
        val openBrace: Int,
        val closeBrace: Int
    )

    companion object {
        private const val OPEN = "("
        private const val CLOSE = ")"
    }
}

class GenerateParentheses2 {
    private val resultList = mutableListOf<String>()
    private var max = 0
    fun generateParenthesis(n: Int): List<String> {
        max = n
        generateParenthesis(0, 0, "")
        return resultList

    }

    private fun generateParenthesis(nOpen: Int, nClose: Int, path: String) {
        if (nOpen == nClose && nClose == max) {
            resultList.add(path)
            return
        }

        if (nOpen > nClose) {
            generateParenthesis(nOpen, nClose + 1, "$path)")
        }

        if (nOpen < max) {
            generateParenthesis(nOpen + 1, nClose, "$path(")
        }
    }
}

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