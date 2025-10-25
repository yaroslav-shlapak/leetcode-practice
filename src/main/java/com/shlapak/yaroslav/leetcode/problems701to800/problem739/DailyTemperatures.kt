package com.shlapak.yaroslav.leetcode.problems701to800.problem739

import java.util.LinkedList
import java.util.Stack

/**
 * 739. Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
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
