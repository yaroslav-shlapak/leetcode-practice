package com.shlapak.yaroslav.leetcode.problems101to200.problem155

import java.util.*

/**
 *
 * 155. Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
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

/**
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */