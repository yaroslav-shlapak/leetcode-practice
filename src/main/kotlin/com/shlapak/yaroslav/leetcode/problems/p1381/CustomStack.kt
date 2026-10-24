package com.shlapak.yaroslav.leetcode.problems.p1381

import kotlin.math.min

/**
 * LeetCode 1381: Design a Stack with Increment Operation.
 *
 * Provides a bounded stack with increments to its bottom elements.
 *
 * @see <a href="https://leetcode.com/problems/design-a-stack-with-increment-operation/">Problem statement</a>
 */
class CustomStack(maxSize: Int) { // constant time
    private val arr = IntArray(maxSize)
    private val incArr = IntArray(maxSize)
    private var nextIndex = 0

    fun push(x: Int) {
        if (nextIndex == arr.size) return

        arr[nextIndex++] = x
    }

    fun pop(): Int {
        if (nextIndex == 0) return -1

        nextIndex--
        val inc = incArr[nextIndex]

        if (nextIndex > 0) {
            incArr[nextIndex - 1] += inc
        }
        incArr[nextIndex] = 0


        return arr[nextIndex] + inc
    }

    fun increment(k: Int, `val`: Int) {
        val i = min(k, nextIndex)
        if (i == 0) return
        incArr[i - 1] += `val`
    }
}

class CustomStack2(maxSize: Int) { // O(N) for increament
    private val arr = IntArray(maxSize)
    private var nextIndex = 0

    fun push(x: Int) {
        if (nextIndex == arr.size) return

        arr[nextIndex++] = x
    }

    fun pop(): Int {
        if (nextIndex == 0) return -1
        return arr[--nextIndex]
    }

    fun increment(k: Int, `val`: Int) {
        for (i in 0 until min(k, nextIndex)) {
            arr[i] += `val`
        }
    }
}
