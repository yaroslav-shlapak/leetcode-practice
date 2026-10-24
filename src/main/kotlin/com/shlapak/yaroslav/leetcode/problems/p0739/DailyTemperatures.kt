package com.shlapak.yaroslav.leetcode.problems.p0739

import java.util.LinkedList
import java.util.Stack

/**
 * LeetCode 739: Daily Temperatures.
 *
 * Finds how many days each temperature must wait for a warmer day.
 *
 * @see <a href="https://leetcode.com/problems/daily-temperatures/">Problem statement</a>
 */
class DailyTemperatures {
    class OptimalStack {
        fun dailyTemperatures(temperatures: IntArray): IntArray {
            val len = temperatures.size
            val stack = ArrayDeque<Int>()
            val res = IntArray(len)
            // the idea is to run though the array in loop while adding the items to the stack
            // peek from stack and compare with items in another loop
            // while it's less than the next item and
            // calculate the difference between the current index and the head stack value
            // [73,74,75,71,69,72,76,73]
            // [6, 7]
            // [ 1, 1, 4, 2, 1, 1, 0, 0]
            for (i in 0 until len) {
                while (stack.isNotEmpty() && temperatures[stack.first()] < temperatures[i]) {
                    val index = stack.removeFirst()
                    res[index] = i - index
                }
                stack.addFirst(i)
            }
            return res
        }
    }

    class OptimalStack2 {
        fun dailyTemperatures(temperatures: IntArray): IntArray {
            val res = IntArray(temperatures.size)
            val stack = ArrayDeque<Int>()

            for (i in 0 until temperatures.size) {
                while (stack.isNotEmpty() && temperatures[stack.last()] < temperatures[i]) {
                    val idx = stack.removeLast()
                    res[idx] = i - idx
                }
                stack.addLast(i)
            }

            return res
        }
    }

    class StackLinkedListPair {
        fun dailyTemperatures(temperatures: IntArray): IntArray {
            val res = IntArray(temperatures.size)
            val stack = LinkedList<Pair<Int, Int>>()
            for (i in temperatures.indices) {
                res[i] = 0
                while (stack.isNotEmpty() && stack.getFirst().second < temperatures[i]) {
                    val (index, value) = stack.removeFirst()
                    res[index] = i - index
                }
                stack.addFirst(i to temperatures[i])
            }
            return res
        }
    }

    class StackPair {
        fun dailyTemperatures(temperatures: IntArray): IntArray {

            val res = IntArray(temperatures.size) { 0 }
            val stack = Stack<Pair<Int, Int>>()

            for (i in temperatures.indices) {
                while (stack.isNotEmpty() && temperatures[i] > stack.peek().first) {
                    val (_, index) = stack.pop()
                    res[index] = i - index
                }
                stack.push(temperatures[i] to i)
            }

            return res
        }
    }

    class BruteForce {
        fun dailyTemperatures(temperatures: IntArray): IntArray {
            val res = IntArray(temperatures.size)

            for (i in temperatures.indices) {
                var count = 0
                res[i] = 0
                for (j in i until temperatures.size) {
                    if (temperatures[j] > temperatures[i]) {
                        res[i] = count
                        break
                    }
                    count++
                }
            }

            return res
        }
    }

}
