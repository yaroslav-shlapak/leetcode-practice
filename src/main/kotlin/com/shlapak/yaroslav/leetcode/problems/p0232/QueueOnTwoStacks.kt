package com.shlapak.yaroslav.leetcode.problems.p0232

import java.util.*

/**
 * LeetCode 232: Implement Queue Using Stacks.
 *
 * Implements queue operations using two stacks.
 *
 * @see <a href="https://leetcode.com/problems/implement-queue-using-stacks/">Problem statement</a>
 */
class QueueOnTwoStacks {
    class MyQueue() {
        private val stack = LinkedList<Int>()
        private val stackReversed = LinkedList<Int>()

        fun push(x: Int) {
            stack.addFirst(x)
        }

        fun pop(): Int {
            repopulateMaybe()
            return stackReversed.removeFirst()
        }

        fun peek(): Int {
            repopulateMaybe()
            return stackReversed.getFirst()
        }

        fun empty(): Boolean {
            return stack.isEmpty() && stackReversed.isEmpty()
        }

        private fun repopulateMaybe() {
            if (stackReversed.isEmpty()) {
                while (!stack.isEmpty()) {
                    stackReversed.addFirst(stack.removeFirst())
                }
            }
        }

    }
}
