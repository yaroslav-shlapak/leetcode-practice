package com.shlapak.yaroslav.leetcode.problems1to100.problem78
/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 */
class SubsetsIterative {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>(listOf())

        for (num in nums) {
            val n = res.size
            for (i in 0 until n) {
                val newSubset = res[i].toMutableList()
                newSubset.add(num)
                res.add(newSubset)
            }
        }

        return res
    }

}

class SubsetsRecursive {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        fun backtrack(start: Int, current: MutableList<Int>) {
            res.add(current.toList())
            for (i in start until nums.size) {
                current.add(nums[i])
                backtrack( i + 1, current)
                current.removeLast()
            }
        }
        backtrack(0, mutableListOf())
        return res
    }
}

class SubsetsRecursive2 {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        // [1,2,3]
        // [1]
        val subset = mutableListOf<Int>()
        fun dfs(i: Int) {
            if (i >= nums.size) {
                res.add(subset.toList())
                return
            }

            subset.add(nums[i])
            dfs(i + 1)
            subset.removeLast()
            dfs(i + 1)
        }

        dfs(0)

        return res
    }
}