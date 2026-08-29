package com.shlapak.yaroslav.leetcode.problems601to700.problem682

import java.util.ArrayDeque

/**
 * 682. Baseball Game
 * https://leetcode.com/problems/baseball-game/description/
 */
class BaseballGame {
    fun calPoints(operations: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (op in operations) {
            when {
                op == "+" -> {
                    val last = stack.removeLast()
                    val new = last + stack.last()
                    stack.add(last)
                    stack.add(new)
                }

                op == "C" -> {
                    stack.removeLast()
                }

                op == "D" -> {
                    stack.addLast(2 * stack.last())
                }

                else -> {
                    stack.addLast(op.toInt())
                }
            }
        }

        return stack.sum()
    }
}