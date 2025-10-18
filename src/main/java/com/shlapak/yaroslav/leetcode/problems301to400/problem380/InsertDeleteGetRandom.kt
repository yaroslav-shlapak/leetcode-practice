package com.shlapak.yaroslav.leetcode.problems301to400.problem380


/**
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 *
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
import kotlin.random.Random

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

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */