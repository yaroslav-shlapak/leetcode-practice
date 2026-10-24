package com.shlapak.yaroslav.leetcode.problems.p0155

import java.util.*

/**
 * LeetCode 155: Min Stack.
 *
 * Provides stack operations and retrieval of the current minimum.
 *
 * @see <a href="https://leetcode.com/problems/min-stack/">Problem statement</a>
 */
class MinStack() {
    private val stack: Stack<Int> = Stack()
    private val minStack: Stack<Int> = Stack()

    fun push(`val`: Int) {
        val input = `val`
        stack.push(input)
        val minVal = if (minStack.isNotEmpty()) minOf(input, minStack.peek()) else input
        minStack.push(minVal)
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            stack.pop()
        }
        if (minStack.isNotEmpty()) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}


class MinStack2() {
    private var head: Node? = null

    fun push(`val`: Int) {
        val min = head?.min
        val prev = head
        val newMin = if (min != null && min < `val`) {
            min
        } else {
            `val`
        }
        head = Node(
            prev = prev,
            value = `val`,
            min = newMin,
        )
    }

    fun pop() {
        head = head!!.prev
    }

    fun top(): Int {
        return head!!.value
    }

    fun getMin(): Int {
        return head!!.min
    }

    data class Node(
        val prev: Node?,
        val value: Int,
        val min: Int,
    )

}
