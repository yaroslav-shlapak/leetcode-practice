package com.shlapak.yaroslav.leetcode.problems1to100.problem75

class SortColors2 {
    fun sortColors(nums: IntArray): Unit {
        var r = nums.lastIndex
        var l = 0
        var i = 0
        while (i <= r) {
            when (nums[i]){
                0 -> {
                    nums.swap(i, l)
                    i++
                    l++
                }
                1 -> i++
                2 -> {
                    nums.swap(i, r)
                    r--
                }
            }
        }
    }

    private fun IntArray.swap(first: Int, second: Int) {
        val temp = this[first]
        this[first] = this[second]
        this[second] = temp
    }
}

class SortColors {
    fun sortColors(nums: IntArray): Unit {
        val next = nums.rearrangeFromIndex(start = 0, target = 0)
        nums.rearrangeFromIndex(start = next, target = 1)
    }

    private fun IntArray.rearrangeFromIndex(start: Int, target: Int) : Int {
        var j = start
        for (i in start until this.size) {
            if (this[i] == target) {
                swap(i, j)
                j++
            }
        }
        return j
    }

    private fun IntArray.swap(first: Int, second: Int) {
        val temp = this[first]
        this[first] = this[second]
        this[second] = temp
    }
}