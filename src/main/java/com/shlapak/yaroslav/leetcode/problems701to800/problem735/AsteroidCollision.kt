package com.shlapak.yaroslav.leetcode.problems701to800.problem735

import java.util.LinkedList
import kotlin.math.*

// Input: asteroids = [5,10,-5
//    |
//    [5] -> [5, 10] -> [10, -5]
//    [10,2,-5]
//     |
//     10
// Output: [5,10]
class AsteroidCollision {
    class RecursiveApproach {
        fun asteroidCollision(asteroids: IntArray): IntArray {
            val res = mutableListOf<Int>()
            fun process(index: Int) {
                if (index >= asteroids.size) return
                val ast = asteroids[index]
                if (res.isEmpty()) {
                    res.add(ast)
                    process(index + 1)
                    return
                }
                val top = res.last()
                val movingToEachOther = top > 0 && ast < 0
                when {
                    // top collides
                    movingToEachOther && abs(top) < abs(ast) -> {
                        res.removeAt(res.size - 1)
                        process(index)
                    }
                    // both top and ast collide
                    movingToEachOther && abs(top) == abs(ast) -> {
                        res.removeAt(res.size - 1)
                        process(index + 1)
                    }
                    // ast collide
                    movingToEachOther && abs(top) > abs(ast) -> {
                        process(index + 1)
                    }
                    else -> {
                        res.add(ast)
                        process(index + 1)
                    }
                }
            }
            process(0)
            return res.toIntArray()
        }
    }

    class StackApproach {
        fun asteroidCollision(asteroids: IntArray): IntArray {
            val stack = LinkedList<Int>()
            for (ast in asteroids) {
                var shouldAddToStack = true
                while (stack.isNotEmpty()) {
                    val top = stack.getFirst()
                    val movingToEachOther = top > 0 && ast < 0
                    when {
                        // top collides
                        movingToEachOther && abs(top) < abs(ast) -> {
                            stack.removeFirst()
                        }
                        // both top and ast collide
                        // both top and ast collide
                        movingToEachOther && abs(top) == abs(ast) -> {
                            stack.removeFirst()
                            shouldAddToStack = false
                            break
                        }
                        // ast collide
                        movingToEachOther && abs(top) > abs(ast) -> {
                            shouldAddToStack = false
                            break
                        }
                        else -> {
                            break
                        }
                    }
                }
                if (shouldAddToStack) {
                    stack.addFirst(ast)
                }

            }
            val res = IntArray(stack.size)

            for (i in stack.size - 1 downTo 0) {
                res[i] = stack.removeFirst()
            }

            return res
        }
    }

    class StackArrayDeque {
        fun asteroidCollision(asteroids: IntArray): IntArray {
            val stack = ArrayDeque<Int>()
            for (ast in asteroids) {
                var shouldAdd = true
                while (stack.isNotEmpty() && stack.last() > 0 && ast < 0) {
                    val top = stack.last()
                    when {
                        abs(top) < abs(ast) -> stack.removeLast()
                        abs(top) == abs(ast) -> {
                            stack.removeLast()
                            shouldAdd = false
                            break
                        }

                        abs(top) > abs(ast) -> {
                            shouldAdd = false
                            break
                        }
                    }
                }
                if (shouldAdd) {
                    stack.addLast(ast)
                }
            }
            return stack.toIntArray()
        }
    }

    class InPlaceStack {
        fun asteroidCollision(asteroids: IntArray): IntArray {
            var stackPointer = -1
            for (ast in asteroids) {
                var shouldAdd = true
                while (stackPointer >= 0 && asteroids[stackPointer] > 0 && ast < 0) {
                    val top = asteroids[stackPointer]
                    when {
                        abs(top) < abs(ast) -> stackPointer--
                        abs(top) == abs(ast) -> {
                            stackPointer--
                            shouldAdd = false
                            break
                        }

                        abs(top) > abs(ast) -> {
                            shouldAdd = false
                            break
                        }
                    }
                }
                if (shouldAdd) {
                    stackPointer++
                    asteroids[stackPointer] = ast
                }
            }
            return asteroids.sliceArray(0..stackPointer)
        }
    }
}