package com.shlapak.yaroslav.leetcode.problems.p0380



import kotlin.random.Random

/**
 * LeetCode 380: Insert Delete GetRandom O(1).
 *
 * Maintains a set with insertion, removal, and random selection.
 *
 * @see <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/">Problem statement</a>
 */
class RandomizedSet {
    class RandomizedSetOptimal2() {
        private val random: java.util.Random = java.util.Random()
        private val valueToIndex = mutableMapOf<Int, Int>()
        private val list = mutableListOf<Int>()
        fun insert(`val`: Int): Boolean {
            val index = valueToIndex[`val`]
            return if (index != null) {
                false
            } else {
                list.add(`val`)
                valueToIndex[`val`] = list.size - 1
                true
            }
        }

        fun remove(`val`: Int): Boolean {
            val index = valueToIndex[`val`]
            return if (index != null) {
                val lastVal = list[list.size - 1]
                list[index] = lastVal

                list.removeLast()
                valueToIndex[lastVal] = index
                valueToIndex.remove(`val`)

                true
            } else {
                false
            }
        }

        fun getRandom(): Int {
            return list[random.nextInt(list.size)]
        }

    }

    class RandomizedSetOptimal() {
        private val random: java.util.Random = java.util.Random()
        private val indices = mutableMapOf<Int, Int>()
        private val arr = mutableListOf<Int>()
        fun insert(`val`: Int): Boolean {
            val index = indices[`val`]
            return if (index == null) {
                arr.add(`val`)
                indices[`val`] = indices.size
                true
            } else {
                false
            }
        }

        fun remove(`val`: Int): Boolean {
            val index = indices[`val`]
            return if (index != null) {
                val candidateToRemove = arr[index]
                val last = arr.last()
                arr[index] = last
                indices[last] = index
                arr.removeLast()
                indices.remove(candidateToRemove)
                true
            } else {
                false
            }
        }

        fun getRandom(): Int {
            return arr[random.nextInt(arr.size)]
        }

    }

    class RandomizedSetBruteForce() {
        val localSet = mutableSetOf<Int>()

        fun insert(`val`: Int): Boolean {
            return localSet.add(`val`)
        }

        fun remove(`val`: Int): Boolean {
            return localSet.remove(`val`)

        }

        fun getRandom(): Int {
            val i = Random.nextInt(0, localSet.size)
            return localSet.elementAt(i)
        }

    }
}
