package com.shlapak.yaroslav.leetcode.problems101to200.problem150

import java.util.*

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */

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