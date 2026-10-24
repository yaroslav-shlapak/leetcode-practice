package com.shlapak.yaroslav.leetcode.problems.p0022

import com.shlapak.yaroslav.leetcode.problems.p0022.GenerateParenthesesLegacy.Candidate
import java.util.*

/**
 * LeetCode 22: Generate Parentheses.
 *
 * Generates all well-formed combinations of n pairs of parentheses.
 *
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Problem statement</a>
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

class GenerateParenthesesLegacy {
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
