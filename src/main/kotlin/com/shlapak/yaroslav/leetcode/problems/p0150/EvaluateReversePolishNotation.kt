package com.shlapak.yaroslav.leetcode.problems.p0150

import java.util.*

class EvaluateReversePolishNotation2 {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = LinkedList<Int>()
        val map = mutableMapOf<String, (Int, Int) -> Int>(
            "+" to { a, b -> a + b },
            "-" to { a, b -> a - b },
            "*" to { a, b -> a * b },
            "/" to { a, b -> a / b },
        )
        for (token in tokens) {
            val operation = map[token]
            if (operation != null) {
                val first = stack.removeFirst()
                val second = stack.removeFirst()
                val x = operation(second, first)
                stack.addFirst(x)
            } else {
                stack.addFirst(token.toInt())
            }
        }
        return stack.removeFirst()
    }
}

/**
 * LeetCode 150: Evaluate Reverse Polish Notation.
 *
 * Evaluates an expression written in reverse Polish notation.
 *
 * @see <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Problem statement</a>
 */
class EvaluateReversePolishNotation {
    private val stack: Stack<Int> = Stack()
    private val operators = mapOf<String, (Int, Int) -> Int>(
        "+" to { first, second -> first + second },
        "-" to { first, second -> first - second },
        "*" to { first, second -> first * second },
        "/" to { first, second -> first / second },
    )

    fun evalRPN(tokens: Array<String>): Int {
        for (t in tokens) {
            performOperation(t)
        }
        return stack.pop()
    }

    private fun performOperation(token: String) {
        if (operators.contains(token)) {
            val second = stack.pop()
            val first = stack.pop()
            val result = operators[token]!!(first, second)
            stack.push(result)
        } else {
            stack.push(Integer.parseInt(token))
        }
    }

}
