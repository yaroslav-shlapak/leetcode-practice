package com.shlapak.yaroslav.leetcode.problems.p0047

/**
 * LeetCode 47: Permutations II.
 *
 * Generates unique permutations of input values that may repeat.
 *
 * @see <a href="https://leetcode.com/problems/permutations-ii/">Problem statement</a>
 */
class Permutations2 {

    lateinit var res: MutableSet<List<Int>>
    lateinit var array: IntArray
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        array = nums
        res = mutableSetOf()
        backtrack(mutableListOf(), mutableSetOf())
        return res.toList()
    }

    private fun backtrack(temp: MutableList<Int>, set: MutableSet<Int>) {
        if (array.size == temp.size && !res.contains(temp)) {
            val list = temp.toList()
            res.add(list)
        } else {
            for (i in array.indices) {
                if (!set.contains(i)) {
                    temp.add(array[i])
                    set.add(i)
                    backtrack(temp, set)
                    temp.removeAt(temp.size - 1)
                    set.remove(i)
                }
            }
        }
    }
}
